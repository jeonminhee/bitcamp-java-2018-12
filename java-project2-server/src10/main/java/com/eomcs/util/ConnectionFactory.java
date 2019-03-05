package com.eomcs.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
  
  public static Connection create() {
    
    try {
    return DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    
  }
  
}
