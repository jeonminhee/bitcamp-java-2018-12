// 인스턴스 필드의 초기화 - 인스턴스 블록을 통해 필드를 초기화 하기 
package ch10;

class Monitor3 {
  
  // 초기화 문장?
  // 변수를 선언할 때 값을 설정하는 것을 초기화 문장이라 부른다.
  int bright; // 밝기 (0% ~ 100%)
  int contrast; // 명암 (0% ~ 100%)
  int widtjRes; // 해상도 너비
  int heightRes; // 해상도 높이
  
  { // 인스턴스 블록 <= 실무에서는 인스턴스 블록을 잘 사용하지 않는다. 대신 생성자를 주로 사용한다.
    this.bright = 50;
    this.contrast = 50;
    this.widtjRes = 1920;
    this.heightRes = 1080;
  }
  
  void display () {
    System.out.println("---------------------------------------");
    System.out.printf("밝기(%d) \n", this.bright);
    System.out.printf("명암(%d) \n", this.contrast);
    System.out.printf("해상도(%d x %d) \n", this.widtjRes, this.heightRes);
    System.out.println("---------------------------------------");

  }
  
}

public class Test05 {
  public static void main(String[] args) {
    // 모니터 인스턴스 생성
    Monitor3 m1 = new Monitor3();

     // 인스턴스 필드의 값이 유효한 기본 값들로 미리 초기화 되었기 때문에 바로 사용가능하다.
    m1.display();
    
    // 물론 특정 속성의 값을 바꾼 후에 사용해도 된다.
    m1.bright = 40;
    
    m1.display();
  }
}

