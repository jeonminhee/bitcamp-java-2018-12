// View Resolver 교체하기
package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/c01_1")
public class Controller01_1 {

  // 테스트
  // http://localhost:8080/java-spring-webmvc/app2/c01_1/h1
  @GetMapping("h1")
  public String handler1() {
    return "c01_1/h1";
  }
  
  // 테스트
  // http://localhost:8080/java-spring-webmvc/app2/c01_1/h2
  @GetMapping("h2")
  public void handler2() {
    
  }
    
}











