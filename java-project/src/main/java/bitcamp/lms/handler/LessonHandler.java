package bitcamp.lms.handler;

import java.sql.Date;
import bitcamp.lms.App;
import bitcamp.lms.domain.Lesson;

public class LessonHandler {
  
  static int size = 0;
  static Lesson[] l1 = new Lesson[App.LENGTH];
  
  
  public static void listLesson() {

    for(int j = 0; j < size; j++) {
      System.out.printf("%d, %-15s, %s ~ %s, %s\n", 
          l1[j].num, l1[j].title, l1[j].start_date, l1[j].end_date, l1[j].full_time);
    }
  }
  
  public static void addLesson() {


    Lesson l2 = new Lesson();

    System.out.print("번호? ");
    l2.num = Integer.parseInt(App.prompt());

    System.out.print("수업명? ");
    l2.title = App.prompt();

    System.out.print("수업내용? ");
    l2.study = App.prompt();

    System.out.print("시작일? ");
    l2.start_date = Date.valueOf(App.prompt());

    System.out.print("종료일? ");
    l2.end_date = Date.valueOf(App.prompt());

    System.out.print("총수업시간? ");
    l2.full_time = App.prompt();

    System.out.print("일수업시간? ");
    l2.day_time = App.prompt();

    l1[size] = l2;

    size++;

    System.out.println("저장하였습니다.");

  }

}
