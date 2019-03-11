// DBMS 적용
package com.eomcs.lms.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl implements BoardDao{

  SqlSessionFactory sqlSessionFactory;

  public BoardDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Board> findAll(){
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("BoardMapper.findAll");
    }
  }

  public List<Board> findByKeyword(String keyword){
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("BoardMapper.findByKeyword", keyword);
    }
  }

  public void insert(Board board) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      sqlSession.insert("BoardMapper.insert", board);
    }
  }
  public Board findByNo(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()){
      sqlSession.update("BoardMapper.vwcount", no);
      return sqlSession.selectOne("BoardMapper.findByNo", no);
    }
  }
  public int update(Board board) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.update("BoardMapper.update", board);
    }
  }

  public int delete(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("BoardMapper.delete", no);
    }

  }

}















