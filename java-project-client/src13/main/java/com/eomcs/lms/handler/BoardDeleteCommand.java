package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.agent.BoardAgent;

public class BoardDeleteCommand implements Command {
  
  Scanner keyboard;
  BoardAgent boardagent;
  
  public BoardDeleteCommand(Scanner keyboard, BoardAgent boardagent) {
    this.keyboard = keyboard;
    this.boardagent = boardagent;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      boardagent.delete(no);
      System.out.println("게시글을 삭제했습니다.");
    } catch (Exception e) {
      System.out.printf("게시글 삭제 오류 : %s\n", e.getMessage());
    }
  }
}
