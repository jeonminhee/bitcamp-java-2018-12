package com.eomcs.lms.web;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@Controller
@RequestMapping("/member")
public class MemberController {
  
  @Autowired MemberService memberService;
  @Autowired ServletContext servletContext;

  @GetMapping("form")
  public void form() throws Exception {
  }
  
  @RequestMapping("add")
  public String add(Member member, Part photoFile) throws Exception {

    if(photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String uploadDir = servletContext.getRealPath("/upload/member");
      photoFile.write(uploadDir + "/" + filename);
      member.setPhoto(filename);
    }

    memberService.add(member);

    return "redirect:.";
  }
  
  @RequestMapping("delete/{no}")
  public String delete(@PathVariable int no) throws Exception {

    if (memberService.delete(no) == 0) {
      throw new Exception("해당 번호의 회원이 없습니다.");
    }
    return "redirect:../";
  }
  
  @RequestMapping("{no}")
  public String detail(@PathVariable int no, Model model) throws Exception {

    Member member = memberService.get(no);
    model.addAttribute("member", member);

    return "member/detail";
  }
  
  @RequestMapping
  public String list(Model model) throws Exception {
    
    List<Member> members = memberService.list(null);

    model.addAttribute("list", members);
    
    return "member/list";
  }
  
  @RequestMapping("search")
  public void search(String keyword, Model model) throws Exception {

    List<Member> members = memberService.list(keyword);
    
    model.addAttribute("members", members);
    
  }
  
  @RequestMapping("update")
  public String update(
      Member member, Part photoFile) throws Exception {

    if(photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String uploadDir = servletContext.getRealPath("/upload/member");
      photoFile.write(uploadDir + "/" + filename);
      member.setPhoto(filename);
    }

    if (memberService.update(member) == 0) {
      throw new Exception("해당 번호의 회원이 없습니다.");
    }
    return "redirect:.";
  }
}
