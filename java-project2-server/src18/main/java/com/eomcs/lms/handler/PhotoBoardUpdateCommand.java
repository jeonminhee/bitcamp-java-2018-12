package com.eomcs.lms.handler;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.mybatis.TransactionManager;

public class PhotoBoardUpdateCommand extends AbstractCommand {

  TransactionManager txManager;
  PhotoBoardDao photoBoardDao; // 서버의 PhotoBoardDaoImpl 객체를 대행하는 프록시 객체이다.
  PhotoFileDao photoFileDao;

  public PhotoBoardUpdateCommand(PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao, TransactionManager txManager) {
    this.txManager = txManager;
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
    this.name = "/photoboard/update";
  }

  @Override
  public void execute(Response response) throws Exception {

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

}
