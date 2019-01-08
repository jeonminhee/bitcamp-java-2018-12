// 흐름제어문 - switch
package ch05;

public class Test04 {

  public static void main(String[] args) {
    byte b = 1; //switch 조건으로 OK!
    short s = 1; //switch 조건으로 OK!
    char c = 1; //switch 조건으로 OK!
    int i = 1; //switch 조건으로 OK!
    long l = 1L; //switch 조건으로 사용할 수 없다.
    float f = 1.0f; //switch 조건으로 사용할 수 없다.
    double d = 1.0; //switch 조건으로 사용할 수 없다.

    switch(b) {
      case 1 : 
        System.out.println("11");
        System.out.println("1111");
        break;
      case 2 :
        System.out.println("22");
        System.out.println("2222");
        break;
      case 'A' : // 'A'의 리턴 값은 2바이트 정수(UTF-16 Code) 값이다.
        System.out.println("AAAA");
      default:
        System.out.println("????");
    }
  }
}