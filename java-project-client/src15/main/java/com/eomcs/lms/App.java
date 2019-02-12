package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.*;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    BoardHandler Board1 = new BoardHandler(keyboard);

    BoardHandler Board2 = new BoardHandler(keyboard);

    LessonHandler Lesson1 = new LessonHandler(keyboard);

    MemberHandler Member1 = new MemberHandler(keyboard);




    while (true) {
      String command = prompt();

      if (command.equals("/lesson/add")) {
        Lesson1.addLesson();

      } else if (command.equals("/lesson/list")) {
        Lesson1.listLesson();

      }else if (command.equals("/lesson/detail")) {
        Lesson1.detailLesson();

      } else if (command.equals("/lesson/delete")) {
        Lesson1.deleteLesson();

      } else if (command.equals("/lesson/update")) {
        Lesson1.updateLesson();

      }else if (command.equals("/member/add")) {
        Member1.addMember();

      } else if (command.equals("/member/list")) {
        Member1.listMember();

      } else if (command.equals("/board/add")) {
        Board1.addBoard();

      } else if (command.equals("/board/list")) {
        Board1.listBoard();

      } else if (command.equals("/board2/add")) {
        Board2.addBoard();

      } else if (command.equals("/board2/list")) {
        Board2.listBoard();

      } else if(command.equals("/lesson/detail")) {
        Lesson1.detailLesson();
        
      } else   if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println(); // 결과 출력 후 빈 줄 출력
    }

    keyboard.close();
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
