// 메서드 - 가변 파라미터
package ch06;

public class Test06 {

  public static void main(String[] args) {
    int result = plus(); // 아규먼트를 넘거주지않아도 된다. 왜? 0개 이상이니깐!
    System.out.println(result);
    
    result = plus(2);
    System.out.println(result);
    
    result = plus(2, 3);
    System.out.println(result);
    
    result = plus(2, 3, 4);
    System.out.println(result);
    
    // 가변 파라미터인 경우 값을 배열에 담아서 넘겨도된다.
    result = plus(new int[] {10, 20, 30});
    // 배열의 주소를 파라미터의 값으로 놓는다. = > plus(2157번지)
    // 주의! 배열 자체가 넘어가는 것이 아니라 배열의 주소가 넘어가는 것이다.
    System.out.println(result);
  }

  static int plus(int... value) {
    // 가변 파라미터는 배열 레퍼런스처럼 사용한다.
    int sum = 0; // <= 메서드 안에 선언된 변수를 로컬변수라고 한다.
                   // <= 파라미터도 로컬변수입니까? 예.
    for (int i = 0; i < value.length; i++ ) {
      sum += value[i]; // sum = sum + value
    }
    return sum;
  }

}
