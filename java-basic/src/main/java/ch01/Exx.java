package ch01;

import java.sql.Date;
import java.util.Scanner;

public class Exx {

  public static void main(String[] args) {

    int no = 10;
    int i = 0;

    int[] num = new int[no];
    String[] a = new String[no];
    Date[] today = new Date[no];
    int[] view = new int[no];


    Scanner sc = new Scanner(System.in);

    while(i <= 10) {
      System.out.print("번호 ? ");
      num[i] = Integer.parseInt(sc.nextLine());

      System.out.print("내용 ? ");
      a[i] = sc.nextLine();   

      today[i] = new Date(System.currentTimeMillis());

      view[i] = 0;

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
          num[j], a[j], today[j], view[j]);
    }
    
  }
}