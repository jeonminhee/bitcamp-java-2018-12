// 클라이언트가 보낸 데이터 읽기 - GET 요청 데이터 읽기
package bitcamp.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05/s1")
public class Servlet01 extends GenericServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    
    // 테스트
    // -http://localhost:8080/java-web/ex05/test01.html
    HttpServletRequest httpReq = (HttpServletRequest) req;
    HttpServletResponse httpRes = (HttpServletResponse) res;
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    if(httpReq.getMethod().equals("GET")) {
      out.println("GET 요청입니다.");
    } else if (httpReq.getMethod().equals("POST")){
      out.println("POST 요청입니다.");
    } else {
      out.println("이 서블릿이 다루지 못하는 요청 방식입니다.");
    }
    
  }
}



