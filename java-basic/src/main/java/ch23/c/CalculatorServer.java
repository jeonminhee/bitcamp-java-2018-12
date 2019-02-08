// 계산기 서버 만들기
package ch23.c;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {
  
  
  public static void main(String[] args) {


    try(Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)){

      System.out.println("서버와 연결되었음!");

      
      try (Socket socket = serverSocket.accept();
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
          DataInputStream in = new DataInputStream(
              new BufferedInputStream(socket.getInputStream()))){

        out.writeUTF("계산기 서버에 오신 걸 환영합니다!\n 계산식을 입력하세요!\n 예) 23 + 7\n>");
        
         String str = in.readUTF(); 
         String tmp[] = str.split(" ");
         int left = Integer.parseInt(tmp[0]);
         int right = Integer.parseInt(tmp[2]);
         int result = 0;
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
         }
         
         out.writeUTF("결과는" + result + "입니다.");
         out.flush();
      } 

    } catch (Exception e) {e.printStackTrace();}    
    System.out.println("안녕히가세요!");
  }
}