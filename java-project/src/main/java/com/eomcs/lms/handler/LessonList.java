package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;

public class LessonList {
  
  LessonHandler l1 = new LessonHandler();

  public Lesson[] toArray(Lesson[] lesson) {
    lesson = l1.lessons;
    return lesson;
  }
  
  public void add(Lesson lesson) {
    
  }
}
