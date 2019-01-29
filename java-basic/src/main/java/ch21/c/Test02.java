// 애플리케이션 예외의 종류 : Exception 계열의 예외 처리 I
package ch21.c;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Test02 {

  public static void main(String[] args) {

    try {
      Scanner keyboard = new Scanner(System.in);
      Class<?> clazz = Class.forName("ch21.c.PlusCommand");
      Constructor<?> constructor = clazz.getConstructor(Scanner.class);
      Command command = (Command) constructor.newInstance(keyboard);
      command.execute();

    }  catch (ClassNotFoundException e) {
      System.out.println("해당 클래스를 찾지 못했습니다.");

    } catch (NoSuchMethodException e) {
      System.out.println("해당 생성자를 찾지 못했습니다.");

    } catch (ReflectiveOperationException e) {
      System.out.println("기타 예외 발생!");
    }

    System.out.println("종료!");

  }

}

