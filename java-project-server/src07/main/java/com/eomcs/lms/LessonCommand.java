package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.eomcs.lms.domain.Lesson;

public class LessonCommand {

  static ObjectOutputStream out;
  static ObjectInputStream in;
  static ArrayList<Lesson> lessons = new ArrayList<>();

  public static void service(String request) throws Exception {

    switch(request) {
      case "/lesson/add" :
        add();
        break;
      case "/lesson/list" :
        list();
        break;
      case "/lesson/detail" :
        detail();
        break;
      case "/lesson/update" :
        update();
        break;
      case "/lesson/delete" :
        delete();
        break;
      default:
        out.writeUTF("FAIL");
    }
    out.flush();
  }

  static void add() throws Exception {
    out.writeUTF("OK");
    out.flush();

    lessons.add((Lesson)in.readObject());
    out.writeUTF("OK");
  }

  static void list() throws Exception {
    out.writeUTF("OK");
    out.flush();
    out.writeUTF("OK");
    out.writeObject(lessons);

  }

  static void detail() throws Exception {
    out.writeUTF("OK");
    out.flush();
    int no = in.readInt();

    for(Lesson m : lessons) {
      if(m.getNo() == no) {
        out.writeUTF("OK");
        out.writeObject(m);
        return;
      }
    }
    out.writeUTF("FAIL");
  }

  static void update() throws Exception {
    out.writeUTF("OK");
    out.flush();
    Lesson lesson = (Lesson) in.readObject();

    int index = 0;
    for(Lesson m : lessons) {
      if(m.getNo() == lesson.getNo()) {
        lessons.set(index, lesson);
        out.writeUTF("OK");
        return;
      }
      index++;
    }
    out.writeUTF("FAIL");
  }

  static void delete() throws Exception {
    out.writeUTF("OK");
    out.flush();
    int no = in.readInt();

    int index = 0;
    for(Lesson l : lessons) {
      if(l.getNo() == no) {
        lessons.remove(index);
        out.writeUTF("OK");
        return;
      }
      index++;
    }
    out.writeUTF("FAIL");
  }


}
