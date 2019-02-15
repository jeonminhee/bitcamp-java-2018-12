package design_pattern.proxy.after.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

// 클라이언트 요청을 서버에 전달하고 서버의 작업 결과를 클라이언트에게 리턴하는 일을 한다.
// => 즉, 중계인 역할을 수행한다.
// => 이렇게 원격에서 객체를 사용할 수 있도록 중계인의 역할을 수행하는 객체를
//    ㄴ Object Request Broker (ORB)라 부른다.
// => 객체가 있는 서버 측에서 요청을 응답을 대행하는 ORB를 "스켈레톤(skeleton)"이라 부른다.
// => 객체를 사용하는 클라이언트 측에서 요청과 응답을 대행하는 ORB를 "스텁(stub)"이라 부른다.
//
// 스텁(Stub)은 실제 일을 하는 객체를 대행하기 때문에 같은 규칙에 따라 구현되어야한다. 
// => 클라이언트는 이 스텁 클래스가 실제 일을 하는 객체인양 그대로 사용한다.
// => 이렇게 실제 일을 하는 객체와 같은 규칙을 따르지만 메서드가 호출될 때
//    자신이 직접 일을 하지않고 실제 일을 하는 객체에게 위임한다. 
//
//    이런 식으로 설계하는 것을 "프록시(proxy) 디자인 패턴"이라 한다.
//
public class CalculatorStub implements Calculator {
  
  private int compute(int a, int b, String op) throws Exception{

    try(Socket s = new Socket("localhost", 8888);
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        DataInputStream in = new DataInputStream(s.getInputStream())){

      out.writeInt(a);
      out.writeInt(b);
      out.writeUTF(op);
      out.flush();

      if(in.readUTF().equalsIgnoreCase("OK")) {
        return in.readInt();
      } else {
        throw new RuntimeException(in.readUTF());
      }
    }
  }

  @Override
  public int plus(int a, int b) {
    try {
    return compute(a, b, "+");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int minus(int a, int b) {
    try {
      return compute(a, b, "-");
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
  }
}
