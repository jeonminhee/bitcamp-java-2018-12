/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.lms;
import java.util.*;

public class App2 {
    
    public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      Date today = new Date();

      System.out.print("번호? ");
      int num = Integer.parseInt(sc.nextLine());

      System.out.print("이름? ");
      String name = sc.nextLine();

      System.out.print("이메일? ");
      String email = sc.nextLine();

      System.out.print("암호? ");
      String pwd = sc.nextLine();

      System.out.print("사진? ");
      String photo = sc.nextLine();

      System.out.print("전화? ");
      String phone = sc.nextLine();



      System.out.printf("번호 : %d\n", num);
      System.out.printf("이름 : %s\n", name);
      System.out.printf("이메일 : %s\n", email);
      System.out.printf("암호 : %s\n", pwd);
      System.out.printf("사진 : %s\n", photo);
      System.out.printf("전화 : %s\n", phone);
      System.out.printf("가입일: %1$tY-%1$tm-%1$td\n", today);
      
    }
}
