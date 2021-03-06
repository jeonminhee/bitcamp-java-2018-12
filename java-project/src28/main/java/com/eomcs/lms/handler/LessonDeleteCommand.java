package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonDeleteCommand implements Command {
  Scanner keyboard;
  List<Lesson> list;

  public LessonDeleteCommand(Scanner keyboard, List<Lesson> list) {
    this.keyboard = keyboard;
    this.list = list; // 파라미터로 주입된 의존 객체를 저장한다.
  }
  
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    int index = indexOfLesson(no);
    if (index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return;
    }
    
    list.remove(index);
    
    System.out.println("수업을 삭제했습니다.");
    }
  
  private int indexOfLesson(int no) {
    for (int i = 0; i < list.size(); i++) {
      Lesson l = list.get(i);
      if (l.getNo() == no)
        return i;
    }
    return -1;
  }
}
