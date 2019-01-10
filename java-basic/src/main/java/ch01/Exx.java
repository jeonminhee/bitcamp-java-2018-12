package ch01;

public class Exx {

  static class Score {
    String name;
    int math;
    int eng;
    int kor;
    int sum;
    float aver;
  }
  
  static void printScore(Score s) {
    s.sum = s.math + s.eng + s.kor;
    s.aver = s.sum / 3f;
    System.out.printf("이름 : %s, 영어 : %d, 수학 : %d, 국어 : %d, 총점 : %d, 평균 : %f\n", 
        s.name, s.eng, s.math, s.kor, s.sum, s.aver);
  }
  public static void main(String[] args) {

    Score s1 = new Score();
    s1.math = 100;
    s1.eng = 50;
    s1.kor = 40;
    s1.name = "전민희";

    printScore(s1);
    
  }
}