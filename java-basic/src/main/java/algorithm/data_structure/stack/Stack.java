package algorithm.data_structure.stack;

public class Stack {
  
  public static final int DEFAULT_SIZE = 5;
  Object[] list;
  int size;


  public Stack() {
    list = new Object[DEFAULT_SIZE];
    size = 0;
  }


  public void push(Object value) {
    if(size == list.length) {
      Object[] temp = new Object[list.length + (list.length >> 1)];
      for(int i = 0; i < list.length; i++) {
        temp[i] = list[i];
      }
      
      list = temp;
    }
    
    list[size++] = value;
  }

  public Object pop() {

    if(size == 0) {
      return null;
    }
    
    return list[--size];
  }

  public boolean empty() {
    return size == 0;

  }

  public int size() {
    return this.size;
  }
}
