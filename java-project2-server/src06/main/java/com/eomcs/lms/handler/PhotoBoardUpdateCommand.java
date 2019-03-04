package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardUpdateCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao; // 서버의 PhotoBoardDaoImpl 객체를 대행하는 프록시 객체이다.

  public PhotoBoardUpdateCommand(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void execute(Response response) throws Exception {

      PhotoBoard board = new PhotoBoard();
      
      board.setNo(response.requestInt("번호? "));
      
      board.setTitle(response.requestString("내용? "));
      
      if(photoBoardDao.update(board) == 0) {
        response.println("해당 게시물이 없습니다.");
        return;
      }
      
      response.println("변경했습니다.");
      
  }

}
