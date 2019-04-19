// 요청 핸들러에서 view 컴포넌트(JSP) 쪽에 데이터 전달하기
package bitcamp.app1;

import java.util.Map;
import javax.servlet.ServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
@RequestMapping("/c05_3")
public class Controller05_3 {

  // 테스트
  // http://localhost:8080/java-spring-webmvc/app1/c05_3/h1
  @GetMapping("h1")
  public String handler1(ServletRequest request) {
    
    // JSP가 꺼내 쓸 수 있도록 ServletRequest 객체에 직접 담는다.
    request.setAttribute("name", "홍길동");
    request.setAttribute("age", 20); // auto-boxing
    request.setAttribute("working", true); // auto-boxing
    
    return "/WEB-INF/jsp/c05_3.jsp";
  }
  
  // 테스트
  // http://localhost:8080/java-spring-webmvc/app1/c05_3/h2
  @GetMapping("h2")
  public String handler2(Map<String, Object> map) {
      
    map.put("name", "홍길동");
    map.put("age", 20); // auto-boxing
    map.put("working", true);
    
    return "/WEB-INF/jsp/c05_3.jsp";
  }
  
  // 테스트
  // http://localhost:8080/java-spring-webmvc/app1/c05_3/h3
  @GetMapping("h3")
  public String handler3(Model model) {
      
    model.addAttribute("name", "홍길동");
    model.addAttribute("age", 20); // auto-boxing
    model.addAttribute("working", true);
    
    return "/WEB-INF/jsp/c05_3.jsp";
  }
  
  // 테스트
  // http://localhost:8080/java-spring-webmvc/app1/c05_3/h4
  @GetMapping("h4")
  public ModelAndView handler4() {
      
    ModelAndView mv = new ModelAndView();
    
    mv.addObject("name", "홍길동");
    mv.addObject("age", 20); // auto-boxing
    mv.addObject("working", true);
    mv.setViewName("/WEB-INF/jsp/c05_3.jsp");
    
    return mv;
  }
    
}











