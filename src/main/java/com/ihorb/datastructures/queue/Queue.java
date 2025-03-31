package com.ihorb.datastructures.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
  private Node first = null;
  private Node last = null;
  private int count = 0;

  public void enqueue(Item value) {
    Node oldLast = last;
    last = new Node();
    last.value = value;
    last.next = null;
    if (isEmpty())
      first = last;
    else
      oldLast.next = last;
    count++;
  }

  public Item dequeue() {
    if (first == null)
      throw new RuntimeException("Stack is empty");
    Item value = first.value;
    first = first.next;
    count--;
    if (isEmpty())
      last = null;
    return value;
  }

  public boolean isEmpty() {
    return count == 0;
  }

  public int lenght() {
    return count;
  }

  private class Node {
    Item value;
    Node next;
  }

  @Override
  public Iterator<Item> iterator() {
    return new QueueIterator();
  }

  private class QueueIterator implements Iterator<Item> {
    Node current = first;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Item next() {
      if (current == null) {
        throw new NoSuchElementException("Stack is empty");
      }
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
