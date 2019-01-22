package ch18.a;

public class Test01 {

  public static void main(String[] args) {
    A tool;
    
    use(new ToolA());
    use(new ToolB());
    
    // use(new String("Hello")); // 컴파일 오류!
    
    }
  
  static void use(A tool) {
    tool.m1();
  }

}
