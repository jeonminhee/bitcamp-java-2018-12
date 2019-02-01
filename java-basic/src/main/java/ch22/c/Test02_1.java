// 버퍼 사용 - 사용 전
package ch22.c;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test02_1 {
  public static void main(String[] args) {

    FileOutputStream out = null;
    try {
    out = new FileOutputStream("data.bin");
    
    System.out.println("데이터 쓰는 중 . . . .");
    
    long start = System.currentTimeMillis();
    
    for (int i = 0; i < 1000000; i++) {
      out.write(0x55);
    }
    
      long end = System.currentTimeMillis();
      
      System.out.println(end - start);
    
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      
      try {out.close();} catch (IOException e) {}
    }
    
    System.out.println("작성 완료!");
  }
}
