package com.eomcs.lms.web.json;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@RestController("json/MemberController")
@RequestMapping("/json/member")
public class MemberController {

  @Autowired MemberService memberService;
  @Autowired ServletContext servletContext;

  @RequestMapping("add")
  public Object add(Member member, Part photoFile) {

    HashMap<String,Object> content = new HashMap<>();

    try {
      if(photoFile.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        String uploadDir = servletContext.getRealPath("/upload/member");
        photoFile.write(uploadDir + "/" + filename);
        member.setPhoto(filename);
      }
      memberService.add(member);
      content.put("status", "success");
    } catch (Exception e) {
      content.put("status", "fail");
      content.put("message", e.getMessage());
    }
    return content;
  }

  @RequestMapping("delete")
  public Object delete(int no) throws Exception {
    HashMap<String,Object> content = new HashMap<>();
    try {
      if (memberService.delete(no) == 0) 
        throw new Exception("해당 번호의 회원이 없습니다.");
      content.put("status", "success");
    } catch (Exception e) {
      content.put("status", "fail");
      content.put("message", e.getMessage());
    }
    return content;
  }

  @RequestMapping("detail")
  public Object detail(int no) {

    Member member = memberService.get(no);

    return member;
  }

  @RequestMapping("list")
  public Object list(
      @RequestParam(defaultValue = "1") int pageNo,
      @RequestParam(defaultValue = "3") int pageSize) {

    if (pageSize < 3 || pageSize > 8) {
      // pageSize는 8개 이상 가져 올 수 없다.
      pageSize = 3;
    }

    int rowCount = memberService.size();
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

    HashMap<String,Object> content = new HashMap<>();
    List<Member> members = memberService.list(pageNo, pageSize, null);

    content.put("list", members);
    content.put("pageNo", pageNo);
    content.put("pageSize", pageSize);
    content.put("totalPage", totalPage);

    return content;
  }

  @RequestMapping("search")
  public Object search(String keyword) {

    List<Member> members = memberService.list(0, 0, keyword);

    return members;

  }

  @RequestMapping("update")
  public Object update(
      Member member, Part photoFile) throws Exception {

    HashMap<String,Object> content = new HashMap<>();
    try {
      if(photoFile.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        String uploadDir = servletContext.getRealPath("/upload/member");
        photoFile.write(uploadDir + "/" + filename);
        member.setPhoto(filename);
      }

      if (memberService.update(member) == 0) 
        throw new Exception("해당 번호의 회원이 없습니다.");
      content.put("status", "success");

    } catch (Exception e) {
      content.put("status", "fail");
      content.put("message", e.getMessage());
    }
    return content;
  }
}
