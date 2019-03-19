// 프로퍼티 값 설정 - List 프로퍼티 값 설정하기
// 배열과 리스트는 설정 파일이 똑같다.
package ch29.e;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {

  public static void main(String[] args) {

    @SuppressWarnings("resource")
    ApplicationContext iocContainer
      = new ClassPathXmlApplicationContext("ch29/e/application-context-02.xml");

    System.out.println("------------------------------------------------");
    
    System.out.println(iocContainer.getBean("c1"));
    System.out.println(iocContainer.getBean("c2"));

    
  }
}
