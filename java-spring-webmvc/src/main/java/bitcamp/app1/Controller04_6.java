// 요청 핸들러의 아규먼트 - @RequestHeader
package bitcamp.app1;

import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_6")
public class Controller04_6 {


  // 테스트 :
  // http://localhost:8080/java-spring-webmvc/app1/c04_6/h1
  @GetMapping("h1")
  @ResponseBody 
  public void handler1(
      PrintWriter out,
      @RequestHeader("Accept") String accept,
      @RequestHeader("User-Agent") String userAgent
      ) {
    
    out.printf("Accept=%s\n", accept);
    out.printf("User-Agent=%s\n", userAgent);
    
    if(userAgent.matches(".*Chrome.*")) {
      out.println("Chrome.");
    } else if (userAgent.matches(".*Safari.*")) {
      out.println("Safari.");
    } else if (userAgent.matches(".*Firefox.*")) {
      out.println(".*Firefox.");
    } else {
      out.println("etc.");
    }
  }

  // 잠깐 테스트하고 싶으면 main() 메소드를 만들어라.
  public static void main(String[] args) {
    String str = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36";
    // String str = "AA BB Aa Ba $12,000";
    // String regex = "Chrome";
    // String regex = "Chrome.*Safari";
    String regex = "^(Chrome).*Safari";
    Pattern pattern = Pattern.compile(regex);
    
    Matcher matcher = pattern.matcher(str);
    
    if(matcher.find()) {
      System.out.println("OK!");
      // for(int i = 0; i< matcher.groupCount(); i++) {
      // System.out.println(matcher.group(1));
    }
    
  }
  
}



