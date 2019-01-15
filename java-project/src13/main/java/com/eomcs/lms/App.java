package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.*;

public class App {
  
  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    LessonHandler list1 = new LessonHandler();
    list1.keyboard = keyboard;
    
    MemberHandler member1 = new MemberHandler();
    member1.keyboard = keyboard;
    
    BoardHandler board1 = new BoardHandler();
    board1.keyboard = keyboard;
    
    BoardHandler board2 = new BoardHandler();
    board2.keyboard = keyboard;
    
    BoardHandler board3 = new BoardHandler();
    board3.keyboard = keyboard;
    
    while (true) {

      String command = prompt();

      if (command.equals("/lesson/add")) {
        
        list1.addLesson();

      } else if (command.equals("/lesson/list")) {

        list1.listLesson();

      } else if (command.equals("/member/add")) {

        member1.addMember();

      } else if (command.equals("/member/list")) {

        member1.listMember();

      } else if (command.equals("/board/add")) {

        board1.addBoard();

      } else if (command.equals("/board/list")) {

        board1.listBoard();

      } else if (command.equals("/board2/add")) {

        board2.addBoard();

      } else if (command.equals("/board2/list")) {

        board2.listBoard();

      } else if (command.equals("/board3/add")) {

        board3.addBoard();

      } else if (command.equals("/board3/list")) {

        board3.listBoard();

      } else if (command.equals("quit")) {
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
    return keyboard.nextLine();
  }


  
}