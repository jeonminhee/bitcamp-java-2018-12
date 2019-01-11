package bitcamp.lms;
import java.util.*;
import java.sql.Date;


public class App {

  static final int LENGTH = 10;
  static int size = 0;
  static int m_size = 0;
  static int b_size = 0;

  static Lesson[] l1 = new Lesson[LENGTH];
  static Member[] m1 = new Member[LENGTH];
  static Board[] b1 = new Board[LENGTH];


  static String prompt () {

    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    return str;
  }

  static void addLesson(Lesson l1[]) {

    Lesson l2 = new Lesson();

    System.out.print("번호? ");
    l2.num = Integer.parseInt(prompt());

    System.out.print("수업명? ");
    l2.title = prompt();

    System.out.print("수업내용? ");
    l2.study = prompt();

    System.out.print("시작일? ");
    l2.start_date = Date.valueOf(prompt());

    System.out.print("종료일? ");
    l2.end_date = Date.valueOf(prompt());

    System.out.print("총수업시간? ");
    l2.full_time = prompt();

    System.out.print("일수업시간? ");
    l2.day_time = prompt();

    l1[size] = l2;

    size++;

    System.out.println("저장하였습니다.");

  }

  static void addMember(Member m1[]) {

    Member m2 = new Member();

    System.out.print("번호? ");
    m2.num = Integer.parseInt(prompt());

    System.out.print("이름? ");
    m2.name = prompt();

    System.out.print("이메일? ");
    m2.email = prompt();

    System.out.print("암호? ");
    String pwd = prompt();

    System.out.print("사진? ");
    String photo = prompt();

    System.out.print("전화? ");
    m2.phone = prompt();

    System.out.print("가입일? ");
    m2.today = Date.valueOf(prompt());

    m1[m_size] = m2;

    m_size++;

    System.out.println("저장하였습니다.");
  }

  static void addBoard(Board[] b1) {

    Board b2 = new Board();

    System.out.print("번호 ? ");
    b2.num = Integer.parseInt(prompt());

    System.out.print("내용 ? ");
    b2.a = prompt();   

    b2.today = new Date(System.currentTimeMillis());

    b2.view = 0;

    b1[b_size++] = b2;

    System.out.println("저장하였습니다.");

  }

  static void listLesson(Lesson l1[]) {

    for(int j = 0; j < size; j++) {
      System.out.printf("%d, %-15s, %s ~ %s, %s\n", 
          l1[j].num, l1[j].title, l1[j].start_date, l1[j].end_date, l1[j].full_time);
    }
  }

  static void listMember(Member m1[]) {

    for(int j = 0; j < m_size; j++) {
      System.out.printf("%d, %4s, %-10s, %-12s, %s\n",
          m1[j].num, m1[j].name, m1[j].email, m1[j].phone, m1[j].today);

    }
  }

  static void listBoard(Board[] b1) {

    for(int j = 0; j < b_size; j++) {
      System.out.printf("%d, %-15s, %s, %d\n", 
          b1[j].num, b1[j].a, b1[j].today, b1[j].view);
    }
  }
  public static void main(String[] args) {

    while(true) {

      System.out.print("명령 > ");
      String cmd = prompt();

      if(cmd.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (cmd.equals("/lesson/add")) {

        addLesson(l1);

      } else if (cmd.equals("/member/add")) {

        addMember(m1);

      } else if (cmd.equals("/board/add")) {

        addBoard(b1);

      } else if (cmd.equals("/lesson/list")) {

        listLesson(l1);

      } else if (cmd.equals("/member/list")) {

        listMember(m1);

      }  else if(cmd.equals("/board/list")) {

        listBoard(b1);

      }  else {
        System.out.println("실행할 수 없는 명령입니다.");
      } 
      System.out.println();
    }
  } 
}
