package com.eomcs.lms.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@WebServlet("/board/list")
@SuppressWarnings("serial")
public class BoardListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    BoardService boardService = ((ApplicationContext) getServletContext().getAttribute("iocContainer")).getBean(BoardService.class);
    List<Board> boards = boardService.list();
    
    // JSP가 게시물 목록을 다룰 수 있도록 ServletRequest 보관소에 저장한다.
    request.setAttribute("list", boards);
    
    // 뷰 컴포넌트의 URL을 ServletRequest 보관소에 저장한다.
   request.setAttribute("viewUrl", "/board/list.jsp");
    
  }
}










