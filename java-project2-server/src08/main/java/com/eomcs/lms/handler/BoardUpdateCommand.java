package com.eomcs.lms.handler;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand extends AbstractCommand {

  BoardDao boardDao; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.

  public BoardUpdateCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute(Response response) throws Exception {

      Board board = new Board();
      
      board.setNo(response.requestInt("번호? "));
      
      board.setContents(response.requestString("내용? "));
      
      if(boardDao.update(board) == 0) {
        response.println("해당 게시물이 없습니다.");
        return;
      }
      
      response.println("변경했습니다.");
      
  }

}
