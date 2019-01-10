// main() 메서드의 파라미터 응용 I
package ch06;

public class Test15 {

  public static void main(String[] args) {
    // 학생의 이름과 국영수 점수를 입력 받아 총점과 평균을 출력하라.
    // $ java -cp ./bin/main ch06.Test15 홍길동 100 100 90
    // 총점 : 290
    // 평균 : 96.9

    int i = 0;
    int sum = 0;

    if (args.length >= 4) {
      System.out.println("실행 형식 : java -cp ./bin/main ch06.Test15 이름 국어 영어 수학");
      return;
    }

    for (i = 1; i < args.length; i++) {
      sum += Integer.parseInt(args[i]);
    }
    System.out.printf("이름 : %s\n",args[0]);
    System.out.printf("총점 : %d\n",sum);
    System.out.printf("평균 : %.1f\n",sum/3f);


  }
}

