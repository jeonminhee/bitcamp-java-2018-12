package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@SuppressWarnings("serial")
@WebServlet("/photoboard/add")
public class PhotoBoardAddServlet extends HttpServlet {

  String uploadDir;

  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath("/upload/photoboard");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LessonService lessonService = ((ApplicationContext) getServletContext().getAttribute("iocContainer")).getBean(LessonService.class);

    List<Lesson> lessons = lessonService.list();
    response.setContentType("text/html;charset=UTF-8");
    request.setAttribute("list", lessons);
    
    request.getRequestDispatcher("/photoBoard/form.jsp").include(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    PhotoBoardService photoBoardService = ((ApplicationContext) getServletContext().getAttribute("iocContainer")).getBean(PhotoBoardService.class);
    PhotoBoard board = new PhotoBoard();
    board.setTitle(request.getParameter("title"));
    board.setLessonNo(Integer.parseInt(request.getParameter("lessonNo")));

    ArrayList<PhotoFile> files = new ArrayList<>();
    Collection<Part> photos = request.getParts(); // lessonNo, title 전부 가져온다.
    for (Part photo : photos) {
      if(photo.getSize() == 0 || !photo.getName().equals("photo")) { 
        // 사이즈가 0이거나 photo와 일치하지 않는 값은 되돌려보낸다.
        continue;
      }

      // photo multipart만 가져왔을 때 . . .
      String filename = UUID.randomUUID().toString();
      photo.write(uploadDir + "/" + filename);
      PhotoFile file = new PhotoFile();
      file.setFilePath(filename);
      files.add(file); // ArrayList에 filepath들을 넣어준다.
    }
    board.setFiles(files); // photoboard에 file들을 넣어준다.

    if(board.getLessonNo() == 0) {
      request.setAttribute("error.title", "에러");
      request.setAttribute("error.content", "사진 또는 파일을 등록할 수업을 선택하세요.");
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    } else if (files.size() == 0) {
      request.setAttribute("error.title", "에러");
      request.setAttribute("error.content", "최소 한 개의 사진 파일을 등록해야 합니다.");
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }  else if (board.getTitle().equals("")){
      request.setAttribute("error.title", "에러");
      request.setAttribute("error.content", "게시판 제목을 입력하세요.");
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    } else {
      photoBoardService.add(board);
      response.sendRedirect("list");
    }

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    
  }
}
