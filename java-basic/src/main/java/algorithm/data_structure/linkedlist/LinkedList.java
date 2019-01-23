package algorithm.data_structure.linkedlist;

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
    return null;
  }

}
