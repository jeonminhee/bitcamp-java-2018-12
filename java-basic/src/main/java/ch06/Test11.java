// 메서드 - call by value와 call by reference
package ch06;

public class Test11 {

  public static void main(String[] args) {
    int value = 100;
    m1(value);
    System.out.println(value); 
    
    int[] arr = new int[] {100, 200, 300};
    System.out.println(arr[1]);
    m2(arr); // arr의 값을 넘긴다. 어? call by value가 아닌가용?
                 // 그런데 arr의 값은 배열의 주소이다.
                 // 이렇게 주소를 넘겨주는 것을 call by reference라 부른다.
    System.out.println(arr[1]);
    
  }

  // m1()의 value는 값을 받는 변수이다.
  // 따라서 main()의 value 변수와 관계가 없다.
  static void m1(int value) {
    value *= 2;
  }
  
  static void m2(int[] arr) {
    arr[1] = 111;
  }
  
}
