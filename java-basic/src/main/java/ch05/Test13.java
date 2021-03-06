// 흐름제어문 - for 반복
package ch05;

public class Test13 {

  public static void main(String[] args) {

    for(int i = 1, j = 3, k = 5; i <= 10; i++, j--, k += 2) {
      System.out.printf("(%d, %d, %d) \n", i, j, k);
    } System.out.println();

    for(int i = 1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
    System.out.println("--------------------------------");

    // break
    for(int i = 1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
        if(j == 5)
          break; // break가 소속된 현재 반복문을 멈춘다.
      }
      System.out.println();
    }
    System.out.println("--------------------------------");

    // break 라벨명;
    loop1 : 
      for(int i = 1; i <= 10; i++) {
        for (int j = 1; j <= i; j++) {
          System.out.print(j + " ");
          if(j == 5)
            break loop1; // 라벨로 지정한 문장을 나간다.
        }
        System.out.println();
      }
    System.out.println("\n--------------------------------");

    // continue
    for(int i = 1; i <= 10; i += 2) {
      for (int j =1; j <= i ; j++) {
        if (j % 2 == 0) {
          continue;
        }
        System.out.print(j + " ");
      }                                                                            
      System.out.println();
    }
    System.out.println("---------------------------------");

    // continue
    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) {
        if (j % 2 == 0)
          continue; // 다음 줄로 가지 않고 '변수증가문'으로 이동한다.
        System.out.print(j + " ");
      }
      System.out.println();
    }
    System.out.println("-------------------------");
  }
}



