// 예외 던지기 - throw 명령을 사용하여 예외를 보고하기
package ch21.d;

import java.util.ArrayList;

public class Test03 {
  static ArrayList<String> list = new ArrayList<>();

  public static void main(String[] args) {
    addName("홍길동");
    addName("임꺽정");
    addName(null); // 전학 간 학생인 경우 해당 번호의 이름을 null로 설정한다고 가정하자!
    addName(null); // 전학 간 학생인 경우 해당 번호의 이름을 null로 설정한다고 가정하자!
    addName("유관순");



    for(int i = 0; i <= list.size(); i++) {
      // 리턴 값이 아닌 별개의 경로로 전달되는 예외는 
      // try ~ catch로 처리한다.
      //
      try {
        String name = getName(i);
        System.out.println(getName(i));
      } catch (Exception e) {
        System.out.println("목록에서 데이터를 꺼낸 중에 오류 발생!");

      }
    }


    System.out.printf("입력된 이름 개수는 %d입니다.\n", list.size());



    try {
      // ㄴ throw 명령으로 전달된 예외 정보는 catch 블록을 통해 별개의 경로로 받을 수 있다.
      // 따라서 예전처럼 리턴 값으로 받을 때에 문제점이 없다.
      //
    int result = divide(19191919, -1); 
    System.out.println(result);
    } catch (Exception e) {
      System.out.println("나누기 오류입니다.");     
    }

  }

  static void addName(String name) {
    list.add(name);
  }

  // 3) throw 명령으로 예외를 보고하기
  // => throw 명령을 사용하여 예외 객체를 호출자에게 던진다.
  //    throw [java.lang.Throwable 객체];

  static String getName(int index) throws Exception { // 어떤 예외 던지는지 알려주기
    if(index < 0 || index >= list.size()) {
      // throw new Object(); // 컴파일 오류!
      // throw 명령으로 던질 수 있는 예외는 java.lang.Throwable 타입이어야 한다.
      // 다른 타입의 객체는 던질 수 없다.
      //
      throw new Exception("무효한 인덱스입니다."); // 예외 던지기
    }
    return list.get(index);
  }

  static int divide(int a , int b) throws Exception {
    if(b == 0) {
      throw new Exception("0으로 나눌 수 없습니다.");
    }
    return a/b;
  }

}
