package com.eomcs.lms.controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;

@Controller
public class PhotoBoardAddController {

  @Autowired PhotoBoardService photoBoardService;
  @Autowired LessonService lessonService;
  

  @RequestMapping("/photoboard/add")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
   
    String uploadDir = request.getServletContext().getRealPath("/upload/photoboard");
    
    if(request.getMethod().equals("GET")) {

    List<Lesson> lessons = lessonService.list();
    request.setAttribute("list", lessons);
    
    return "/photoBoard/form.jsp";
  }

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
      throw new Exception("사진 또는 파일을 등록할 수업을 선택하세요.");
    } else if (files.size() == 0) {
      throw new Exception("최소 한 개의 사진 파일을 등록해야 합니다.");
    }  else if (board.getTitle().length() == 0){
      throw new Exception("사진 제목을 입력하세요.");
    } else {
      photoBoardService.add(board);
      
      return "redirect:list";
    }
    
  }
}
