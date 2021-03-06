// 콘솔로 출력하기
package ch02;

public class Test11 {
  public static void main(String[] args) {
    // 값 출력하기
    // println() = 출력 + 줄바꿈
    System.out.println(20);
    System.out.println(3.14f);
    System.out.println("Hello");
    System.out.println('Y');
    System.out.println(true);
    
    // 값이 주지 않으면 줄바꿈만 수행힌다.
    System.out.println();
    
    //print()는 출력만 한다. 줄바꿈 없다.
    System.out.print(20);
    System.out.print(20);
    System.out.print(3.14f);
    System.out.print("Hello");
    System.out.print('Y');
    System.out.print(true);
    
    System.out.print('\n');
    
    System.out.print("OK!\n"); // == println("OK!");
    System.out.print("HI!\n"); // == println("HI!");
    
  }
}

