// Stateless 클라이언트 만들기
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/*
Stateless 통신 방법
=> 서버에 연결한 후, 한 번 요청하고 응답 받은 후 연결을 끊는다.
=> 단점
  - 서버에 요청할 때 마다 연결해야한다.
  - 지속적으로 서버에 연결하는데 실행 시간이 소요된다.
=> 장점
  - 서버에 계속 연결된 상태가 아니기 때문에 서버 쪽에서 메모리를 많이 사용하지 않는다.
  - stateful 보다 더 많은 클라이언트 요청을 처리할 수 있다.
=> 예
  - 메신저, HTTP 프로토콜 등
 */
public class CalculatorClient {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);

    long sessionId = 0;
    
    while(true) {
      
      System.out.print("> ");
      String input = keyboard.nextLine();
      if(input.equalsIgnoreCase("quit")) {
        break;
      }
      
      // 서버에 요청할 때 연결을 하고 
      // 서버로부터 응답을 받으면 연결을 끊는다.
      // => 매번 요청할 때 마다 서버와 연결해야 하기 때문에 실행시간 중에 연결에 소요되는 시간이
      //    일정하게 걸린다.
      // => 대신 서버로부터 응답을 받은 후에 즉시 연결을 끊기 때문에 
      //    서버쪽에는 메모리가 낭비되지 않는다.
      try (Socket socket = new Socket("localhost", 8888);
          PrintStream out = new PrintStream(socket.getOutputStream());
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()))) {
        System.out.println("서버와 연결됨! 서버에게 계산 작업을 요청함!");
        
        out.println(sessionId);
        out.println(input);
        out.flush();

        if(sessionId == 0) {
          sessionId = Long.parseLong(in.readLine());
          System.out.printf("세션 아이디는 %d입니다.\n", sessionId);
        }
        String response = in.readLine();
        System.out.println(response);

      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("서버와 연결 끊음!");
    } // while문의 끝
    
    keyboard.close();
    
  } // main의 끝
}











