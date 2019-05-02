package com.eomcs.lms.web.json;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@RestController("json/LessonController")
@RequestMapping("json/lesson")
public class LessonController {
  
  @Autowired LessonService lessonService;
  
  @PostMapping("add")
  public Object add(Lesson lesson) throws Exception {
    
    HashMap<String,Object> content = new HashMap<>();
    try {
    lessonService.add(lesson);
    content.put("status", "success");
    } catch (Exception e) {
      content.put("status", "fail");
      content.put("message", e.getMessage());
    }
    return content;
  }
  
  @GetMapping("delete/{no}")
  public String delete(@PathVariable int no) throws Exception {

    if (lessonService.delete(no) == 0) {
      throw new Exception("해당 번호의 수업이 없습니다.");
    }

    return "redirect:../";
  }
  
  @GetMapping("detail")
  public Object detail(int no){

    Lesson lesson = lessonService.get(no);

    return lesson;
  }

  @GetMapping("list")
  public Object list(
      @RequestParam(defaultValue = "1") int pageNo,
      @RequestParam(defaultValue = "3") int pageSize,
      Model model) throws Exception {
    
    if (pageSize < 3 || pageSize > 8) {
      // pageSize는 8개 이상 가져 올 수 없다.
      pageSize = 3;
    }
    
    int rowCount = lessonService.size();
    int totalPage = rowCount / pageSize;
    if(rowCount % pageSize > 0) {
      totalPage++;
    }
    
    if(pageNo < 1) {
      // pageNo는 마이너스가 나올 수 없다.
      pageNo = 1;
    } else if (pageNo > totalPage) {
      pageNo = totalPage;
    }
    
    
    List<Lesson> lessons = lessonService.list(pageNo, pageSize);
    
    HashMap<String,Object> content = new HashMap<>();
    // JSP가 게시물 목록을 다룰 수 있도록 ServletRequest 보관소에 저장한다.
    content.put("list", lessons);
    content.put("pageNo", pageNo);
    content.put("pageSize", pageSize);
    content.put("totalPage", totalPage);
    
    return content;
  }
  
  @PostMapping("update")
  public String update(Lesson lesson) throws Exception {

    if (lessonService.update(lesson) == 0) {
      throw new Exception("해당 번호의 수업이 없습니다.");
    }
    return "redirect:.";
  }
}
