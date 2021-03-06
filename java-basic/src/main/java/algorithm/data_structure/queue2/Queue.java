// 제네릭 적용
package algorithm.data_structure.queue2;
// 기존 기능을 활용하는 가장 쉬운 방법이 상속이다.
// 
import algorithm.data_structure.linkedlist3.LinkedList;

// Queue가 보관하는 데이터 타입을 E라고 가정하자.
// => E라고 가정한 상태에서 코드를 작성한다.
// 
public class Queue<E> extends LinkedList<E> {

  public void offer(E value) {
    this.add(value);
  }

  public E poll() {
    return this.remove(0);

  }

  public boolean empty() {
    return size == 0;

  }
}
