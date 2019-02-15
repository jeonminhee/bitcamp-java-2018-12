package design_pattern.proxy.after.server;

// 실제 일을 하는 객체는 인터페이스 규칙에 따라 동작하도록 구현되어야한다.
public class CalculatorImpl implements Calculator {
  
  public int plus (int a, int b) {
    return a + b;
  }
  
  public int minus(int a, int b) {
    return a - b;
  }
}
