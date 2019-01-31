// java.io.File 클래스 : 연습 과제 - bin 폴더를 삭제하라!
package ch22.a;

import java.io.File;

public class Test14 {

  public static void main(String[] args) throws Exception {
    
    File dir = new File("bin/main");

    findClass(dir, "");
    
  }
  
    static void findClass(File dir, String packageName) {

      File[] files = dir.listFiles(pathname -> 
      pathname.isDirectory() ||
      (pathname.isFile() && pathname.getName().endsWith(".class")) ?
          true : false);

      for(File file : files) {
        if(file.isFile()) {
          System.out.printf("%s%s\n", packageName, 
              file.getName().replace(".class", ""));
        } else {
          findClass(file, packageName + file.getName() + ".");
        }
        
      }
      
      
    }
    
  }
  



