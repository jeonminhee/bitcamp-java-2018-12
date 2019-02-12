package com.eomcs.lms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerTest {

  public static void main(String[] args) {

    try(Socket socket = new Socket("localhost", 8080);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
      System.out.println("서버와 연결되었음");

      out.println("Hello!");
      out.flush();
      
      String response = in.readLine();
      System.out.println(response);
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버와의 연결을 끊었음");
  }

}
