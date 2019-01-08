// 흐름제어문 - switch 과 문자열
package ch05;

public class Test05 {

  public static void main(String[] args) {
    String str = "yes";

    switch(str) {
      case "ok" : 
        System.out.println("okokok");
        break;
      case "no" :
        System.out.println("nononono");
        break;
      default:
        System.out.println("????");
    }
  }
}