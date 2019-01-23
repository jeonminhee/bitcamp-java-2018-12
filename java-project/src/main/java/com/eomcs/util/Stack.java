package com.eomcs.util;

public class Stack {

  public static final int DEFAULT_SIZE = 5; 
  Object[] list;
  int size;

  public Stack() {
    list = new Object[DEFAULT_SIZE];
  }


  public void push(Object value) {
    // 맨 마지막에 추가한다.
    // 배열의 크기가 작다면 확장해야한다.
    if(size == DEFAULT_SIZE) {
      int oldSize = list.length;
      int newSize = oldSize +(oldSize >> 1);
      Object[] temp = new Object[newSize];
      for(int i = 0; i < list.length; i++) {
        temp[i] = list[i];
      }
      list = temp;
    }

    list[size++] = value;


  }

  public Object pop() {
    // 맨 마지막 값을 꺼내 리턴한다.
    // 꺼낸 값은 배열에서 제거되어야 한다.
   /* Object last = null;
    Object[] arr = new Object[size()];
    for(int i = 0; i < size(); i++ ) {
      arr[i] = list[i];
    }
    list = arr;

    if(list.length > 0) {
    last = list[list.length -1];
    this.size--;
    } else if (list.length == 0) {
    last = null;
    }
    return last;*/
    
    if(size == 0) {
      return null;
    }
    
    size--;
    Object obj = list[size];
    list[size] = null;
    return obj;
  }

  public boolean empty() {

    return size == 0;
  }

  public int size() {
    return this.size;
  }
}
