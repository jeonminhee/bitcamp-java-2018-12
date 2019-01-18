// hash code 응용 IV - 사용자가 만든 클래스를 key로 사용하기
package ch15;

import java.util.HashMap;

class key {
  String contents;
  
  public key (String contents) {
    this.contents = contents;
  }

  @Override
  public String toString() {
    return "key [contents=" + contents + "]";
  }
  
}
public class Test10 {
  public static void main(String[] args) {
    
    HashMap map = new HashMap();
    
    
     key k1 = new key("ok");
     key k2 = new key("no");
     key k3 = new key("haha");
     key k4 = new key("ohora");
     key k5 = new key("hul");
     
     
    map .put(k1, new Student("홍길동", 20, false));
    map.put(k2, new Student("임꺽정", 30, true));
    map.put(k3, new Student("유관순", 17, true));
    map.put(k4, new Student("안중근", 24, true));
    map .put(k5, new Student("윤봉길", 22, false));
    
    System.out.println(map.get(k3));
    
    key k6 = new key("haha");
    
    System.out.println(k3 == k6);
    System.out.println(k3.hashCode());
    System.out.println(k3.hashCode());
    System.out.println(k3.equals(k6));
    
//   System.out.println(map.get(k6));
//   
//   String k7 = new String("HaHa");
//   System.out.println(map.get(k7));
   
  }
}
