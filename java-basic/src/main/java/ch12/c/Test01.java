package ch12.c;

public class Test01 {

  public static void main(String[] args) {
    My obj1 = new My();

    // private 접근 불가!
    // obj1.v1 = 100; // 컴파일 오류!

    // default
    obj1.v2 = 100;

    obj1.v3 = 100;

    obj1.v4 = 100;
  }

}
