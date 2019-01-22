package algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList {
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
  
  public void add(Object value) {
    if(this.size == arr.length)
      increase();
    
    arr[size++] = value;
  }

  public int insert(int index, Object value) {
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

  public Object get (int index) {
   if(index < 0 || index >= this.size) {
     return null;
   }
   
   return arr[index];
   
  }

  public Object set(int index, Object value) {
    if(index < 0 || index >= this.size) {
      return null;
    }
    Object obj = arr[index];
    
    arr[index] = value;
    
    return  obj;
  }

  public Object remove(int index) {
    if(index < 0 || index >= this.size) {
      return null;
    }
    
    Object old = arr[index];
    
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
}
