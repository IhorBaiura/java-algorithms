package com.ihorb.datastructures.stack;

public class FixedCapacityStack<Item> {
  private Item[] stack;
  private int size = 0;
  private int capacity = 0;

  @SuppressWarnings("unchecked")
  public FixedCapacityStack(int capacity) {
    stack = (Item[]) new Object[capacity];
    this.capacity = capacity;
  }

  public void push(Item item) {
    if (isFull()) {
      throw new RuntimeException("Stack is full");
    }

    stack[size++] = item;
  }

  public Item pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty");
    }

    return stack[--size];
  }

  public boolean isFull() {
    return size == capacity;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }
}
