// 애플리케이션 예외의 종류 : Exception 계열의 예외와 RuntimeException 계열의 예외
package ch21.c;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    // 1) Exception 계열의 예외
    // => try ~ catch를 강요하는 예외
    // => oㅖ외 처리를 하지 않으면 컴파일 오류가 발생한다.
    // => Exception의 자식 클래스인 RuntimeException은 제외한다.

    // forName() 메서드?
    // => parameter로 지정한 클래스를 찾아 메모리에 로딩하는 일을 한다.
    // => return 값은 로딩한 클래스의 정보이다.
    // => Oㅣ 메서드는 파라미터에서 지정한 클래스를 찾지 못했을 때
    //    ClassNotFoundException 예외를 발생시킨다.
    // => Oㅣ 예외는 Exception의 자식 클래스이다.
    //    Exception의 자식클래스이고 RuntimeException 계열이 아닐 경우
    //    try ~ catch 블록으로 반드시 예외를 받도록 처리해야한다.
    try { 

      // 사용자로부터 로딩할 클래스 이름을 입력받는다.
      System.out.print("클래스 이름을 입력하세요> ");
      String className = keyboard.nextLine();

      // 사용자가 알려준 클래스를 로딩한다.
      Class<?> clazz = Class.forName(className);

      // 클래스 정보를 가지고 Scanner를 파라미터로 받는 생성자를 얻어낸다.
      Constructor<?> constructor = clazz.getConstructor(Scanner.class);

      Command command = (Command) constructor.newInstance(keyboard);

      // 커맨드 객체를 실행한다.
      // => execute()에서 발생하는 예외는 모두 RuntimeException 계열의 예외이기 때문에
      //     반드시 catch 할 필요가 없다.
      command.execute();

    }  catch (ClassNotFoundException e) {
      // 예외를 발생시키는 방법 : 
      // 클래스 이름을 입력할 때 > ch21.c.Ok
      System.out.println("해당 클래스를 찾지 못했습니다.");
    } catch (NoSuchMethodException e) {
      // 예외를 발생시키는 방법 : 
      // 클래스 이름을 입력할 때 > java.lang.String
      System.out.println("해당 생성자를 찾지 못했습니다.");
    } catch (ReflectiveOperationException e) {
      System.out.println("기타 예외 발생!");

    } 

  }

}

