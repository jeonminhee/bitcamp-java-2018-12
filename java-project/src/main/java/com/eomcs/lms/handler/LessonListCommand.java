package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {
  Scanner keyboard;
  List<Lesson> list;

  public LessonListCommand(Scanner keyboard, List<Lesson> list) {
    this.keyboard = keyboard;
    this.list = list; // 파라미터로 주입된 의존 객체를 저장한다.
  }
  
  public void execute() {
      Lesson[] lessons = list.toArray(new Lesson[0]);
      for (Lesson lesson : lessons) {
        System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
            lesson.getNo(), lesson.getTitle(), 
            lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
      }
    }
}
