package com.eomcs.lms.handler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;

public class PhotoBoardDeleteCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.

  public PhotoBoardDeleteCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {

    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {

      // SqlSession으로부터 BoardDao 구현체를 얻는다.
      // => getMapper(DAO 인터페이스 타입 정보)
      PhotoBoardDao photoBoardDao = sqlSession.getMapper(PhotoBoardDao.class);
      PhotoFileDao photoFileDao = sqlSession.getMapper(PhotoFileDao.class);

      int no = response.requestInt("번호? ");

      // 데이터를 지울 때는 자식 테이블의 데이터부터 지워야한다.
      photoFileDao.deleteByPhotoBoardNo(no);

      if(photoBoardDao.delete(no) == 0) {
        response.println("해당 번호의 사진이 없습니다.");
      }
      response.println("삭제했습니다.");
      sqlSession.commit();
    } catch (Exception e) {
      response.println("삭제 중 오류 발생.");
      sqlSession.rollback();
    } finally {
      sqlSession.close();
    }
  }
}
