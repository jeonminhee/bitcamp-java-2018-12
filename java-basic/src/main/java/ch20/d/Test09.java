// Hashtable에서 value 목록 꺼내기 - elements()
package ch20.d;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

public class Test09 {

  public static void main(String[] args) {

    class Student {
      String name;
      int age;

      public Student(String name, int age) {
        this.name = name;
        this.age = age;
      }

      @Override
      public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
      }
    }

    Hashtable<String, Student> map = new Hashtable<>();

    map.put("aaa", new Student("홍길동", 20));
    map.put("bbb", new Student("임꺽정",30));
    
    Student s = new Student("안중근",40);
        
    map.put("ccc", s);
    map.put("ddd", s);
   
    // value 목록 꺼내기
    Enumeration<Student> values = map.elements();
    while(values.hasMoreElements()) {
      System.out.println(values.nextElement());
    }

  }

}

/*
List vs Set vs Map
 */
