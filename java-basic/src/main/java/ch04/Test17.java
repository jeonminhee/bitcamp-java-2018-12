// 조건연산자 => 조건 ? 값1 : 값2 
//              condition ? expr(ession) : expr(ession);
// 문장?
// => 여러 개의 연산자나 표현식으로 이루어진 한 명령이다.
// => 보통 세미콜론(;)으로 끝낸다.
// 표현식?
// => 문장 중에서 리턴 값이 있는 문장이다.

package ch04;

public class Test17 {
  public static void main(String[] args) {

    int age = 20;

    String result = (age >= 19) ? "성인" : "미성년";
    
    System.out.println(result);
    System.out.println((age >= 19) ? "성인" : "미성년");
    System.out.println((age >= 65) ? "성인" : false);

  }
}