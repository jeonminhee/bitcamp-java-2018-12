package com.eomcs.lms.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.context.RequestMapping;

@Controller
public class LogoutController {

  @RequestMapping("/auth/logout")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    // 세션을 무효화시킨다.
    request.getSession().invalidate();
    
    // 메인화면으로 보낸다.
    return "redirect:" + request.getServletContext().getContextPath();

  }
}










