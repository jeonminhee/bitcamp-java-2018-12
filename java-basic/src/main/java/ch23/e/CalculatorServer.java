// stateless 서버 만들기
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class CalculatorServer {
  public static void main(String[] args) {

    HashMap<Long, Integer> map = new HashMap<>();

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");

      // 서버의 Stateless 통신 방법
      // => Client 요청이 들어오면 작업을 수행하고 응답을 한다.
      //    응답한 후에 즉시 연결을 끊는다.
      while (true) {
        
        System.out.println("클라이언트와 연결됨! 요청처리 중. . . . .");
        try (Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());) {

          long Id = Long.parseLong(in.readLine());
          System.out.printf("세션 ID : %d\n", Id);
          
          boolean NewId = false;
          int result = 0;
          
          if(Id == 0) {
            Id = System.currentTimeMillis();
            NewId = true;
          } else {
            result = map.get(Id);
          }

          String[] input = in.readLine().split(" ");
          int b = 0;
          String op = null;

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

          map.put(Id, result);
          
          if(NewId) {
            out.println(Id);
          }
          out.printf("결과는 %d 입니다.\n", result);
          out.flush();

        } catch(Exception e) {
          // 클라이언트 요청을 처리하다 예외가 발생하면 무시하고 연결을 끊는다.
          System.out.println("클라이언트와 통신 중 오류 발생!");
        }

        System.out.println("클라이언트와 연결 끊음!");

      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
