package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.agent.LessonAgent;
import com.eomcs.lms.domain.Lesson;

public class LessonAddCommand implements Command {

  Scanner keyboard;
  LessonAgent lessonagent;

  public LessonAddCommand(Scanner keyboard, LessonAgent lessonagent) {
    this.keyboard = keyboard;
    this.lessonagent = lessonagent;
  }

  @Override
  public void execute() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("수업명? ");
    lesson.setTitle(keyboard.nextLine());

    System.out.print("설명? ");
    lesson.setContents(keyboard.nextLine());

    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("총수업시간? ");
    lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));

    System.out.print("일수업시간? ");
    lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));

    try {
      lessonagent.add(lesson);
      System.out.println("저장하였습니다.");
    } catch (Exception e) {
      System.out.printf("게시글 저장 오류 : %s\n", e.getMessage());
    }
  }
  
}
