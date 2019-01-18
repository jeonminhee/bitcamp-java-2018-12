// 제네릭 (generic) 적용 전 - Object를 이용한 다형적 변수 사용할 때 형변환이 불편하다.
package ch16;

import java.util.Calendar;
import java.util.Date;

public class Test02 {

  public static void main(String[] args) {
    

    String obj1 = (String) echo(new String("Hello"));
    Date obj2 = (Date) echo(new Date());
    Calendar obj3 = echo(Calendar.getInstance());
    

  }

  // 제네릭 적용 전
  public static String  echo(String obj) {
    return obj;
  }
  
  public static Date echo(Date obj) {
    return obj;
  }
  
  public static Calendar echo(Calendar obj) {
    return obj;
  }
}
