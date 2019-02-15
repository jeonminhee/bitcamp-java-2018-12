package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.agent.MemberAgent;

public class MemberDeleteCommand implements Command {
  
  Scanner keyboard;
  MemberAgent memberagent;
  
  public MemberDeleteCommand(Scanner keyboard, MemberAgent memberagent) {
    this.keyboard = keyboard;
    this.memberagent = memberagent;
  }
  
  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      memberagent.delete(no);
      System.out.println("회원을 삭제했습니다.");
    } catch (Exception e) {
      System.out.printf("게시글 삭제 오류 : %s\n", e.getMessage());
    }
    
  }
}
