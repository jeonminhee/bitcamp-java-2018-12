package com.eomcs.lms.handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.eomcs.lms.context.Component;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.mybatis.TransactionManager;

@Component
public class PhotoBoardCommand {

  TransactionManager txManager;
  PhotoBoardDao photoBoardDao; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.
  PhotoFileDao photoFileDao;

  public PhotoBoardCommand(PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao, TransactionManager txManager) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
    this.txManager = txManager;
  }

  @RequestMapping("/photoboard/list")
  public void list(Response response) throws Exception {
    List<PhotoBoard> boards = photoBoardDao.findAll(null);

    for (PhotoBoard board : boards) {
      response.println(
          String.format("%3d, %-20s, %s, %d, %d", 
              board.getNo(), board.getTitle(), 
              board.getCreatedDate(), board.getViewCount(),
              board.getLessonNo()));
    }

  }

  @RequestMapping("/photoboard/add")
  public void add(Response response) throws Exception{

    txManager.beginTransaction();

    try {
      PhotoBoard board = new PhotoBoard();
      board.setTitle(response.requestString("사진 제목? "));
      board.setLessonNo(response.requestInt("수업? "));
      photoBoardDao.insert(board);

      response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
      response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");


      ArrayList<PhotoFile> files = new ArrayList<>();
      while(true) {
        String filePath = response.requestString("사진 파일?");
        if (filePath.length() == 0) {
          if(files.size() == 0) {
            response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
            continue;
          } else {
            break;
          }
        }

        PhotoFile file = new PhotoFile();
        file.setFilePath(filePath);
        file.setPhotoBoardNo(board.getNo());// 사진 게시물을 입력 한 후 자동 생성된 PK 값을 꺼낸다.
        files.add(file);
      }

      photoFileDao.insert(files);
      response.println("저장하였습니다.");
      txManager.commit();

      // 트랜잭션 종료
      // 여기서 commit을 수행하는 대신에 이 메서드를 호출한 execute(BufferedReader, PrintWriter) 메서드에서 호출하면 된다.
      // ApplicationInitializer.con.commit();

      // commit() 호출하지 않아도 목록데이터를 조회할 때 입력된 내용이 출력된다.
      // 엥, commit()을 안해도 된다는 것인가?
      // => commit() 하지 않아도 같은 커넥션에 대해 목록을 조회하면 
      //    임시 DB에 보관된 내용까지 함께 조회하기 때문에 
      //    겉으로 봐서는 데이터 변경(insert,update,delete)이 완료된 것처럼 보여진다.
      // => 하지만 커넥션을 끊고 다시 커넥션을 연결한 후 데이터를 조회해보면
      //    commit() 하지 않아서 임시 DB에 보관되었던 데이터를 조회할 때 출력되지 않는다.
      //    즉 commit()하지 않은 데이터는 커넥션을 끊을 때 자동 제거된다.
    } catch (Exception e) {
      e.printStackTrace();
      response.println("저장 중 오류가 발생했습니다.");
      txManager.rollback();
    }
  }

  @RequestMapping("/photoboard/detail")
  public void detail(Response response) throws Exception {

    int no = response.requestInt("번호? ");

    // lms_photo 테이블의 데이터와 lms_photo_file 테이블의 데이터를 조인하여 결과를 가져온다.
    // 그 결과를 PhotoBoard 객체에 저장한다.
    // 특히 lms_photo_file 데이터는 PhotoFile 객체에 저장되고,
    // 그 목록은 PhotoBoard 객체에 포함되어 리턴된다.
    PhotoBoard board = photoBoardDao.findByNoWithFile(no);

    if(board == null) {
      response.println("해당 사진을 찾을 수 없습니다.");
      return;
    }

    photoBoardDao.increaseCount(no); // 조회수 증가

    response.println(String.format("내용: %s", board.getTitle()));
    response.println(String.format("작성일: %s", board.getCreatedDate()));
    response.println(String.format("조회수: %d", board.getViewCount()));

    response.println(String.format("수업 : %s(%s~%s)", 
        board.getLesson().getTitle(),
        board.getLesson().getStartDate(),
        board.getLesson().getEndDate()));

    response.println("사진파일:");

    List<PhotoFile> files = board.getFiles();
    for(PhotoFile file : files) {
      response.println(String.format("> %s", file.getFilePath()));
    }

  }

  @RequestMapping("/photoboard/update")
  public void update(Response response) throws Exception {

    txManager.beginTransaction();

    try {
      PhotoBoard board = new PhotoBoard();
      board.setNo(response.requestInt("번호?"));

      PhotoBoard origin = photoBoardDao.findByNo(board.getNo());
      if (origin == null) {
        response.println("해당 번호의 사진이 없습니다.");
        return;
      }

      String input = response.requestString(
          String.format("제목(%s)?", origin.getTitle()));
      if(input.length() > 0) {
        board.setTitle(input);
        photoBoardDao.update(board); // 사진 게시물 제목 변경
      }


      // 변경하려는 사진 게시물의 첨부 파일을 출력한다.
      response.println("사진 파일 :");
      List<PhotoFile> files = photoFileDao.findByPhotoBoardNo(board.getNo());
      for(PhotoFile file : files) {
        response.println("> " + file.getFilePath());
      }
      response.println("");

      response.println("사진은 일부만 변경할 수 없습니다.");
      response.println("전체를 새로 등록해야합니다.");
      input = response.requestString("사진을 변경하시겠습니까? (y/N)");
      if(input.equalsIgnoreCase("y")) {
        // 먼저 기존 첨부 파일을 삭제한다.
        photoFileDao.deleteByPhotoBoardNo(board.getNo());

        // 그리고 새 첨부 파일을 추가한다.
        response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
        response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");


        ArrayList<PhotoFile> photoFiles = new ArrayList<>();
        while(true) {
          String filePath = response.requestString("사진 파일?");
          if (filePath.length() == 0) {
            if(photoFiles.size() == 0) {
              response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
              continue;
            } else {
              break;
            }
          }

          PhotoFile file = new PhotoFile();
          file.setFilePath(filePath);
          file.setPhotoBoardNo(board.getNo());// 사진 게시물을 입력 한 후 자동 생성된 PK 값을 꺼낸다.
          photoFiles.add(file);
        }
        photoFileDao.insert(photoFiles);
      }

      response.println("변경했습니다.");
      txManager.commit();

    } catch (Exception e) {
      response.println("변경 중 오류 발생.");
      txManager.rollback();
    }
  }


  @RequestMapping("/photoboard/search")
  public void search(Response response) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    try {
      int lessonNo = response.requestInt("사진 파일 번호? ");
      params.put("lessonNo", lessonNo);
    } catch (Exception e) {}

    try {
      String keyword = response.requestString("검색어? ");
      if(keyword.length() > 0) {
        //SQL에서 검색할 때 사용할 문자열 패턴을 다음과 같이 자바에서 만들어 전달할 수 있다. 
        //params.put("keyword", "%" + keyword + "%");

        // 또는 다음과 같이 키워드를 전달한 후 mybatis 쪽에서 패턴을 정의할 수 있다.
        params.put("keyword", keyword);
      }
    } catch (Exception e) {}


    List<PhotoBoard> boards = photoBoardDao.findAll(params);

    response.println("[검색 결과] : ");
    for (PhotoBoard board : boards) {
      response.println(
          String.format("%3d, %-20s, %s, %d, %d", 
              board.getNo(), board.getTitle(), 
              board.getCreatedDate(), board.getViewCount(),
              board.getLessonNo()));
    }

  }

  @RequestMapping("/photoboard/delete")
  public void delete(Response response) throws Exception {

    txManager.beginTransaction();

    try {
      int no = response.requestInt("번호? ");

      // 데이터를 지울 때는 자식 테이블의 데이터부터 지워야한다.
      photoFileDao.deleteByPhotoBoardNo(no);

      if(photoBoardDao.delete(no) == 0) {
        response.println("해당 번호의 사진이 없습니다.");
      }
      response.println("삭제했습니다.");
      txManager.commit();
    } catch (Exception e) {
      response.println("삭제 중 오류 발생.");
      txManager.rollback();
    }
  }

}
