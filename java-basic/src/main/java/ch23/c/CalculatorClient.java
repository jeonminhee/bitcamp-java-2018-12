// 계산기 클라이언트 만들기
package ch23.c;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {

  public static void main(String[] args) {
    try(Socket socket = new Socket("localhost",8888);
        DataOutputStream out = new DataOutputStream(
            new BufferedOutputStream(socket.getOutputStream()));
        DataInputStream in = new DataInputStream(socket.getInputStream());
            Scanner keyboard = new Scanner(System.in)){

      System.out.println(in.readUTF());
      
      out.writeUTF(keyboard.nextLine());

      System.out.println(in.readUTF());
      out.flush();



    } catch (Exception e) {e.printStackTrace();}
  }
}
