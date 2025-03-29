package com.ihorb.datastructures.stack;

public class Stack<Item> {
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
}
