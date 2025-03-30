package com.ihorb.datastructures.queue;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
  Node first = null;
  Node last = null;
  int count = 0;

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

  public Iterator<Item> iterator() {
    return new QueueIterator();
  }

  private class QueueIterator implements Iterator<Item> {
    Node current = first;

    @Override
    public boolean hasNext() {
      return current.next != null;
    }

    @Override
    public Item next() {
      Item value = current.value;
      current = current.next;
      return value;
    }
  }
}
