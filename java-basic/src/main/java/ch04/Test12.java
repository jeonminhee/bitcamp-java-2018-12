// &&, ||, vs &, |
package ch04;

public class Test12 {
  public static void main(String[] args) {
    // 괄호 연산
    int a = 5;
    int r = 10 / (a = 2);
    System.out.printf("%d, %d\n", a, r);
    
    // &&와 &의 차이점
    boolean b1 = true;
    boolean b2 = false && (b1 = false); //false가 확정되면 r-value 실행x
    System.out.printf("b1 = %b, b2 = %b\n", b1, b2);
    // && 효율적 연산
    
    b1 = true;
    b2 = false & (b1 = false); //false여도 끝까지 실행
    System.out.printf("b1 = %b, b2 = %b\n", b1, b2);
    
    b1 = true;
    b2 = true ||(b1 = false);
    System.out.printf("b1 = %b, b2 = %b\n", b1, b2);
    
    b1 = true;
    b2 = true |(b1 = false);
    System.out.printf("b1 = %b, b2 = %b\n", b1, b2);
  }
}