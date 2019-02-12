// stateless 응용 - 계산 결과 유지하기
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class CalculatorServer3 {
  public static void main(String[] args) {

    // 클라이언트의 작업 결과를 저장할 Map 객체
    HashMap<Long, Integer> resultMap = new HashMap<>();

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");

      while (true) {
        try (Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());) {

          System.out.println("클라이언트와 연결됨! 요청처리 중. . . . .");

          long sessionId = Long.parseLong((in.readLine()));
          System.out.printf("세션ID : %d\n", sessionId);

          int result = 0;

          boolean isNewSessionId = false;

          if(sessionId == 0) {
            // 클라이언트에게 세션ID를 발급한 적이 없다면 새 세션 ID를 발급한다.
            sessionId = System.currentTimeMillis();
            isNewSessionId = true; // 세션 ID를 새로 발급했다고 표시한다.
          } else {
            // 클라이언트의 세션 ID로 기존에 저장된 결과 값을 가져온다.
            result = resultMap.get(sessionId); // auto-unboxing Integer.intValue
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
          // 계산결과를 세션 ID를 사용해서 서버에 저장한다.
          resultMap.put(sessionId, result);

          // 세션ID를 새로 발급했다면 클라이언트에게 알려준다.
          if(isNewSessionId) {
            out.println(sessionId);
          }
          out.printf("결과는 %d 입니다.\n", result);
          out.flush();
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