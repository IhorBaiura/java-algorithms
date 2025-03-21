package com.ihorb.datastructures.stack;

public class DynamicCapacityStack<Item> {
  private Item[] stack;
  private int N = 0;

  @SuppressWarnings("unchecked")
  public DynamicCapacityStack() {
    stack = (Item[]) new Object[1];
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

    Item item = stack[--N];
    stack[N] = null;

    if (N > 0 && N == stack.length / 4) {
      resize(stack.length / 2);
    }

    return item;
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
