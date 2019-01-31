// java.io.File 클래스 : 연습 과제 - bin 폴더를 삭제하라!
package ch22.a;

import java.io.File;

public class Test13 {

  public static void main(String[] args) throws Exception {
    
    File dir = new File("bin");

    delete(dir);
    
    System.out.println("삭제 완료!");
  }
  
    static void delete(File dir) {

      File[] files = dir.listFiles();

      for(File file : files) {
        
        if(file.isFile()) {
          file.delete();
        } else {
          delete(file);
        }
        
      }
      
      
    }
    
  }
  



