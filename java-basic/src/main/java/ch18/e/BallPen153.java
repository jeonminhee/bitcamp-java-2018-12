package ch18.e;

public class BallPen153 extends Monami implements Pen{
  @Override
  public void write(String text) {
    if(!this.use) {
      return;
    } else {
      System.out.println("모나미 **" + text + " **");
    } 
  }
  
}
