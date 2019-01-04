// 키보드로 입력한 값을 받기4 - int와 문자열을 섞어 읽기
package ch03;
import java.util.*;
public class Test09 {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    System.out.print("나이? ");
    String age = keyboard.nextLine();
    int age1 = Integer.parseInt(age);
    
    
    System.out.print("이름? ");
    String name = keyboard.nextLine();

    System.out.printf("%d(%s)\n", age1, name);
  }
}