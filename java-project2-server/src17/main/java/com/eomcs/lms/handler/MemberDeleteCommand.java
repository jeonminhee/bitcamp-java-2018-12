package com.eomcs.lms.handler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.MemberDao;

public class MemberDeleteCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.

  public MemberDeleteCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {

    // SqlSession 객체를 준비한다.
    try (SqlSession sqlSession = sqlSessionFactory.openSession()){

      // SqlSession으로부터 BoardDao 구현체를 얻는다.
      // => getMapper(DAO 인터페이스 타입 정보)
      MemberDao memberDao = sqlSession.getMapper(MemberDao.class);

      int no = response.requestInt("번호? ");

      if(memberDao.delete(no) == 0) {
        response.println("해당 회원을 찾을 수 없습니다.");
      } else {
        response.println("회원을 삭제했습니다.");
        sqlSession.commit();
      }
    }
  }
}
