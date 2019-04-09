package com.eomcs.lms.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@WebServlet("/member/detail")
@SuppressWarnings("serial")
public class MemberDetailServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");
    int no = Integer.parseInt(request.getParameter("no"));

    MemberService memberService = ((ApplicationContext) getServletContext().getAttribute("iocContainer")).getBean(MemberService.class);
    Member member = memberService.get(no);
    
    request.setAttribute("member", member);
    
    request.setAttribute("viewUrl", "/member/detail.jsp");

  }
}
