package com.ihorb.datastructures.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
  private Node linkedList = null;
  private int counter = 0;

  public void push(Item value) {
    Node oldLinkedList = linkedList;

    linkedList = new Node();
    linkedList.value = value;
    linkedList.next = oldLinkedList;

    counter++;
  }

  public Item pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty");
    }

    Item value = linkedList.value;

    linkedList = linkedList.next;
    counter--;

    return value;
  }

  public boolean isEmpty() {
    return counter == 0;
  }

  public int size() {
    return counter;
  }

  private class Node {
    Item value;
    Node next;
  }

  @Override
  public Iterator<Item> iterator() {
    return new StackIterator();
  }

  private class StackIterator implements Iterator<Item> {
    Node current = linkedList;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public void remove() {
    }

    @Override
    public Item next() {
      if (current == null) {
        throw new NoSuchElementException("Stack is empty");
      }

      Item result = current.value;
      current = current.next;
      return result;
    }
  }
}
