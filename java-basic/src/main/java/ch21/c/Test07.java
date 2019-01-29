// 애플리케이션 예외의 종류 : RuntimeException 계열의 예외 처리 III
package ch21.c;

import java.util.ArrayList;

public class Test07 {

  public static void main(String[] args) throws RuntimeException {
    ArrayList<String> list = new ArrayList<>();
    
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    
    // get() 메서드
    // => 목록에서 인덱스로 지정한 위치의 값을 꺼내준다.
    // => 만약 인덱스가 무효하다면 IndexOutOfBoundsException 예외가 발생한다.
    // => IndexOutOfBoundsException은 RuntimeException 계열의 예외 클래스이다.
    // 
    
    // RuntimeException 계열의 예외 처리하기
    // 1) try ~ catch를 사용하지 않으면 자동으로 호출자에게 보고된다.
    // 2) try ~ catch를 사용 할 수 있다.
    // 3) throws 문장을 선언할 수 있다.
    //
    // '방법3' 적용
    // => 메서드 선언부에 throws 절을 추가한다.

    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));
    System.out.println(list.get(3)); // 메서드에 선언된 대로 상위 호출자에게 보고한다.

    System.out.println("프로그램 종료!");
    }
  }
  

