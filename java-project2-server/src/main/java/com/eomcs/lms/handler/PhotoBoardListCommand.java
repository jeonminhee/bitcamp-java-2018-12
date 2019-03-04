package com.eomcs.lms.handler;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardListCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.

  public PhotoBoardListCommand(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    List<PhotoBoard> boards = photoBoardDao.findAll();

    for (PhotoBoard board : boards) {
      response.println(
          String.format("%3d, %-20s, %s, %d, %d", 
              board.getNo(), board.getTitle(), 
              board.getCreatedDate(), board.getViewCount(),
              board.getLessonNo()));
    }

  }
}
