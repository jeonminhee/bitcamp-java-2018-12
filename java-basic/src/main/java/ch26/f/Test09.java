// order by 절 다루기 - <foreach> 태그 사용법
package ch26.f;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test09 {

  public static void main(String[] args) throws Exception {

    String resource = "ch26/f/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);

    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();

    ArrayList<Integer> noList = new ArrayList<>();

    Scanner keyboard = new Scanner(System.in);

    while(true) {

      try {
      System.out.print("조회할 게시물 번호? > ");
      String value = keyboard.nextLine();
      if(value.length() == 0) {
        break;
      }
      noList.add(Integer.valueOf(value));
      } catch (Exception e) {
        break;
      }
    }
    
    keyboard.close();


    // 이 예제는 사용자가 입력한 값을 그대로 SQL 코드에 삽입하는 예이다.
    // => SQL 삽입 공격이 가능한 상황이다.
    HashMap<String, Object> params = new HashMap<>();
    params.put("noList", noList);
    List<Board >boards = sqlSession.selectList("board.select9", params);

    for(Board b : boards) {
      System.out.println(b);
    }
    System.out.println("-------------------------------");

  }
}
