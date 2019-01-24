// static nested class 문법 적용 - Node 클래스를 스태틱 중첩 클래스로 정의한다.
package algorithm.data_structure.linkedlist2;

public class LinkedList {

  protected Node tail;
  protected Node head;
  protected int size;


  public LinkedList() {
    head = new Node();
    tail = head;
    size = 0;
  }

  public void add(Object value) {
    tail.value = value;
    
    Node cursor = new Node();
    
    tail.next = cursor;
    cursor.prev = tail;
    
    tail = cursor;
    
    size++;

  }

  public int size() {
    return size;
  }

  public Object get(int index) {
    if(index < 0 || index >= size) {
      return null;
    }
    
    Node cursor = head;
    for(int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    
    return cursor.value;
  }

  public Object[] toArray() {

    Object[] arr = new Object[size()];
    Node node = head;
    int i = 0;
    while(node != tail) {
      arr[i++] = node.value;
      node = node.next;
    }
    
    return arr;
  }

  public Object set(int index, Object value) {
    if(index < 0 || index >= size) {
      return null;
    }
    
    Node node = head;
    for(int i = 1; i <= index; i++) {
      node  = node.next;
    }
    
    Object old = node.value;
    node.value = value;
    
    return old;
  }


  public int insert(int index, Object value) {
    if(index < 0 || index >= size) {
      return -1;
    }
    
    Node node = new Node(value);
    
    Node cursor = head;
    for(int i = 1; i <= index; i++) {
      cursor  = cursor.next;
    }
    
    node.next = cursor;
    node.prev = cursor.prev;
    cursor.prev = node;
    
    if(node.prev != null) {
      node.prev.next = node;
    } else {
      head = node;
    }
    
    size++;
    
    return 0;
  }

  public Object remove(int index) {
    if (index < 0 || index >= size)
      return null;
    
    // index 위치에 있는 노드를 찾는다.
    Node cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    
    if (cursor.prev != null) {
      // 찾은 노드의 이전 노드가 다음 노드를 가리키게 한다.
      cursor.prev.next = cursor.next;
    } else {
      // 맨 처음 노드를 삭제할 때
      head = cursor.next;
    }
    
    // 찾은 노드의 다음 노드가 이전 노드를 가리키게 한다.
    cursor.next.prev = cursor.prev;
    
    // JVM(Garbage Collection)이 가비지를 효과적으로 계산할 수 있도록 
    // 가비지가 된 객체는 다른 객체를 가리키지 않도록 한다.
    Object old = cursor.value;
    cursor.value = null;
    cursor.prev = null;
    cursor.next = null;
    
    // 크기를 줄인다.
    size--;
    
    // 호출한 쪽에서 필요하면 사용하라고 삭제된 값을 리턴해 준다.
    return old;
  }

  // LinkedList에서만 쓰이는 Node 클래스를 중첩 클래스로 만든다.
  // => Node 클래스는 LinkedList의 특정 인스턴스를 사용하지 않는다.
  // => 그래서 static 중첩 클래스로 정의하는 것이다.
  // => 외부에 공개할 일이 없기 때문에 private으로 접근을 제한한다.
  private static class Node {
    // LinkedList 내부에서만 사용하기 때문에 Node의 멤버를 public으로 공개할 필요는 없다.
    // 그냥 default로 두어라.
    Object value;
    Node next;
    Node prev;
    
    
    Node() {}
    
    public Node(Object value) {
     this.value = value;
    }
  }
  
}
