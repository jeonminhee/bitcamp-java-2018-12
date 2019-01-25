package design_pattern.iterator;

public class ArrayList<E> {
  final static int DEFAULT_SIZE = 5;
  Object[] arr;
  int size = 0;

  public ArrayList() {
    this(0);
  }

  public ArrayList(int capacity) {
    if(capacity > DEFAULT_SIZE) {
      arr = new Object[capacity];
    } else {
      arr = new Object[DEFAULT_SIZE];
    }
  }

  public Object[] toArray() {
    Object[] list = new Object[this.size];
    for(int i = 0; i<this.size; i++) {
      list[i] = arr[i];
    }
    return list;
  }

  public void add(E value) {
    if(this.size == arr.length)
      increase();

    arr[size++] = value;
  }

  public int insert(int index, E value) {
    if(index < 0 || index >= this.size) {
      return -1;
    }
    if(this.size == arr.length)
      increase();

    for(int i = size -1; i >= index; i--) {
      arr[i] = arr[i+1];
    }
    arr[index] = value;
    size++;

    return 0;
  }

  @SuppressWarnings("unchecked")
  public E get (int index) {
    if(index < 0 || index >= this.size) {
      return null;
    }

    return (E)arr[index];

  }

  @SuppressWarnings("unchecked")
  public E set(int index, E value) {
    if(index < 0 || index >= this.size) {
      return null;
    }
    E obj = (E)arr[index];

    arr[index] = value;

    return  obj;
  }

  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if(index < 0 || index >= this.size) {
      return null;
    }

    E old = (E) arr[index];

    for(int i = index; i < size - 1; i++){
      this.arr[i] = this.arr[i + 1];
    }
    size--;
    return old;
  } 



  public int size() {
    return this.size;
  }

  private void increase() { 
    int oldSize = arr.length;
    int newSize = oldSize + (oldSize >> 1);
    Object[] temp = new Object[newSize];
    for(int i = 0; i < arr.length; i++ ) {
      temp[i] = arr[i];
    }
    arr = temp;
  }

  // 자신이 보유한 데이터를 꺼내주는 일을 하는 객체를 알려주는 메서드
  public Iterator<E> iterator() {

    return new Iterator<E>() {

      int index = 0;

      @Override
      public boolean hasNext() {
        return index < size();
      }

      @Override
      public E next() {
        return (E) get(index++);
      }
    };
  }
}
