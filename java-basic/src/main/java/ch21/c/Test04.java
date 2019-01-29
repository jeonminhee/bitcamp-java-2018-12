// 애플리케이션 예외의 종류 : Exception 계열의 예외 처리 III
package ch21.c;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Test04 {

  public static void main(String[] args) 
      throws Exception {
//      throws ClassNotFoundException, 
//             NoSuchMethodException, 
//             InstantiationException, 
//             IllegalAccessException, 
//             InvocationTargetException{

    Scanner keyboard = new Scanner(System.in);
    Class<?> clazz = Class.forName("ch21.c.PlusCommand");
    Constructor<?> constructor = clazz.getConstructor(Scanner.class);
    Command command = (Command) constructor.newInstance(keyboard);
    command.execute();

  }
}

