package ch23.h;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Test04 {

  public static void main(String[] args) throws Exception {
    
    URL url = new URL("https://www.naver.com/");

    // 서버와 연결하고 데이터를 읽어들일 도구를 리턴한다.
    InputStream in = url.openStream();
    
    BufferedReader in2 = new BufferedReader(new InputStreamReader(in));
    
    while(true) {
      String str = in2.readLine();
      if(str == null) {
        break;
      }
        
      System.out.println(str);
    }
    
    in2.close();
    in.close();
  }
}
