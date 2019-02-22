package com.eomcs.lms.handler;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;

public class LessonDeleteCommand extends AbstractCommand {

  LessonDao lessonDao;

  public LessonDeleteCommand(LessonDaoImpl lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute(Response response) throws Exception {
      
    int no = response.requestInt("번호? ");

      if(lessonDao.delete(no) == 0) {
        response.println("해당 수업을 찾을 수 없습니다.");
      } else {
        response.println("수업을 삭제했습니다.");
      }

  }

}
