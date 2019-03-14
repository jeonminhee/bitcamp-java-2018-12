package com.eomcs.lms.handler;
import com.eomcs.lms.context.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

@Component("/board/update")
public class BoardUpdateCommand extends AbstractCommand {

  BoardDao boardDao; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.

  public BoardUpdateCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute(Response response) throws Exception {

      
      int no = response.requestInt("번호? ");
      Board board = boardDao.findByNo(no);
      if(board == null) {
        response.println("해당 번호의 게시판이 없습니다.");
        return;
      }
      
      Board temp = new Board();
      temp.setNo(no);
      
      String input = response.requestString(String.format("내용(%s)?", board.getContents()));
      if (input.length() > 0) 
        temp.setContents(input);
      
      if(temp.getContents() != null) {
        boardDao.update(temp);
        response.println("변경했습니다.");
      } else {
        response.println("변경 취소했습니다.");
      }
      
  }

}
