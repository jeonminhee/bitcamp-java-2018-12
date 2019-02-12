// stateless 응용 - 계산 결과 유지하기
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/*
Stateless는 응답을 받은 후에 연결을 끊는다.
다시 요청할 때는 서버와 연결을 다시 한다.
서버쪽에서는 어떻게 클라이언트를 구분하여 작업 결과를 유지할 것인가? 
 */
public class CalculatorClient3 {
  public static void main(String[] args) {
    
    
    Scanner keyboard = new Scanner(System.in);

    long sessionId = 0;
    
    while(true) {
      
      System.out.print("> ");
      String input = keyboard.nextLine();
      
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
        
        out.println(sessionId); // 서버에 먼저 세션 ID를 보낸다.
        out.println(input); // 사용자가 입력한 값을 보낸다.
        out.flush();

        if(input.equalsIgnoreCase("quit")) {
          System.out.println("서버와 연결 강제로 끊음!");
          break;
        }
        if(input.equalsIgnoreCase("reset")) {
          continue;
        }
        
        
        if(sessionId == 0) {
          // 서버에 보낸 Id가 0이면 서버는 세션 ID를 새로 발급하여 보내줄 것이다.
          // 받아야한다.
          sessionId = Long.parseLong(in.readLine());
          System.out.printf("발급받은 세션ID : %d\n", sessionId);
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











