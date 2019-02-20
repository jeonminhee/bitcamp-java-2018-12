// java.sql.Connection 객체
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test05 {

  public static void main(String[] args) {
    // DriverManager.getConnection()
    // => org.mariadb.jdbc.Driver.connect()
    //
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")){
      System.out.println("DBMS에 연결됨!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}


