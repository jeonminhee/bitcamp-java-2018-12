package ch12.c;

public class My {
  // private : 내부 멤버만 접근 가능
  private int v1;
  
  int v2; //default
  protected int v3;
  public int v4;
  
  
  public void m1() {
    this.v1 = 100;
  }
}
