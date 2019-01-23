package algorithm.data_structure.queue;
// 기존 기능을 활용하는 가장 쉬운 방법이 상속이다.
// 
import algorithm.data_structure.linkedlist.LinkedList;

public class Queue extends LinkedList {

  public void offer(Object value) {
    this.add(value);
  }

  public Object poll() {
    return this.remove(0);

  }

  public boolean empty() {
    return size == 0;

  }
}
