// 클라이언트가 보낸 데이터 읽기 - GET 요청 데이터 읽기
package bitcamp.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05/s3")
public class Servlet03 extends MyHttpServlet2 {
  
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 테스트
    // -http://localhost:8080/java-web/ex05/test03.html
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
      out.println("GET 요청입니다.");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 테스트
    // -http://localhost:8080/java-web/ex05/test03.html
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
      out.println("POST 요청입니다.");
    
  }
  
}



