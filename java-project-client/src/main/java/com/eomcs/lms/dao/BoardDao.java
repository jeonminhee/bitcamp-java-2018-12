// 프록시 패턴 적용 - BoardDao에서 인터페이스를 추출한다.
package com.eomcs.lms.dao;

import com.eomcs.lms.domain.Board;

public interface BoardDao {

  void insert(Board board);
  void findAll();
  void findByNo(int no);
  void update(String input, int no);
  void delete(int no);
  
}







