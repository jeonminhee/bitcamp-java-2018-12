// 계산기 서버 만들기
package ch23.c;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {


  public static void main(String[] args) {


    try(ServerSocket serverSocket = new ServerSocket(8888)){

      System.out.println("사용자를 기다리는 중 . . .");

      try (Socket socket = serverSocket.accept();
          DataOutputStream out = 
              new DataOutputStream(socket.getOutputStream());
          DataInputStream in = 
              new DataInputStream(socket.getInputStream())){

        out.writeUTF("계산기 서버에 오신 걸 환영합니다!\n 계산식을 입력하세요!\n 예) 23 + 7\n");
        out.flush();

        int result = 0;
        String output = "";

        while(true) {

          String str = in.readUTF();

          if(str.equals("quit")) {
            out.writeUTF("안녕히가세요!");
            out.flush();
            break;
          }

          try {
            String tmp[] = str.split(" ");
            int left = Integer.parseInt(tmp[0]);
            int right = Integer.parseInt(tmp[2]);

            switch(tmp[1]) {
              case "+" :
                result = left + right;
                break;
              case "-" :
                result = left - right;
                break;
              case "*" :
                result = left * right;
                break;
              case "%" :
                result = left % right;
                break;
              default : 
                out.writeUTF((tmp[1] + "연산자를 지원하지 않습니다."));
                continue;
            }

            output = "결과는 " + result + " 입니다.";
            out.writeUTF(output);
            out.flush();

          } catch (Exception e) {

            out.writeUTF("식의 형식이 잘못되었습니다.");
            out.flush();
            continue;

          }

        } // while의 끝

      } 

    } catch (Exception e) {e.printStackTrace();}    

  } // main()의 끝
}









