package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

  static ObjectOutputStream out;
  static ObjectInputStream in;

  public static void main(String[] args) {

    try(ServerSocket serverSocket = new ServerSocket(8080)){
      System.out.println("서버 시작!");
      while(true) {
        try(Socket socket = serverSocket.accept();
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){

          System.out.println("클라이언트와 연결되었음");
          
          MemberCommand.members.clear();
          BoardCommand.boards.clear();
          LessonCommand.lessons.clear();
          
          ServerApp.in = in;
          ServerApp.out = out;

          MemberCommand.in = in;
          MemberCommand.out = out;
          
          LessonCommand.in = in;
          LessonCommand.out = out;
          
          BoardCommand.in = in;
          BoardCommand.out = out;
          
          loop: while(true) {
            String request = in.readUTF();
            System.out.println(request);
            
            if(request.startsWith("/member/")) {
              MemberCommand.service(request);
            } else if(request.startsWith("/lesson/")) {
              LessonCommand.service(request);
            } else if(request.startsWith("/board/")) {
              BoardCommand.service(request);
            }else if (request.equals("quit")) {
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
    out.writeUTF("종료함!");
    out.flush();
  }

}
