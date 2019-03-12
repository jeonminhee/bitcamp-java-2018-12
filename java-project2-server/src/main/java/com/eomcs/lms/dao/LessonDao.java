// 11단계: AbstractService 상속 받기
package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Lesson;

public interface LessonDao {
  
  int insert(Lesson lesson);
  List<Lesson> findAll();
  List<Lesson> findByKeyword(String keyword);
  Lesson findByNo(int no);
  int update(Lesson lesson);
  int delete(int no);

}







