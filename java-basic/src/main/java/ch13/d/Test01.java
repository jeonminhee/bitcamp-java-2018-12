// 상속 관계가 있을 때 인스턴스 변수 생성 과정과 사용 과정
package ch13.d;

public class Test01 {

  public static void main(String[] args) {
    B obj = new B();
    // B 클래스의 인스턴스 생성 과정
    // 1) B의 수퍼 클래스(A 클래스)를 로딩한다(로딩되어 있지 않다면)
    //    : 스태틱 필드 생성 => 스태틱 블록 실행 
     // 2) B 클래스 로딩(로딩되어 있지 않다면)
    //    : 스태틱 필드 생성 => 스태틱 블록 실행
    // 3) 인스턴스 필드 생성
    //    : 수퍼 클래스의 인스턴스 필드부터 생성한다.
    //    v1   |    v2    : A의 v1 필드 생성 => B의 v2 필드 생성
    //    0    |    0     : 각 필드를 기본 값으로 설정한다.
    //    100  |    0     : A 클래스의 초기화 문장 수행
    //    100  |    200   : B 클래스의 초기화 문장 수행
    //
    // => B 클래스의 인스턴스는 수퍼 클래스의 인스턴스 필드도 포함한다.
    //

    // A 클래스의 m1()을 호출하면서 B 인스턴스의 주소를 넘겨준다.
    // 메서드 호출 과정
    // : B 클래스에서 m1() 찾는다 => A 클래스에서 m1()을 찾는다.
    // : 메서드를 호출할 때마다 수퍼 클래스를 따라 올라 가면서 찾기 때문에 
    //   그래서 객체지향 프로그래밍이 c와 같은 언어 보다 속도가 느리다고 하는 것이다.
    //
    obj.m1();
    

    obj.m2(); // B 클래스에서 m2()를 찾는다.

  }
}
