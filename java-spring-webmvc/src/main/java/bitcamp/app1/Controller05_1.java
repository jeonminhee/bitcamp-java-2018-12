// 요청 핸들러의 리턴 값 -  콘텐트를 직접 리턴하기
package bitcamp.app1;

import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c05_1")
public class Controller05_1 {

  // 테스트
  // http://localhost:8080/java-spring-webmvc/app1/c05_1/h1
  @GetMapping("h1")
  @ResponseBody 
  public String handler1() {
    return "<html><body><h1>abc가각간</h1></body></html>";
    
  }
  
  // 테스트
  // http://localhost:8080/java-spring-webmvc/app1/c05_1/h2
  @GetMapping(value="h2", produces="text/html;charset=UTF-8")
  @ResponseBody 
  public String handler2() {
    return "<html><body><h1>abc가각간</h1></body></html>";
    }
  
  // 테스트
  // http://localhost:8080/java-spring-webmvc/app1/c05_1/h3
  @GetMapping("h3")
  @ResponseBody 
  public String handler3(HttpServletResponse response) {
    response.setContentType("text/html;charset=UTF-8");
    return "<html><body><h1>abc가각간</h1></body></html>";
    
  }
  
  // 테스트
  // http://localhost:8080/java-spring-webmvc/app1/c05_1/h4
  @GetMapping("h4")
  public HttpEntity<String> handler4() {
    
    HttpEntity<String> entity = new HttpEntity<>("<html><body><h1>abc가각간</h1></body></html>");
    
    return entity;
    
  }
  
  // 테스트
  // http://localhost:8080/java-spring-webmvc/app1/c05_1/h5
  @GetMapping(value="h5", produces="text/html;charset=UTF-8")
  public HttpEntity<String> handler5() {
    
    HttpEntity<String> entity = new HttpEntity<>("<html><body><h1>abc가각간</h1></body></html>");
    
    return entity;
    
  }
  
  // 테스트
  // http://localhost:8080/java-spring-webmvc/app1/c05_1/h6
  @GetMapping(value="h6", produces="text/html;charset=UTF-8")
  public HttpEntity<String> handler6() {
    
    HttpHeaders headers = new HttpHeaders();    
    headers.add("Content-Type", "text/html;charset=UTF-8");
    
    HttpEntity<String> entity = new HttpEntity<>(
        "<html><body><h1>abc가각간</h1></body></html>",
        headers);
    
    return entity;
    
  }
  
  // 테스트
  // http://localhost:8080/java-spring-webmvc/app1/c05_1/h6
  @GetMapping(value="h7", produces="text/html;charset=UTF-8")
  public ResponseEntity<String> handler7() {
    
    HttpHeaders headers = new HttpHeaders();    
    headers.add("Content-Type", "text/html;charset=UTF-8");
    
    headers.add("BIT-OK", "ohora");
    
    ResponseEntity<String> entity = new ResponseEntity<>(
        "<html><body><h1>abc가각간</h1></body></html>",
        headers,
        HttpStatus.OK);
    
    return entity;
    
  }
}











