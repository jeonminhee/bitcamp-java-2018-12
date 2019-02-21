package com.eomcs.lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;
import com.eomcs.lms.context.ApplicationContextException;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.BoardDaoImpl;
import com.eomcs.lms.dao.LessonDaoImpl;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;

public class ApplicationInitializer implements ApplicationContextListener{

  Connection con;

  @Override
  public void ContextInitialize(Map<String, Object> context) throws ApplicationContextException {

    try {
      Connection con = DriverManager.getConnection(
          "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111");

      LessonDaoImpl lessonDao = new LessonDaoImpl(con);
      BoardDaoImpl boardDao = new BoardDaoImpl(con);
      Scanner keyboard = (Scanner)context.get("keyboard");

      context.put("/lesson/add", new LessonAddCommand(keyboard, lessonDao));
      context.put("/lesson/list", new LessonListCommand(keyboard, lessonDao));
      context.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonDao));
      context.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonDao));
      context.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonDao));

      context.put("/board/add", new BoardAddCommand(keyboard, boardDao));
      context.put("/board/list", new BoardListCommand(keyboard, boardDao));
      context.put("/board/detail", new BoardDetailCommand(keyboard, boardDao));
      context.put("/board/update", new BoardUpdateCommand(keyboard, boardDao));
      context.put("/board/delete", new BoardDeleteCommand(keyboard, boardDao));


    } catch (SQLException e) {
      throw new ApplicationContextException(e);
    }

  }

  @Override
  public void ContextDestroyed(Map<String, Object> context) throws ApplicationContextException {
    try {
      con.close();
    } catch (SQLException e) {
      throw new ApplicationContextException(e);
    }    
  }

}
