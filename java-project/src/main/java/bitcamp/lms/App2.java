/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.lms;
import java.util.Scanner;
import java.sql.Date;

public class App2 {

  public static void main(String[] args) {
    

    int no = 10;
    int i = 0;

    int[] num = new int[no];
    String[] name = new String[no];
    String[] email = new String[no];
    String[] phone = new String[no];
    Date[] today = new Date[no];

    Scanner sc = new Scanner(System.in);


    while(i <= 10) {

      System.out.print("번호? ");
      num[i] = Integer.parseInt(sc.nextLine());

      System.out.print("이름? ");
      name[i] = sc.nextLine();

      System.out.print("이메일? ");
      email[i] = sc.nextLine();

      System.out.print("암호? ");
      String pwd = sc.nextLine();

      System.out.print("사진? ");
      String photo = sc.nextLine();

      System.out.print("전화? ");
      phone[i] = sc.nextLine();

      System.out.print("가입일? ");
      today[i] = Date.valueOf(sc.nextLine());

      i++;

      System.out.println();
      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String str = sc.nextLine();

      if (str.equalsIgnoreCase("y") || str.equals("")) {

        continue;
      } if (!str.equalsIgnoreCase("y") && !str.equals("")) {
        break;
      }

    }
    sc.close();
    System.out.println();
    
    int a;
    for(a = 0; a < i; a++) {
      System.out.printf("%d, %4s, %-10s, %-12s, %s\n",
          num[a], name[a], email[a], phone[a], today[a]);
    }

  }

}
