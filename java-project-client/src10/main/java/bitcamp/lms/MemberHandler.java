package bitcamp.lms;

import java.sql.Date;

public class MemberHandler {

  static int m_size = 0;

  static void addMember(Member m1[]) {

    Member m2 = new Member();

    System.out.print("번호? ");
    m2.num = Integer.parseInt(App.prompt());

    System.out.print("이름? ");
    m2.name = App.prompt();

    System.out.print("이메일? ");
    m2.email = App.prompt();

    System.out.print("암호? ");
    String pwd = App.prompt();

    System.out.print("사진? ");
    String photo = App.prompt();

    System.out.print("전화? ");
    m2.phone = App.prompt();

    System.out.print("가입일? ");
    m2.today = Date.valueOf(App.prompt());

    m1[m_size] = m2;

    m_size++;

    System.out.println("저장하였습니다.");
  }

  static void listMember(Member m1[]) {

    for(int j = 0; j < m_size; j++) {
      System.out.printf("%d, %4s, %-10s, %-12s, %s\n",
          m1[j].num, m1[j].name, m1[j].email, m1[j].phone, m1[j].today);
    }
  }
}
