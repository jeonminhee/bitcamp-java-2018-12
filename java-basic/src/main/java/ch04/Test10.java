// 논리연산자 : &&, ||, ^
package ch04;

public class Test10 {
  public static void main(String[] args) {
    System.out.println("&& 연산자 : 피연산자 모두 true일 때만 true");
    System.out.println(true && true);
    System.out.println(true && false);

    System.out.println("|| 연산자 : 피연산자가 하나만 true여도 true");
    System.out.println(true || false);
    System.out.println(false || false);

    System.out.println("^ 연산자 : 피연산자가 서로 다를 때 true");
    System.out.println(true ^ true);
    System.out.println(false ^ false);
    System.out.println(true ^ false);

    // 논리 연산자의 피연산자 값은 반드시 true 또는 false이여야 한다.
    // System.out.println(1 && 1); // 컴파일 오류!
  }
}