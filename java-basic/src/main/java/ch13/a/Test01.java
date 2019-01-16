// 상속 문법을 사용하지 않은 경우
package ch13.a;

public class Test01 {
  public static void main(String[] args) {
    Calculator2 c1 = new Calculator2();
    c1.plus(5);
    c1.mutiple(2);
    c1.minus(2);
    c1.divide(4);
    
    System.out.println(c1.getResult());
  }
}
