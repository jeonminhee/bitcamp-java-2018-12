// 추상 메서드와 추상 클래스
package ch17.a;

// 추상 메서드는 클래스는 추상 클래스만 가질 수 있다.
// => 추상 클래스는 인스턴스를 생성할 수 없다.
public abstract class A {
  
  // 구현 메서드
  public void m1() {
    System.out.println("A.m1()");
  }
  
  // 추상 메서드 
  // => 메서드 몸체(body)가 없다.
  // => 메서드 선언부에 abstract를 붙인다.
  // => 추상 메서드는 오직 추상 클래스 만이 가질 수 있다.
  //    즉 추상 메서드가 있는 클래스는 추상 클래스로 선언해야 한다.
  //
  // 추상 메서드의 용도
  // => 서브 클래스가 반드시 구현해야 하는 메서드가 있다면 추상 메서드로 선언하라!
  // => 추상 메서드를 상속 받은 서브 클래스는 반드시 추상 메서드를 구현해야 한다.
  //    만약 구현하지 않으면 서브 클래스도 추상 클래스가 되어야 한다.
  //    왜? 추상 메서드를 갖는 클래스는 오직 추상 클래스만이 가능하기 때문이다.
  public abstract void m2(String name);
}


