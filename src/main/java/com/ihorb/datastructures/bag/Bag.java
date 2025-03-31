package com.ihorb.datastructures.bag;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
  private Node top = null;
  private int count = 0;

  private class Node {
    Item value;
    Node next;
  }

  public void add(Item value) {
    Node oldTop = top;
    top = new Node();
    top.value = value;
    top.next = oldTop;
    count++;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public int count() {
    return count;
  }

  @Override
  public Iterator<Item> iterator() {
    return new BagIterator();
  }

  private class BagIterator implements Iterator<Item> {
    Node current = top;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Item next() {
      Item value = current.value;
      current = current.next;
      return value;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
  }
}
