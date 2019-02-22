package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;

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
