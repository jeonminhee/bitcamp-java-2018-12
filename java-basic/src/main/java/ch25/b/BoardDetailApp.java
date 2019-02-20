// 연습 - 게시물 조회
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BoardDetailApp {

  // 다음과 같이 게시물을 조회하는 프로그램을 작성하라!
  // --------------------------------------------
  // 번호? 1
  // 제목 : aaa
  // 내용 : aaaaaa
  // 등록일 : 2019-1-1
  // 조회수 : 2
  //
  // 번호? 100
  // 해당 번호의 게시물이 존재하지 않습니다.
  // --------------------------------------------
  public static void main(String[] args) {
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")){

      try(Statement stmt = con.createStatement()){

          
          Scanner keyboard = new Scanner(System.in);
          System.out.print("번호? ");
          int no = Integer.parseInt(keyboard.nextLine());
          
          try(ResultSet rs = stmt.executeQuery("select * from x_board where board_id = " + no)){

          try {
            rs.next();
            System.out.printf("%d, %s, %s, %s, %d\n",
                rs.getInt("board_id"), 
                rs.getString("title"), 
                rs.getString("contents"), 
                rs.getDate("created_date"), 
                rs.getInt("view_count"));
          } catch (Exception e) {
            System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
          }
            keyboard.close();
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }

}
