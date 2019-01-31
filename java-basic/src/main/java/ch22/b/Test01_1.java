// 바이너리 데이터 입출력 - FileOutputStream 클래스 사용법
package ch22.b;

import java.io.FileOutputStream;

public class Test01_1 {
  public static void main(String[] args) {

    // 파일로 바이너리 데이터 출력
    // 
    try {
      // 1) 데이터를 출력을 담달할 객체를 생성한다.
    FileOutputStream out = new FileOutputStream("data.bin");
    
    // 2) 데이터를 출력한다,
    out.write(2);
    out.write(40);
    out.write(100);
    out.write(101);
    out.write(102);
    out.write(127);
    out.write(0x11223344);
    out.write(0x55667788);
    out.close();
    
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("출력 완료!");
  }
}
