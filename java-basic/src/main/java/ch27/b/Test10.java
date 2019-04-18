// 리플렉션(reflection) API - 배열 항목의 타입 알아내기
package ch27.b;

import java.sql.Date;

public class Test10 {

  public static void main(String[] args) throws Exception{
    // 배열 타입이 아닌 경우 항목이 없기 때문에 getComponent의 리턴값은 null이다.
    // System.out.println(byte.class.getComponentType().getName());
    
    System.out.println("--------------------------------------");
    
    System.out.println(byte.class.getName());
    System.out.println(new byte[] {}.getClass().getName());
    System.out.println(new byte[] {}.getClass().getComponentType().getName());
    
    System.out.println("--------------------------------------");
    
    System.out.println(short.class.getName());
    System.out.println(new short[] {}.getClass().getName());
    System.out.println(new short[] {}.getClass().getComponentType().getName());
    
    System.out.println("--------------------------------------");
    
    System.out.println(int.class.getName());
    System.out.println(new int[] {}.getClass().getName());
    System.out.println(new int[] {}.getClass().getComponentType().getName());
    
    System.out.println("--------------------------------------");
    
    System.out.println(long.class.getName());
    System.out.println(new long[] {}.getClass().getName());
    System.out.println(new long[] {}.getClass().getComponentType().getName());
    
    System.out.println("--------------------------------------");
    
    System.out.println(float.class.getName());
    System.out.println(new float[] {}.getClass().getName());
    System.out.println(new float[] {}.getClass().getComponentType().getName());    
    
    System.out.println("--------------------------------------");
    
    System.out.println(double.class.getName());
    System.out.println(new double[] {}.getClass().getName());
    System.out.println(new double[] {}.getClass().getComponentType().getName());
    
    System.out.println("--------------------------------------");
    
    System.out.println(long.class.getName());
    System.out.println(new long[] {}.getClass().getName());
    System.out.println(new long[] {}.getClass().getComponentType().getName());
    
    System.out.println("--------------------------------------");
    
    System.out.println(char.class.getName());
    System.out.println(new char[] {}.getClass().getName());
    System.out.println(new char[] {}.getClass().getComponentType().getName());
    
    System.out.println("--------------------------------------");
    
    System.out.println(String.class.getName());
    System.out.println(new String[] {}.getClass().getName());
    System.out.println(new String[] {}.getClass().getComponentType().getName());
    
    System.out.println("--------------------------------------");
    
    System.out.println(Date.class.getName());
    System.out.println(new Date[] {}.getClass().getName());
    System.out.println(new Date[] {}.getClass().getComponentType().getName());
    
  }
}