// 클라이언트가 보낸 데이터 읽기 - 빈 값과 null 
package bitcamp.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex04/s7")
public class Servlet07 extends GenericServlet {
  
  private static final long serialVersionUID = 1L;

  // - http://localhost:8080/java-web/ex04/test07.html 실행
  
  // 파라미터 이름만 넘어갈 때 getParameter()의 리턴 값은 빈 문자열 객체이다.
  // null이 아니다.
  // 입력 상자에 값을 입력하지 않아도 빈 문자열이 서버에 전송된다는 것이다.
  // => 예) a=aaa&b=
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.printf("a = %s\n", req.getParameter("a"));
    out.printf("b = %s\n", req.getParameter("b"));
    
    // 파라미터 이름 자체가 없으면 getParameter()는 null을 리턴한다.
    out.printf("c = %s\n", req.getParameter("c"));
    
  }
}







