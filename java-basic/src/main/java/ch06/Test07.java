// 메서드 - 가변 파라미터 vs 배열 레퍼런스
package ch06;

public class Test07 {

  public static void main(String[] args) {
    
    plus1();
    plus1(10);
    plus1(10, 20);
    
    // 배열 레퍼런스는 호출자가 만들어서 넘겨야 한다. 그래서 호출할 때는 가변 파라미터가 편하다.
    plus2(new int[] {});
    plus2(new int[] {10});
    plus2(new int[] {10, 20});
    
  }

  //가변 파라미터
  static int plus1(int... value) {
    // 가변 파라미터는 배열 레퍼런스처럼 사용한다.
    int sum = 0; // <= 메서드 안에 선언된 변수를 로컬변수라고 한다.
    // <= 파라미터도 로컬변수입니까? 예.
    for (int i = 0; i < value.length; i++ ) {
      sum += value[i]; // sum = sum + value
    }
    return sum;
  }

  //배열 레퍼런스 파라미터
  static int plus2(int[] value) {
    // 가변 파라미터는 배열 레퍼런스처럼 사용한다.
    int sum = 0; // <= 메서드 안에 선언된 변수를 로컬변수라고 한다.
    // <= 파라미터도 로컬변수입니까? 예.
    for (int i = 0; i < value.length; i++ ) {
      sum += value[i]; // sum = sum + value
    }
    return sum;
  }

}
