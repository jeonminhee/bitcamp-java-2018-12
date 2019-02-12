package ch23.h;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Test05 {

  public static void main(String[] args) throws Exception {
    
    URL url = new URL("https://www.naver.com/");
    
    URLConnection con = url.openConnection();
    // 웹 서버와 연결한다,
    con.connect();
    
    
    // 웹 서버의 응답 데이터를 읽어들일 도구를 리턴한다.
    InputStream in = con.getInputStream();
    
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
