package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.agent.LessonAgent;

public class LessonDeleteCommand implements Command {

  Scanner keyboard;
  LessonAgent lessonagent;

  public LessonDeleteCommand(Scanner keyboard, LessonAgent lessonagent) {
    this.keyboard = keyboard;
    this.lessonagent = lessonagent;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      lessonagent.delete(no);
      System.out.println("수업을 삭제했습니다.");
    } catch (Exception e) {
      System.out.printf("게시글 삭제 오류 : %s\n", e.getMessage());
    }

  }

}
