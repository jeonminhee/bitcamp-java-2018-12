package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonHandler {

  Scanner keyboard;
  ArrayList<Lesson> list;
  
  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<>();
  }
  
  public void listLesson() {
    Lesson[] lessons = list.toArrays(new Lesson[0]);
    for (Lesson lesson : lessons) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lesson.getNo(), lesson.getTitle(), lesson.getStartDate(), 
          lesson.getEndDate(), lesson.getTotalHours());
    }
  }

  public void addLesson() {
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

    // i 번째 배열에 수업 정보를 담고 있는 Lesson 객체(의 주소)를 보관한다.
    list.add(lesson);

    System.out.println("저장하였습니다.");
  }
  
  public void detailLesson() {
 
    Lesson[] lessons = list.toArrays(new Lesson[0]);

   for(int j = 0; j == lessons.length; j++) {
     System.out.print("번호? ");
     String num  = keyboard.nextLine();
     int a = Integer.parseInt(num);
      if(a==(lessons[j].getNo())) {
        System.out.printf("수업명 : %s\n 수업내용 : %s\n 기간 : %s~%s\n 총수업시간 : %d\n 일수업시간 : %d\n",
            lessons[j].getTitle(), lessons[j].getContents(), lessons[j].getStartDate(), lessons[j].getEndDate(),
            lessons[j].getTotalHours(), lessons[j].getDayHours());
      } else {
        System.out.println("해당 수업 번호를 찾을 수 없습니다.");
 
      }
    }
  }
  }
  

