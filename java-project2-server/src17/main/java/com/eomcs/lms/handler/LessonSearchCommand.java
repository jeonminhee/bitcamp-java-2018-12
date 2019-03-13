package com.eomcs.lms.handler;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonSearchCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.

  public LessonSearchCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {

    // SqlSession 객체를 준비한다.
    try (SqlSession sqlSession = sqlSessionFactory.openSession()){

      // SqlSession으로부터 BoardDao 구현체를 얻는다.
      // => getMapper(DAO 인터페이스 타입 정보)
      LessonDao lessonDao = sqlSession.getMapper(LessonDao.class);

      String keyword = response.requestString("검색어? ");
      List<Lesson> lessons = lessonDao.findByKeyword(keyword);

      for (Lesson lesson : lessons) {
        response.println(String.format("%3d, %-15s, %10s ~ %10s, %4d", 
            lesson.getNo(), lesson.getTitle(), 
            lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours()));
      }
    }
  }
}
