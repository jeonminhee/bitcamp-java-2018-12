package com.eomcs.lms.handler;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.agent.BoardAgent;
import com.eomcs.lms.domain.Board;

public class BoardListCommand implements Command {

  Scanner keyboard;
  BoardAgent boardagent;
  
  public BoardListCommand(Scanner keyboard, BoardAgent boardagent) {
    this.keyboard = keyboard;
    this.boardagent = boardagent;
  }

  @Override
  public void execute() {
    try {
      
      List<Board> boards = boardagent.list();
      
      for (Board board : boards) {
        System.out.printf("%3d, %-20s, %s, %d\n", 
            board.getNo(), board.getContents(), 
            board.getCreatedDate(), board.getViewCount());
      }
      
    } catch (Exception e) {
      System.out.printf("게시글 목록 출력 오류! : %s\n", e.getMessage());
    }
  }

}
