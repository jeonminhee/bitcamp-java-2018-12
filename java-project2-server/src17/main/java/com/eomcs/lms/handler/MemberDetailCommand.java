package com.eomcs.lms.handler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberDetailCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.

  public MemberDetailCommand(SqlSessionFactory sqlSessionFactory) {
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

      Member member = memberDao.findByNo(no);
      response.println(String.format("이름: %s", member.getName()));
      response.println(String.format("이메일: %s", member.getEmail()));
      response.println(String.format("사진: %s", member.getPhoto()));
      response.println(String.format("전화: %s", member.getTel()));
      response.println(String.format("가입일: %s", member.getRegisteredDate()));

    }
  }
}
