package ch18.b;

public interface SpecA {
  //private abstract void m1(); // 컴파일 오류!
  
  //protected abstract void m1(); // 컴파일 오류!
  
  //ublic abstract void m1(); // OK!
  
  // abstract void m1(); // OK!
  
  void m1(); // OK! public abstract 생략.
  void m2();
}
