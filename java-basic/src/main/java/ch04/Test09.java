// 후위 연산자 a++ a--
package ch04;

public class Test09 {
  public static void main(String[] args) {
    int a = 5;
    int r = a++;
    
    System.out.printf("%d, %d\n", a, r);
    
    a = 5;
    r = a++ + a++ * a++;
    // r = a++ + a++ * a++;
    // r = 5 + a++ * a++; a = 6
    // r = 5 + 6 * a++; a = 7
    // r = 5 + 6 * 7; a = 8
    // r = 5 + 42;
    // r = 47;
    
    System.out.printf("%d, %d\n", a, r);
    
    a = 5;
    a = a++;
    System.out.println(a);
    // a = a ++;
    // a = 5; a = 6
    // a <= 5;
    
  }
}