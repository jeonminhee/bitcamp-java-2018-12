package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonSearchCommand extends AbstractCommand {

  LessonDao lessonDao;

  public LessonSearchCommand(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute(Response response) throws Exception {

    String keyword = response.requestString("검색어? ");
    List<Lesson> lessons = lessonDao.findByKeyword(keyword);

    for (Lesson lesson : lessons) {
      response.println(String.format("%3d, %-15s, %10s ~ %10s, %4d", 
          lesson.getNo(), lesson.getTitle(), 
          lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours()));
    }

  }
}
