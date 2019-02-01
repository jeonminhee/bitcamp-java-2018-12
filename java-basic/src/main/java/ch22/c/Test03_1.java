// primitive data type의 값을 출력하기 
package ch22.c;

import java.io.FileOutputStream;

public class Test03_1 {
  public static void main(String[] args) {

    
    try (FileOutputStream out = new FileOutputStream("data.bin")){
    
      int value = 0x22334455;
      
      out.write(value >> 24);
      out.write(value >> 16);
      out.write(value >> 8);
      out.write(value);
      
      // 위의 4바이트 value값을 출력하시오!
    
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("작성 완료!");
  }
}
