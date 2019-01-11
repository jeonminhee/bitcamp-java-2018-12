package bitcamp.lms;
import java.util.*;
import java.sql.Date;


public class App {

  public static void main(String[] args) {

    int size = 0;
    int m_size = 0;
    int b_size = 0;
    final int LENGTH = 50;
    Lesson[] l1 = new Lesson[LENGTH];
    Member[] m1 = new Member[LENGTH];
    Board[] b1 = new Board[LENGTH];

    Scanner sc = new Scanner(System.in);

    while(true) {

      System.out.print("명령 > ");
      String cmd = sc.nextLine();

      if(cmd.equals("quit")) {
        System.out.println("안녕!");
        sc.close();
        break;
      } else if (cmd.equals("/lesson/add")) {

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

        l1[size] = l2;

        size++;
        
        System.out.println("저장하였습니다.");

      } else if (cmd.equals("/member/add")) {

        Member m2 = new Member();

        System.out.print("번호? ");
        m2.num = Integer.parseInt(sc.nextLine());

        System.out.print("이름? ");
        m2.name = sc.nextLine();

        System.out.print("이메일? ");
        m2.email = sc.nextLine();

        System.out.print("암호? ");
        String pwd = sc.nextLine();

        System.out.print("사진? ");
        String photo = sc.nextLine();

        System.out.print("전화? ");
        m2.phone = sc.nextLine();

        System.out.print("가입일? ");
        m2.today = Date.valueOf(sc.nextLine());

        m1[m_size++] = m2;

        System.out.println("저장하였습니다.");

      } else if (cmd.equals("/board/add")) {

        Board b2 = new Board();

        System.out.print("번호 ? ");
        b2.num = Integer.parseInt(sc.nextLine());

        System.out.print("내용 ? ");
        b2.a = sc.nextLine();   

        b2.today = new Date(System.currentTimeMillis());

        b2.view = 0;

        b1[b_size++] = b2;

        System.out.println("저장하였습니다.");

      } else if (cmd.equals("/lesson/list")) {
        for(int j = 0; j < size; j++) {
          System.out.printf("%d, %-15s, %s ~ %s, %s\n", 
              l1[j].num, l1[j].title, l1[j].start_date, l1[j].end_date, l1[j].full_time);
        } 
      } else if (cmd.equals("/member/list")) {

        for(int j = 0; j < m_size; j++) {
          System.out.printf("%d, %4s, %-10s, %-12s, %s\n",
              m1[j].num, m1[j].name, m1[j].email, m1[j].phone, m1[j].today);
        }
      }  else if(cmd.equals("/board/list")) {

        for(int j = 0; j < b_size; j++) {
          System.out.printf("%d, %-15s, %s, %d\n", 
              b1[j].num, b1[j].a, b1[j].today, b1[j].view);
        }
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
    } 
      System.out.println();
  }
  }
}
