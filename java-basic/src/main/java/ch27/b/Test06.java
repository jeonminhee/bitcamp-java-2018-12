// 리플렉션(reflection) API - 메서드의 상세 정보 II
package ch27.b;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

// 어떤 클래스나 인터페이스의 static member를 import 할 수 있다.
import static java.lang.reflect.Modifier.*;

public class Test06 {

  public static void main(String[] args) throws Exception{
    
    Class<?> clazz = C.class;
    
    // 상속 받는 메서드를 포함하여 모든 public 메서드의 정보 출력하기
    // 
    Method[] methods = clazz.getMethods();
    for(Method m : methods) {
      // 메서드가 실제 정의된 클래스의 이름 출력하기
      System.out.printf("클래스명: %s\n", 
          m.getDeclaringClass().getSimpleName());
      System.out.printf("   ==> %s\n", m.getName());
      System.out.println("-------------------------------------");
    }
    
  }
}
