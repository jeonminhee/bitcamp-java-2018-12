package bitcamp.lms;
import java.util.*;
import java.sql.Date;


public class App {

  static final int LENGTH = 10;
  static Lesson[] l1 = new Lesson[LENGTH];
  static Member[] m1 = new Member[LENGTH];
  static Board[] b1 = new Board[LENGTH];


  public static String prompt () {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    return str;
  }

  public static void main(String[] args) {

    while(true) {

      System.out.print("명령 > ");
      String cmd = prompt();

      if(cmd.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (cmd.equals("/lesson/add")) {

        LessonHandler.addLesson(l1);

      } else if (cmd.equals("/member/add")) {

        MemberHandler.addMember(m1);

      } else if (cmd.equals("/board/add")) {

        BoardHandler.addBoard(b1);

      } else if (cmd.equals("/lesson/list")) {

        LessonHandler.listLesson(l1);

      } else if (cmd.equals("/member/list")) {

        MemberHandler.listMember(m1);

      }  else if(cmd.equals("/board/list")) {

        BoardHandler.listBoard(b1);

      }  else {
        System.out.println("실행할 수 없는 명령입니다.");
      } 
      System.out.println();
    }
  } 
}
