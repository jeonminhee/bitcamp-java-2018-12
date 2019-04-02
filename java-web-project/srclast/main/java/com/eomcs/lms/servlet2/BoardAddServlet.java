package com.eomcs.lms.servlet2;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.InitServlet;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@WebServlet("/board2/add")
@SuppressWarnings("serial")
public class BoardAddServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    BoardService boardService = InitServlet.iocContainer.getBean(BoardService.class);

    Board board = new Board();
    board.setContents(request.getParameter("contents"));

    boardService.add(board);

    PrintWriter out = response.getWriter();
    out.println("<h1>게시물 등록</h1>");
    out.println("<p>저장하였습니다.</p>");
    
    // 리프레스 정보를 <meta> 태그에 담아서 <head> 태그에 넣어야 하는데
    // 현재 <head> 태그의 출력은 BoardServlet 에서 담당하고 있다.
    // 다른 방법은 없는가? 
    // => 있다! 자바 코드로 응답 헤더에 직접 리프레시 명령을 추가할 수 있다.

  }


}










