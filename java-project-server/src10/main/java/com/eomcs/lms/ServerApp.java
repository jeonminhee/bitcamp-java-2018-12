package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.eomcs.lms.service.BoardService;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.MemberService;

public class ServerApp {

  static ObjectOutputStream out;
  static ObjectInputStream in;

  static MemberService memberService = null;
  static LessonService lessonService = null;
  static BoardService boardService = null;
  
  public static void main(String[] args) {

    try(ServerSocket serverSocket = new ServerSocket(8080)){
      System.out.println("서버 시작!");

      try {
        memberService = new MemberService();
        memberService.loadData("member.bin");
      } catch (Exception e) {
        System.out.println("회원 로딩 중 오류 발생!");
        //e.printStackTrace();
      }
      try {
        lessonService = new LessonService();
        lessonService.loadData("lesson.bin");
      } catch (Exception e) {
        System.out.println("수업 로딩 중 오류 발생!");
       // e.printStackTrace();
      }
      try {
        boardService = new BoardService();
        boardService.loadData("board.bin");
      } catch (Exception e) {
        System.out.println("게시물 로딩 중 오류 발생!");
        //e.printStackTrace();
      }
      
      while(true) {
        try(Socket socket = serverSocket.accept();
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){

          boardService.init(in, out);
          lessonService.init(in, out);
          memberService.init(in, out);
          
          
          System.out.println("클라이언트와 연결되었음");

          ServerApp.in = in;
          ServerApp.out = out;


          loop: while(true) {
            String request = in.readUTF();
            System.out.println(request);

            if(request.startsWith("/member/")) {
              memberService.excute(request);
            } else if(request.startsWith("/lesson/")) {
              lessonService.excute(request);
            } else if(request.startsWith("/board/")) {
              boardService.execute(request);
            } else if (request.equals("quit")) {
              quit();
              break loop;
            } else {
              out.writeUTF("FAIL");
            }
            out.flush();
          }

        } catch(Exception e) {
          e.printStackTrace();
        }
        System.out.println("클라이언트와의 연결을 끊었음");
      }

    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  static void quit() throws Exception {
    try {
    boardService.saveDate();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      //e.printStackTrace();
    }
    try {
    memberService.saveDate();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      //e.printStackTrace();
    }
    try {
    lessonService.saveDate();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      //e.printStackTrace();
    }
    out.writeUTF("종료함!");
    out.flush();
  }

}
