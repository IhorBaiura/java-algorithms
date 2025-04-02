package com.ihorb.datastructures.stack;

public class FixedCapacityStackOfStrings {
  private String[] a;
  private int N = 0;
  private int C = 0;

  public FixedCapacityStackOfStrings(int capacity) {
    a = new String[capacity];
    C = capacity;
  }

  public void push(String s) {
    if (isFull()) {
      throw new RuntimeException("Stack is full");
    }
    a[N++] = s;
  }

  public String pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty");
    }
    return a[--N];
  }

  public boolean isFull() {
    return N == C;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }
}
