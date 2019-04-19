// 요청 핸들러의 아규먼트 - @RequstBody
package bitcamp.app1;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_9")
public class Controller04_9 {

  @Autowired ServletContext sc;

  // http://localhost:8080/java-spring-webmvc/html/app1/c04_9.html
  @PostMapping(value="h1", produces="text/html;charset=UTF-8")
  @ResponseBody
  public String handler1(
      String name,
      int age,
      @RequestBody String data
      ) throws Exception {

    StringWriter out0 = new StringWriter();
    PrintWriter out = new PrintWriter(out0);
    out.println("<html><head><title>c04_9/h1</title></head><body>");
    out.println("<h1>결과</h1>");
    out.printf( "<p>이름: %s</p>\n", name);
    out.printf( "<p>나이: %s</p>\n", age);
    out.printf( "<p>통데이터: %s</p>\n", data);
    out.println("</body></html>");
    
    return out0.toString();

  }

}



