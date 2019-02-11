package ch19.f;

// LinkedList에서 다룰 데이터를 담는 그릇이다.
public class Node {
  
  Object value;
  Node next;
  Node prev;
  
  
  public Node() {
    
  }
  
  public Node(Object value) {
   this.value = value;
  }
  
  public Node(Object value, Node prev, Node next) {
    this(value);
    this.prev = prev;
    this.next = next;
  }
}