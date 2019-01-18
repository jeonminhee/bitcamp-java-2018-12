// 제네릭 (generic) 적용 전 - Object를 이용한 다형적 변수 사용
package ch16;

import java.util.Calendar;
import java.util.Date;

public class Test01 {

  public static void main(String[] args) {
    
    // echo의 리턴타입이 Object이기 때문에 String 레퍼런스로 바로 받을 수 없다.
    // => 해결책 ? 형변환 해야한다.
    //
    // String obj = echo(new String("Hello")); // 컴파일 오류!
    String obj = (String) echo(new String("Hello"));
    
    // 잘못된 형변환은 컴파일러는 속일 수 있을 지라도 runtime에서는 오류를 발생시킨다.
    // Integer obj2 = (Integer) echo(new String("Hello")); // 실행 오류!
    
    Date obj3 = (Date) echo(new Date());
    

  }

  // 제네릭 적용 전
  public static Object echo(Object obj) {
    return obj;
  }
}
