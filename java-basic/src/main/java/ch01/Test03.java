package ch01;

/**
 java doc 주석이라 한다.
 즉 자바 API 문서(HTML)를 생성할 때 참고하는 주석이다.
 클래스, 변수, 메서드 선언에 붙인다.
 */

public class Test03 {

  /**
    이 메서드는 Object 클래스의 메서드를 재 정의한것이다.
   */

  @Override //어노테이션(Annotation)이라 부르는 주석이다. 프로그램에서 사용한다.
  public String toString(){
    return "OK";
  }
    public static void main(String[] args) {
      System.out.println("Hello!");
    }
}

/*
여러개 주석이다.
* 의미없
*
*
*/
