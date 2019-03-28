// 클라이언트가 보낸 데이터 읽기 - POST 요청 데이터 읽기
package bitcamp.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex04/s4")
public class Servlet04 extends GenericServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    
    // 테스트
    // - http://localhost:8080/java-web/ex04/test04.html 실행
    //
    req.setCharacterEncoding("UTF-8");

    String age = req.getParameter("age");
    String name = req.getParameter("name");
    String photo = req.getParameter("photo");
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.printf("이름=%s\n", name);
    out.printf("나이=%s\n", age);
    out.printf("사진=%s\n", photo);
  }
}







