// stateless 응용 - 계산 결과 유지하기
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CalculatorServer {
  public static void main(String[] args) {
    
    Map<Integer, Integer> res = new HashMap<>();
    
    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");
      
      // 서버의 Stateless 통신 방법에서 클라이언트를 구분하여 각 클라이언트의 계산 결과를 유지하려면?
      //
      while (true) {
        try (Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());) {
          
          System.out.println("클라이언트와 연결됨! 요청처리 중. . . . .");
          
          int id = Ran
          
          int key = in.read();
          
          int result = 0;
          
          if(res.get(key) != null) {
            result = res.get(key);
          }
          
          String response = in.readLine();
          if(response.equalsIgnoreCase("reset")) {
            res.put(key, 0);
            continue;
          }
          String[] input = response.split(" ");
          int b = 0;
          String op = " ";
          
          try {

          op = input[0];
          b = Integer.parseInt(input[1]);
          } catch (Exception e) {
            out.println("식의 형식이 바르지 않습니다.");
            out.flush();
            continue;
          }
          switch (op) {
            case "+": result += b; break;
            case "-": result -= b; break;
            case "*": result *= b; break;
            case "/": result /= b; break;
            case "%": result %= b; break;
            default:
              out.printf("%s 연산자를 지원하지 않습니다.\n", op);
              out.flush();
              continue;
          }
          
          out.printf("결과는 %d 입니다.\n", result);
          out.flush();
          res.put(key, result);
          System.out.println("클라이언트와 연결 끊음!");
          
        } catch(Exception e) {
          // 클라이언트 요청을 처리하다 예외가 발생하면 무시하고 연결을 끊는다.
          System.out.println("클라이언트와 통신 중 오류 발생!");
        }

      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
