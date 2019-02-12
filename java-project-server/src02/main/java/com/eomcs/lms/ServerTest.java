package com.eomcs.lms;

import java.net.Socket;

public class ServerTest {

  public static void main(String[] args) {

    try(Socket socket = new Socket("localhost", 8080)){
      System.out.println("서버와 연결되었음");

    } catch(Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버와의 연결을 끊었음");
  }

}
