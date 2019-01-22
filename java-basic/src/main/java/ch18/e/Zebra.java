package ch18.e;

public class Zebra {
  
  public final static int ON = 1;
  public final static int OFF = 2;
  
  boolean use;
  
  public void rotate(int direction) {
    if(direction == 1) { // 오른쪽 회전
      this.use = true;
    } else if (direction == 2) { // 왼쪽 회전
      this.use = false;
    }
  }
}
