// File 필터 클래스를 익명 클래스로 만든다.
package ch19.g;

import java.io.File;
import java.io.FilenameFilter;

public class Test05 {
  
  
  public static void main(String[] args) {

    File dir = new File("./"); 
    
    // list()를 호출 할 때 필터 객체를 딱 한번만 만들어 사용할 것이기 때문에
    // 굳이 로컬 클래스로 단정하게 정의 할 필요가 없다.
    // list() 메서드 가까이 익명 클래스를 사용하자.
    //
     FilenameFilter filter = new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
        if(name.endsWith(".txt"))
          return true;
        else
          return false;
      }
    };
    
    String[] names = dir.list(filter);
    //
    // 조금 더 가까이!
    // => list()를 호출하는 코드를 보는 즉시 무엇을 필터링하는지 알 수 있다면 
    //     소스 코드를 더 잘 읽을 수 있을텐데. . .
    
    for(String name : names) {
      System.out.println(name);
    }
    }

  

}
