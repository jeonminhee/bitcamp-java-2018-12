package com.eomcs.lms.handler;
import com.eomcs.lms.context.Component;
import com.eomcs.lms.dao.MemberDao;

@Component("/member/delete")
public class MemberDeleteCommand extends AbstractCommand {

  MemberDao memberDao;

  public MemberDeleteCommand(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void execute(Response response) throws Exception {

      int no = response.requestInt("번호? ");
      
      if(memberDao.delete(no) == 0) {
        response.println("해당 회원을 찾을 수 없습니다.");
      } else {
        response.println("회원을 삭제했습니다.");
      }

  }
}
