/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.lms;
import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {

    int i = 0;
    final int length = 50;
    Board[] b1 = new Board[length];

    Scanner sc = new Scanner(System.in);

    while(i < length) {
      
      Board b2 = new Board();
      
      System.out.print("번호 ? ");
      b2.num = Integer.parseInt(sc.nextLine());

      System.out.print("내용 ? ");
      b2.a = sc.nextLine();   

      b2.today = new Date(System.currentTimeMillis());

      b2.view = 0;
      
      b1[i] = b2;

      i++;

      System.out.println();
      
      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String str = sc.nextLine();
      
      System.out.println();

      if(str.equalsIgnoreCase("y") || str.equals("")) {
        continue;
      } if(!str.equalsIgnoreCase("y") && !str.equals("")) {
        break;
      }
    }
    sc.close();

    int j;
    for(j = 0; j < i; j++) {
      System.out.printf("%d, %-15s, %s, %d\n", 
          b1[j].num, b1[j].a, b1[j].today, b1[j].view);
    }
    
  }
}