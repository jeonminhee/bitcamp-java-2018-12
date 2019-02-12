package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> {

  static final int LENGTH = 3;
  Object[] list;
  int size = 0;

  public ArrayList() {
    list = new Object[LENGTH];
  }

  @SuppressWarnings("unchecked")
  public E[] toArrays(E[] sampleArr) {
    return (E[]) Arrays.copyOf(list, size, sampleArr.getClass());
  }

  public void add(E obj) {
    if(size == list.length) {
      list = Arrays.copyOf(list, list.length + (list.length >> 1));
      System.out.println("저장공간을 늘렸습니다.");
    }
    list[size++] = obj;

  }

  @SuppressWarnings("unchecked")
  public E  get(int index) {
    if (index < 0  || index >= size) 
      return null;

    return (E) this.list[index];
  }

  public E  set(int index, E value) {
    if(index < 0 || index >= size) {
      return null;
    }
    E old = (E) list[index];
    list[index] = value;

    return  old;
  }
  
  public E  remove (int index) {
    if (index < 0  || index >= size) 
      return null;

    E obj = (E) list[index];

    for(int i = index; i < size - 1; i++ )
      list[i] = list[i + 1];

    size--;

    return obj;
  }

  public int size() {
    return this.size;
  }
}


