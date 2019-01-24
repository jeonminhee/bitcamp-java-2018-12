// 제네릭 적용하기
package algorithm.data_structure.linkedlist3;

// LinkedList에 보관되는 값의 타입을 E라고 가정한다.
// => E 타입이라고 가정하고 코드를 작성한다.
// => E가 무슨 타입인지는 LinkedList를 사용할 때 결정된다.
//
public class LinkedList<E> {

  protected Node<E> tail;
  protected Node<E> head;
  protected int size;


  public LinkedList() {
    head = new Node<E>(); // 생략해도 됨.
    tail = head;
    size = 0;
  }

  public void add(E value) {
    tail.value = value;
    
    Node<E> cursor = new Node<>();
    
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
    
    Node<E> cursor = head;
    for(int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    
    return cursor.value;
  }

  public Object[] toArray() {

    Object[] arr = new Object[size()];
    Node<E> node = head;
    int i = 0;
    while(node != tail) {
      arr[i++] = node.value;
      node = node.next;
    }
    
    return arr;
  }

  public E set(int index, E value) {
    if(index < 0 || index >= size) {
      return null;
    }
    
    Node<E> node = head;
    for(int i = 1; i <= index; i++) {
      node  = node.next;
    }
    
    E old = node.value;
    node.value = value;
    
    return old;
  }


  public int insert(int index, E value) {
    if(index < 0 || index >= size) {
      return -1;
    }
    
    Node<E> node = new Node<>(value);
    
    Node<E> cursor = head;
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

  public E remove(int index) {
    if (index < 0 || index >= size)
      return null;
    
    // index 위치에 있는 노드를 찾는다.
    Node<E> cursor = head;
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
    E old = cursor.value;
    cursor.value = null;
    cursor.prev = null;
    cursor.next = null;
    
    // 크기를 줄인다.
    size--;
    
    // 호출한 쪽에서 필요하면 사용하라고 삭제된 값을 리턴해 준다.
    return old;
  }

  // Node가 다루는 값의 타입을 제네릭 (generic)으로 선언하자.
  // => 즉 Node가 다루는 데이터의 타입을 E라고 명명하고 코드를 작성한다.
  // => Node 클래스를 사용하는 시점에 E가 무슨 타입인지 결정될 것이다.
  private static class Node<E> {
    E value;
    Node<E> next;
    Node<E> prev;
    
    
    Node() {}
    
    public Node(E value) {
     this.value = value;
    }
  }
  
}
