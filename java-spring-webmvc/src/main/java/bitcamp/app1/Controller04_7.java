// 요청 핸들러의 아규먼트 - @Cookie
package bitcamp.app1;

import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_7")
public class Controller04_7 {

  // 테스트 :
  // http://localhost:8080/java-spring-webmvc/app1/c04_7/h1
  @GetMapping("h1")
  @ResponseBody 
  public void handler1(
      PrintWriter out,
      HttpServletResponse response
      ) {
    try {
      response.addCookie(new Cookie("name1", "홍길동"));
      response.addCookie(new Cookie("name2", URLEncoder.encode("홍길동", "UTF-8")));
      response.addCookie(new Cookie("age","20"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    out.println("send cookie");
  }

  @GetMapping("h2")
  @ResponseBody 
  public void handler2(
      PrintWriter out,
      @CookieValue(value="name1", required=false) String name1,
      @CookieValue(value="name2", defaultValue="") String name2,
      @CookieValue(value="age", defaultValue="0") int age
      ) {
    out.printf("name1 = %s\n", name1);
    out.printf("name2 = %s\n", name2);
    out.printf("age = %d\n", age);
  }

}



