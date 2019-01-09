// 메서드 - 파라미터와 리턴값
package ch06;

public class Test04 {

  public static void main(String[] args) {
    
    String str = greet("홍길동");
    System.out.println(str);
    
    int result = plus(10, 20);
    System.out.println(result);
    
  }

  static String greet(String name) {
    // 메서드를 실행한 후 호출자에게 값을 리턴하려면 
    return name + "님 반갑습니다!";
  }
  
  static int plus(int a, int b) {
    return a + b;
  }

}
