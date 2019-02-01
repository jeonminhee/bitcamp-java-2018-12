// 데코레이터를 여러 개 연결하기 
package ch22.c;

import java.io.FileOutputStream;

public class Test03_3 {
  public static void main(String[] args) {

    
    try (FileOutputStream out = new FileOutputStream("data.bin");
        BufferedOutputStream out1 = new BufferedOutputStream(out);
        DataOutputStream out2 = new DataOutputStream(out)){
    
      int no = 200;
      String name = "ABC가각간갇갈";
      int age = 30;

      out2.writeInt(no);
      out2.writeUTF(name);
      out2.writeInt(age);
      
      out2.flush();
      // 위의 4바이트 value값을 출력하시오!
    
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("작성 완료!");
  }
}
