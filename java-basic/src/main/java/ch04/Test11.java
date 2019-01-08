// 논리연산자 : &, |
package ch04;

public class Test11 {
  public static void main(String[] args) {
    System.out.println("피 연산자가 boolean 타입일때 &&, ||와 동일하게 동작");
    System.out.println(true & true);
    System.out.println(true & false);
    
    System.out.println(true | false);
    System.out.println(false | false);
    
    System.out.println("피연산자가 정수일 때는 비트 연산을 수행한다.");
    
    int a = 0xca; // 0000 0000 0000 0000 0000 0000 1100 1010
    int b = 0x66; // 0000 0000 0000 0000 0000 0000 0110 0110
    
    System.out.println(a & b); //0x42
                      // 0000 0000 0000 0000 0000 0000 0100 0010
    System.out.println(a | b); //0xee
                      // 0000 0000 0000 0000 0000 0000 1110 1110
  }
}