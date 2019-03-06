package ch26.d;

import java.sql.Date;

public class Board2 {
  
  private int no;
  private String title;
  private String contents;
  private Date createddate;
  private int viewcount;
  
  @Override
  public String toString() {
    return "Board2 [no=" + no + ", title=" + title + ", contents=" + contents + ", createddate="
        + createddate + ", viewcount=" + viewcount + "]";
  }
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public Date getCreateddate() {
    return createddate;
  }
  public void setCreateddate(Date createddate) {
    this.createddate = createddate;
  }
  public int getViewcount() {
    return viewcount;
  }
  public void setViewcount(int viewcount) {
    this.viewcount = viewcount;
  }
  

  
}
