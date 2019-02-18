// 11단계: AbstractService 상속 받기
package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonDaoImpl extends AbstractDao<Lesson> implements LessonDao{

  public LessonDaoImpl(String filepath) {
    this.filepath = filepath;
  }

  public void insert(Lesson lesson){
    try {
      list.add(lesson);
      this.saveData();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public List<Lesson> findAll(){
    return list;
  }

  public Lesson findByNo(int no) {

    for (Lesson l : list) {
      if (l.getNo() == no) {
        return l;
      }
    }
    return null;
  }

  public int update(Lesson lesson){
    try {
      int index = 0;
      for (Lesson l : list) {
        if (l.getNo() == lesson.getNo()) {
          list.set(index, lesson);
          this.saveData();
          return 1;
        }
        index++;
      }
      return 0;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int delete(int no) {
    try {
      int index = 0;
      for (Lesson l : list) {
        if (l.getNo() == no) {
          list.remove(index);
          this.saveData();
          return 1;
        }
        index++;
      }
      return 0;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}







