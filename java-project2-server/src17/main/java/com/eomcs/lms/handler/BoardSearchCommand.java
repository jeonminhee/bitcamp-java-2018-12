package com.eomcs.lms.handler;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardSearchCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.

  public BoardSearchCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()){

      // SqlSession으로부터 BoardDao 구현체를 얻는다.
      // => getMapper(DAO 인터페이스 타입 정보)
      BoardDao boardDao = sqlSession.getMapper(BoardDao.class);  

      String keyword = response.requestString("검색어? ");
      List<Board> boards = boardDao.findByKeyword(keyword);
      for (Board board : boards) {
        response.println(
            String.format("%3d, %-20s, %s, %d", 
                board.getNo(), board.getContents(), 
                board.getCreatedDate(), board.getViewCount()));
      }
    }
  }
}
