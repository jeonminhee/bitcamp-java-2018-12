// 키보드로 입력한 값을 받기3 - int 값 읽기
package ch03;
import java.util.*;
public class Test08 {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    System.out.print("a? ");
    int a = keyboard.nextInt();

    System.out.print("b? ");
    int b = keyboard.nextInt();

    System.out.printf("%d * %d = %d\n", a, b, a * b);
  }
}