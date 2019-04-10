package com.eomcs.lms.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;

@Controller("/auth/logout")
public class LogoutController implements PageController {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    // 세션을 무효화시킨다.
    request.getSession().invalidate();
    
    // 메인화면으로 보낸다.
    return "redirect:" + request.getServletContext().getContextPath();

  }
}










