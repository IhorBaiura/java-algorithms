package com.ihorb.datastructures.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicCapacityStack<Item> implements Iterable<Item> {
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

  @Override
  public Iterator<Item> iterator() {
    return new RallbackStackIterator();
  }

  private class RallbackStackIterator implements Iterator<Item> {
    private int i = N;

    @Override
    public boolean hasNext() {
      return i > 0;
    }

    @Override
    public Item next() {
      if (i == 0) {
        throw new NoSuchElementException("Stack is empty");
      }

      return stack[--i];
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

  }
}
