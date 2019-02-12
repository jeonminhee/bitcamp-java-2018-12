package bitcamp.lms;
import java.util.*;
import java.sql.Date;


public class App {

  public static void main(String[] args) {

    int size = 0;
    final int a = 50;
    Lesson[] l1 = new Lesson[a];

    Scanner sc = new Scanner(System.in);

    while(size < a) {
      Lesson l2 = new Lesson();

      System.out.print("번호? ");
      l2.num = Integer.parseInt(sc.nextLine());

      System.out.print("수업명? ");
      l2.title = sc.nextLine();

      System.out.print("수업내용? ");
      l2.study = sc.nextLine();

      System.out.print("시작일? ");
      l2.start_date = Date.valueOf(sc.nextLine());

      System.out.print("종료일? ");
      l2.end_date = Date.valueOf(sc.nextLine());

      System.out.print("총수업시간? ");
      l2.full_time = sc.nextLine();

      System.out.print("일수업시간? ");
      l2.day_time = sc.nextLine();
      
      l1[size++] = l2;

      System.out.println();
      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String str = sc.nextLine();

      if (str.equalsIgnoreCase("y") || str.equals("")) {
        System.out.println();
        continue;
      } if(!str.equalsIgnoreCase("y") && !str.equals("")) {
        break;
      }

    }
    sc.close();
    System.out.println();

    for(int i = 0; i < size; i++) {
      System.out.printf("%d, %-15s, %s ~ %s, %s\n", 
          l1[i].num, l1[i].title, l1[i].start_date, l1[i].end_date, l1[i].full_time);
    }

  }
}
