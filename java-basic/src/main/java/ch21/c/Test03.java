// 애플리케이션 예외의 종류 : Exception 계열의 예외 처리 II
package ch21.c;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Test03 {

  public static void main(String[] args) 
  // throws ClassNotFoundException {
      throws ClassNotFoundException, 
             NoSuchMethodException, 
             InstantiationException, 
             IllegalAccessException, 
             InvocationTargetException {

    Scanner keyboard = new Scanner(System.in);
    Class<?> clazz = Class.forName("ch21.c.PlusCommand");
    Constructor<?> constructor = clazz.getConstructor(Scanner.class);
    Command command = (Command) constructor.newInstance(keyboard);
    command.execute();

  }
}

