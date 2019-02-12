package bitcamp.lms;

import java.sql.Date;

public class BoardHandler {
  
  static int b_size = 0;
  
  static void addBoard(Board[] b1) {

    Board b2 = new Board();

    System.out.print("번호 ? ");
    b2.num = Integer.parseInt(App.prompt());

    System.out.print("내용 ? ");
    b2.a = App.prompt();   

    b2.today = new Date(System.currentTimeMillis());

    b2.view = 0;

    b1[b_size++] = b2;

    System.out.println("저장하였습니다.");

  }

  static void listBoard(Board[] b1) {

    for(int j = 0; j < b_size; j++) {
      System.out.printf("%d, %-15s, %s, %d\n", 
          b1[j].num, b1[j].a, b1[j].today, b1[j].view);
    }
  }
}
