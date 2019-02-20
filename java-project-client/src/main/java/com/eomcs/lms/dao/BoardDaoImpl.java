package com.eomcs.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl implements BoardDao{


  public BoardDaoImpl() {}


  public void findAll(){
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (Statement stmt = con.createStatement()) {

        try (ResultSet rs = stmt.executeQuery(
            "select * from board order by id desc")) {

          while (rs.next()) {
            System.out.printf("%d, %s, %s, %d\n", 
                rs.getInt("id"), 
                rs.getString("contents"), 
                rs.getDate("created_date"),
                rs.getInt("view_count"));
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void insert(Board board) {
    try(Connection con = DriverManager.getConnection( "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")){

      try(Statement stmt = con.createStatement()){

        stmt.executeUpdate(
            "insert into board(contents)"
                + " values('" + board.getContents() + "')");

        System.out.println("저장 완료!");
      }

    } catch (Exception e) {
      System.out.println("저장 실패!");
    }
  }
  public void findByNo(int no) {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (Statement stmt = con.createStatement()) {

        try (ResultSet rs = stmt.executeQuery(
            "select * from board where id = " + no)) {

          if (rs.next()) {
            System.out.printf("내용: %s\n", rs.getString("contents"));
            System.out.printf("등록일: %s\n", rs.getDate("created_date"));
            System.out.printf("조회수: %d\n", rs.getInt("view_count"));
          } else {
            System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
          }
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void update(String input, int no) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (PreparedStatement stmt = con.prepareStatement(
          "update board set contents = ? where id = ?")) {

        stmt.setString(1, input);
        stmt.setInt(2, no);

        int count = stmt.executeUpdate();

        if (count == 0) {
          System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
        } else {
          System.out.println("변경하였습니다.");
        }
      } 
    } catch (Exception e) {
      System.out.println("업데이트 중 오류 발생!");
    }
  }

  public void delete(int no) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (Statement stmt = con.createStatement()) {

        int count = stmt.executeUpdate(
            "delete from board where id = " + no);

        if (count == 0) {
          System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
        } else {
          System.out.println("삭제하였습니다.");
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}














