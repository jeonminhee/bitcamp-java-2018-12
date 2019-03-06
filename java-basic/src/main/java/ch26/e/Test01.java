package ch26.e;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {

  public static void main(String[] args) throws Exception {

    String resource = "ch26/e/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);

    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();

    // in-parameter 값을 넘기지 않고 SQL 실행하기 
    List<Board> boards = sqlSession.selectList("board.select1");
    for(Board b : boards) {
      System.out.println(b);
    }
    System.out.println("-------------------------------");

    // in-parameter에 int 값 넘기기
    // selectOne(sql, in-parameter 값)
    // => in-parameter 값의 타입은 Object이다.
    //    자바 원시 타입의 값을 지정하면 자동으로 오토 박싱되어 mybatis에 전달된다.
    Board board = sqlSession.selectOne("board.select2", 10);
    System.out.println(board);

    System.out.println("-------------------------------");
    
    // in-parameter에 String 값 넘기기
    List<Board> boards2 = sqlSession.selectList("board.select3", "aa");
    for(Board b : boards2) {
      System.out.println(b);
    }
    System.out.println("-------------------------------");
  }
}
