package ch13.a;

public class Calculator2 {
  private int result;

  public int getResult() {
    return this.result;
  }

  public void plus(int value) {
    this.result += value;
  }

  public void minus(int value) {
    this.result -= value;
  }
  
  public void mutiple(int value) {
    this.result *= value;
  }
  
  public void divide(int value) {
    this.result /= value;
  }
}
