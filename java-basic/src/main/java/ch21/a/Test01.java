// 예외처리 - 예외의 종류
package ch21.a;

public class Test01 {

  public static void main(String[] args) {
    
    // 1) 시스템 예외
    // => 자바버츄얼머신(JVM)이 발생시키는 예외
    // => 애플리케이션에서 처리할 수 없다.
    // => 애플리케이션에 현재 작업 결과를 적절히 저장한 후 즉시 종료해야한다.
    // => ㅁ Error 계열의 예외이다.
    //     ㅁ java.lang.Object
    //         ㄴ java.lang.Throwable
    //             ㄴ java.lang.Error
    // => 예 ) StackOverflowError, OutOfMemoryError, IOError, ThreadDeath 등
    //
    
    // ㅁ StackOverflowError 발생시키기
    // 예외를 처리하지 않으면 JVM에게 예외가 전달되고 JVM은 즉시 멈춘다.
    // => ㅁJVM이 멈추기 전에 현재까지 작업한 것을 저장하고 싶다면 예외 처리 코드를 추가해야한다.
    // ㅁ System.out.println(sum(100000)); // 실행오류!

    // 2) 애플리케이션 예외
    // => 애플리케이션에서 발생시키는 예외이다.
    // => >>예외처리<<라 함은 이 애플리케이션 예외를 다루는 것을 말한다.
    // => 애플리케이션에서 예외를 처리하지 않으면 JVM은 실행을 멈춘다.
    // => 실행을 멈추지않게 하려면 애플리케이션 예외가 발생 했을 때 적절히 조취를 취해야한다.
    // => ㅁException 계열의 예외이다.
    //     ㅁ java.lang.Object
    //         ㄴ java.lang.Throwable
    //             ㄴ java.lang.Exception
    // => 예) ArrayIndexOutOfBoundsException, ClassCastException, ClassNotFoundException
    //    예) CloneNotSupportedException, NullPointerException, IOException, SQLException
    //    예) FileNotFoundException, SocketException, MalformedURLException, RuntimeException
    //    예) ArithmeticException (0으로 나눔)
    
    // 애플리케이션 예외 발생시키기
    // => 예외를 처리하지 않으면 JVM에게 전달되고 JVM은 즉시 멈춘다.
    int result = 100 / 0;
    // 위에서 ArithmeticException: / by zero 예외 발생
    
    // 위의 코드에서 예외가 발생하면 다음 코드는 실행할 수 없다.
    // 왜? 즉시 JVM에게 예외 내용이 보고되고, JVM은 실행을 멈춘다.
    System.out.println("실행 완료!");
    
  }

  static long sum(long value) {
    if(value == 0)
      return 0;
    
    return value + sum(value - 1);
  }
  
}




