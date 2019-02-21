package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardDetailCommand implements Command {
  
  Scanner keyboard;
  BoardDao boardDao; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.
  
  public BoardDetailCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      Board board = boardDao.findByNo(no);
      System.out.printf("내용: %s\n", board.getContents());
      System.out.printf("작성일: %s\n", board.getCreatedDate());
      System.out.printf("조회수: %d\n", board.getViewCount());
    } catch (Exception e) {
      System.out.printf("게시글 상세 정보 출력 오류! : %s\n", e.getMessage());
    }
  }
}
