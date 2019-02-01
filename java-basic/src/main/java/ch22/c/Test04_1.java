// 바이트 데이터를 읽어 primitive data type으로 바꾸기 
package ch22.c;

import java.io.FileInputStream;

public class Test04_1 {
  public static void main(String[] args) {

    
    try (FileInputStream in = new FileInputStream("data.bin")){

      // 파일에서 4바이트를 읽어 int 변수에 저장하라!
      int value = 0;
      
      value = value | (in.read() << 24);
      // 0x00000022 <== read()의 리턴 값
      // 0x22000000 <== 24비트 왼쪽으로 이동
      //   0x00000000
      //  |0x22000000
      // ------------------
      //   0x22000000
      value = value | (in.read() << 16);
      value = value | (in.read() << 8);
      value = value | (in.read());
      
      System.out.println(Integer.toHexString(value));
      
       
     }
       
     catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("읽기 완료!");
  }
}
