package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.util.ConnectionFactory;

public abstract class AbstractCommand implements Command {
  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
      execute(new Response(in, out));
      // 현재 스레드에 보관된 Connection 객체를 꺼낸다.
      // 그리고 커넥션 객체를 통해 수행했던 모든 데이터 변경 작업을 commit한다.
      ConnectionFactory.create().commit();

    }  catch (Exception e) {
      try {
        ConnectionFactory.create().rollback();
      }catch(Exception e2) {
        //rollback하다가 발생된 예외는 달리 처리할 방법이 없다. 무시한다.
      }
      out.printf("실행오류! : %s\n", e.getMessage());
    }
  }


public void execute(Response response) throws Exception{
  // 서브 클래스에서 오버라이딩 해야 할 메서드
  // 그러나 서브 클래스가 반드시 오버라이딩 하도록 강요하지 않기 위해 추상메서드로 선언하지 않는다.
  // 왜? 서브 클래스는 Command의 execute(BufferedReader, PrintWriter)를 
  // 오버라이딩 할지도 모르기 때문이다. 
}
}
