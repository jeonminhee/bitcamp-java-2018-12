package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

  public static void main(String[] args) {

    try(ServerSocket serverSocket = new ServerSocket(8080)){
      System.out.println("서버 시작!");
      while(true) {
        try(Socket socket = serverSocket.accept();
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){
          
          System.out.println("클라이언트와 연결되었음");
          Object response = in.readObject();
          System.out.println(response);
          
          out.writeObject(response);
          out.flush();

        } catch(Exception e) {
          e.printStackTrace();
        }
        System.out.println("클라이언트와의 연결을 끊었음");
      }

    } catch(Exception e) {
      e.printStackTrace();
    }
  }

}
