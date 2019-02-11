package ch23.test;

import java.net.ServerSocket;

public class CalculatorServer {

  public static void main(String[] args) {

    try(ServerSocket serverSocket = new ServerSocket(8888)){

      System.out.println("클라이언트를 기다리는 중 . . .");

      while(true) {
        try{
          new CalculatorProcess(serverSocket.accept()).excute();
        } catch (Exception e) {
          System.out.println("클라이언트와 통신 중 문제 발생!");
          e.printStackTrace();
        }

      }

    } catch(Exception e){
      e.printStackTrace();
    }
  }
}
