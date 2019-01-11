package bitcamp.lms;
import java.util.*;
import bitcamp.lms.handler.BoardHandler;
import bitcamp.lms.handler.LessonHandler;
import bitcamp.lms.handler.MemberHandler;
import java.sql.Date;


public class App {

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

        LessonHandler.addLesson();

      } else if (cmd.equals("/member/add")) {

        MemberHandler.addMember();

      } else if (cmd.equals("/board/add")) {

        BoardHandler.addBoard();

      } else if (cmd.equals("/lesson/list")) {

        LessonHandler.listLesson();

      } else if (cmd.equals("/member/list")) {

        MemberHandler.listMember();

      }  else if(cmd.equals("/board/list")) {

        BoardHandler.listBoard();

      }  else {
        System.out.println("실행할 수 없는 명령입니다.");
      } 
      System.out.println();
    }
  } 
}
