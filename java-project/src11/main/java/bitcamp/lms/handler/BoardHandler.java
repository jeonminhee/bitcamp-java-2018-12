package bitcamp.lms.handler;

import java.sql.Date;
import bitcamp.lms.App;
import bitcamp.lms.domain.Board;

public class BoardHandler {
  
  static final int LENGTH = 10;
  static Board[] b1 = new Board[LENGTH];
  static int b_size = 0;
  
  public static void addBoard() {

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

  public static void listBoard() {

    for(int j = 0; j < b_size; j++) {
      System.out.printf("%d, %-15s, %s, %d\n", 
          b1[j].num, b1[j].a, b1[j].today, b1[j].view);
    }
  }
}
