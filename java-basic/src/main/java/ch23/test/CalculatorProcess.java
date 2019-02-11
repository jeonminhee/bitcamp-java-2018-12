package ch23.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class CalculatorProcess {
  
  Socket socket;
  PrintStream out;
  BufferedReader in;
  
  public CalculatorProcess(Socket socket) throws Exception {
    this.socket = socket;
    this.out = new PrintStream(socket.getOutputStream());
    this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
  }
  
  public void excute() throws Exception {
    try (Socket socket = this.socket;
        BufferedReader in = this.in;
        PrintStream out = this.out) {
      
      sendGreeting();
      
      while (true) {
        String str = in.readLine();
        if (isQuit(str)) 
          break;
        
        calculate(str);
      }
    }
  }

  private void sendGreeting() {
    out.println("계산기 서버에 오신 걸 환영합니다!");
    out.println("계산식을 입력하세요!");
    out.println("예) 23 + 7");
    out.println();
    out.flush();
  }

 private void calculate(String str) {
    try {
      String[] input = str.split(" ");

      int a = Integer.parseInt(input[0]);
      String op = input[1];
      int b = Integer.parseInt(input[2]);
      int result = 0;

      switch(op) {
        case "+" :
          result = a + b; break;
        case "-" :
          result = a - b; break;
        case "*" :
          result = a * b; break;
        case "/" :
          result = a / b; break;
        case "%" :
          result = a % b; break;
        default :
          out.printf("%s 연산자를 지원하지 않습니다.\n", op);
          out.flush();
          return;
      }

      out.printf("결과는 %d입니다.\n", result);
      out.flush();

    } catch (Exception e) {
      try {
        out.println("식의 형식이 잘못되었습니다.");
        out.flush();
      } catch (Exception e2) {}
    }
  }
  private boolean isQuit (String str) {

    if(str.equalsIgnoreCase("quit")) {
      out.println("안녕히가세요!");
      out.flush();
      return true;
    } else {
      return false;
    }
  }
  
}
