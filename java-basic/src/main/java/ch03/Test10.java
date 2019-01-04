// 키보드로 입력한 값을 받기 5 - 토큰 단위로 문자열 읽
package ch03;
import java.util.*;
public class Test10 {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    System.out.print("나이? ");
    int age = keyboard.nextInt();
    
    System.out.print("이름? ");
    String name = keyboard.next();

    System.out.printf("%d(%s)\n", age, name);
  }
}