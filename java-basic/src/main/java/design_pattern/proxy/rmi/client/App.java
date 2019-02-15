package design_pattern.proxy.rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import design_pattern.proxy.rmi.server.Calculator;

public class App {

  public static void main(String[] args) throws Exception {
    
    Scanner keyboard = new Scanner(System.in);
    
    // RMI 기술을 사용하면 개발자가 Skeleton이나 Stub 객체를 직접 작성할 필요가 없다.
    // RMI Registry에 등록된 Stub를 받아서 사용하면 된다.
    
    // 1) RMI 레지스트리 서버에 스텁 객체를 받기 위해 사용 할 도구를 준비한다.
    //
    // => 127.0.0.1로 접속하여 찾을 수 있다.
    // => localhost 로 접속하여 찾을 수 있다.
    // => etc/hosts 파일에 가상의 호스트 이름을 등록한 후에 접속하여 찾을 수 있다.
    Registry registry = LocateRegistry.getRegistry("study.bitcamp.co.kr");
    // 2) 이 도구를 사용하여 RMI Registry 서버에 등록된 스텁을 등록된 이름으로 찾는다.
    // => lookup() : RMI Registry 서버에서 해당 이름으로 등록된 스텁을 찾아서 리턴한다.
    Calculator clac = (Calculator) registry.lookup("calc");
    
    while(true) {
      System.out.print("계산식>(예 : 100 + 200) ");
      String input = keyboard.nextLine();
      if(input.equalsIgnoreCase("quit")) {
        break;
      }
      String[] values = input.split(" ");
      try {
        int a = Integer.parseInt(values[0]);
        int b = Integer.parseInt(values[2]);
        String op = values[1];
        switch (op) {
          case "+" : System.out.println(clac.plus(a, b)); break;
          case "-" : System.out.println(clac.minus(a, b)); break;
          default : System.out.println("해당 연산자를 지원하지 않습니다.");
        }
        
      } catch (Exception e) {
        System.out.println("식 또는 계산 오류 : " + e.getMessage() );
      }
    }
    keyboard.close();
  }

}
