// 클래스, 레퍼런스와 인스턴스
package ch07;

public class Test04 {
  // 클래스
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }

  static void printScore(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
    System.out.printf("%s : %d, %d, %d, %d, %.1f\n", 
        s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
  
  public static void main(String[] args) {
    // 레퍼런스
    Score s1;
    
    // 인스턴스
    s1 = new Score();

    // 인스턴스 필드
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 100;
    s1.math = 100;

    printScore(s1);

  }
}



