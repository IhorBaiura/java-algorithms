package com.ihorb.datastructures.stack;

public class DynamicCapacityStack<Item> {
  private static final int SIZE = 15;
  private Item[] stack;
  private int N = 0;

  @SuppressWarnings("unchecked")
  public DynamicCapacityStack() {
    stack = (Item[]) new Object[SIZE];
  }

  public void push(Item item) {
    if (isFull())
      resize(2 * stack.length);
    stack[N++] = item;
  }

  public Item pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty");
    }

    return stack[--N];
  }

  private boolean isFull() {
    return N == stack.length;
  }

  private boolean isEmpty() {
    return N == 0;
  }

  private void resize(int newSize) {
    @SuppressWarnings("unchecked")
    Item[] newStack = (Item[]) new Object[newSize];

    for (int i = 0; i < N; i++) {
      newStack[i] = stack[i];
    }

    stack = newStack;
  }
}
