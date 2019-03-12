package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Board;

public interface BoardDao {

  int insert(Board board);
  List<Board> findAll();
  List<Board> findByKeyword(String keyword);
  Board findByNo(int no);
  int increaseCount(int no);
  int update(Board board);
  int delete(int no);
}







