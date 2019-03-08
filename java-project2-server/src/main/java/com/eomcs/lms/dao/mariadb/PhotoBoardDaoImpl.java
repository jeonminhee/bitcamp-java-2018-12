package com.eomcs.lms.dao.mariadb;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardDaoImpl implements PhotoBoardDao {
  
//DataSource 의존 객체 선언
  SqlSessionFactory sqlSessionFactory;

  public PhotoBoardDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<PhotoBoard> findAll(Map<String, Object> params){
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("PhotoBoardMapper.findAll", params);
    }
  }

  @Override
  public void insert(PhotoBoard photoBoard) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      sqlSession.insert("PhotoBoardMapper.insert", photoBoard);
      sqlSession.commit();
    }
  }
  
  @Override
  public PhotoBoard findByNo(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()){
      sqlSession.update("PhotoBoardMapper.vwcount", no);
      sqlSession.commit();
      return sqlSession.selectOne("PhotoBoardMapper.findByNo", no);
    }
  }
  
  @Override
  public PhotoBoard findByNoWithFile(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()){
      sqlSession.update("PhotoBoardMapper.vwcount", no);
      sqlSession.commit();
      return sqlSession.selectOne("PhotoBoardMapper.findByNoWithFile", no);
    }
  }
  
  @Override
  public int update(PhotoBoard photoBoard) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.update("PhotoBoardMapper.update", photoBoard);
      sqlSession.commit();
      return count;
    }
  }

  @Override
  public int delete(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.delete("PhotoBoardMapper.delete", no);
      sqlSession.commit();
      return count;
    }
  }

}