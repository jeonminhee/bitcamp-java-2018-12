// 계산기 서버 만들기 - 강사님 코드
package ch23.c;

import java.net.ServerSocket;

public class CalculatorServer2 {


  public static void main(String[] args) {


    try(ServerSocket serverSocket = new ServerSocket(8888)){

      System.out.println("서버 실행 중 . . . ");

      while(true) {
        try {
        
          new CalculatorProcess(serverSocket.accept()).excute();
          
        } catch (Exception e) {
          System.out.println("클라이언트와 통신 중에 오류 발생!");
          e.printStackTrace();
        }
      }

    } catch (Exception e) {
      e.printStackTrace(); 
    } 
  } // main()의 끝
} // class의 끝











