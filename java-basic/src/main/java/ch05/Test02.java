// 흐름제어문 - if-else 조건문
package ch05;

public class Test02 {

  public static void main(String[] args) {

    int age = 22;

    if(age >= 20) 
      System.out.println("성인입니다.");
    else
      System.out.println("미성년입니다.");

    if(age >= 20) {
      System.out.println("-------------");
      System.out.println("성인입니다.");
    } 
    else {
      System.out.println("-------------");
      System.out.println("미성년입니다.");
    }

    // 대부분의 자바 개발자들은 if ~ else의 모양을 K & R 모양으로 작성한다.
    if(age >= 20) {
      System.out.println("-------------");
      System.out.println("성인입니다.");
    } else {
      System.out.println("-------------");
      System.out.println("미성년입니다.");
    }
    
    // if문만 작성할 수는 있지만, else 문만 홀로 존재할 수 없다.
    /*
    else
      System.out.println("OK?"); //컴파일 오류!
      */
  }
}