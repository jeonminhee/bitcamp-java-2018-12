package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

// 명령어를 처리하는 객체는 일관성 있는 사용을 위해 Command 규칙에 따라 작성되어야한다.
// 그래야 App 클래스에서 일관된 방식으로 사용할 수 있다.
public class BoardListCommand implements Command {
  Scanner keyboard;
  List<Board> list;
  
  public BoardListCommand(Scanner keyboard, List<Board> list) {
    this.keyboard = keyboard;
    this.list = list; 
  }
  
  public void execute() {
    Board[] boards = new Board[list.size()];
    list.toArray(boards);
    for (Board board : boards) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          board.getNo(), board.getContents(), 
          board.getCreatedDate(), board.getViewCount());
    }
  }

}
