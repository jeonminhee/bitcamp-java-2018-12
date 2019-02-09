// 계산기 클라이언트 만들기
package ch23.c;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {

  public static void main(String[] args) {
    try(Socket socket = new Socket("localhost",8888);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        Scanner keyboard = new Scanner(System.in)){

      System.out.println(in.readUTF());

      while(true) {
        System.out.println(">");
        String input = keyboard.nextLine();
        out.writeUTF(input);
        out.flush();

        System.out.println(in.readUTF());
        if(input.equals("quit")) {
          break;
        }
      }


    } catch (Exception e) {e.printStackTrace();}
  }
}
