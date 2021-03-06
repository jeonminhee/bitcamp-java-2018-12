// 11단계: AbstractService 상속 받기
package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

public interface MemberDao {

  public void insert(Member member);
  public List<Member> findAll();
  public Member findByNo(int no);
  public int update(Member member);
  public int delete(int no);
  
}







