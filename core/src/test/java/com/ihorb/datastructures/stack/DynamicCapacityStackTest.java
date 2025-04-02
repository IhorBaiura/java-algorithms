package com.ihorb.datastructures.stack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DynamicCapacityStack Tests")
public class DynamicCapacityStackTest {

  @Test
  @DisplayName("Test: New dynamic stack is empty (pop throws exception)")
  void testNewStackIsEmpty() {
    DynamicCapacityStack<String> stack = new DynamicCapacityStack<>();
    RuntimeException exception = assertThrows(RuntimeException.class, () -> stack.pop(),
        "Popping from an empty stack should throw a RuntimeException");
    assertEquals("Stack is empty", exception.getMessage(), "Expected 'Stack is empty' message");
  }

  @Test
  @DisplayName("Test: Push and pop operations maintain LIFO order")
  void testPushAndPop() {
    DynamicCapacityStack<String> stack = new DynamicCapacityStack<>();
    stack.push("first");
    stack.push("second");
    stack.push("third");

    assertEquals("third", stack.pop(), "Pop should return the last pushed element ('third')");
    assertEquals("second", stack.pop(), "Next pop should return the next element ('second')");
    assertEquals("first", stack.pop(), "Next pop should return the first pushed element ('first')");

    assertThrows(RuntimeException.class, () -> stack.pop(), "Popping an empty stack should throw an exception");
  }

  @Test
  @DisplayName("Test: Dynamic resizing during push/pop operations")
  void testDynamicResizing() {
    DynamicCapacityStack<Integer> stack = new DynamicCapacityStack<>();
    int numElements = 100;

    for (int i = 0; i < numElements; i++) {
      stack.push(i);
    }

    for (int i = numElements - 1; i >= 0; i--) {
      assertEquals(i, stack.pop(), "Popped element should be " + i);
    }

    assertThrows(RuntimeException.class, () -> stack.pop(), "Popping an empty stack should throw an exception");
  }

  @Test
  @DisplayName("Test: Iterator returns elements in LIFO order")
  void testIterator() {
    DynamicCapacityStack<String> stack = new DynamicCapacityStack<>();
    stack.push("first");
    stack.push("second");
    stack.push("third");

    Iterator<String> iterator = stack.iterator();
    assertTrue(iterator.hasNext(), "Iterator should have a next element");
    assertEquals("third", iterator.next(), "First iterator element should be 'third'");
    assertEquals("second", iterator.next(), "Second iterator element should be 'second'");
    assertEquals("first", iterator.next(), "Third iterator element should be 'first'");
    assertFalse(iterator.hasNext(), "Iterator should have no more elements");
  }

  @Test
  @DisplayName("Test: Iterator throws NoSuchElementException when exhausted")
  void testIteratorThrowsException() {
    DynamicCapacityStack<String> stack = new DynamicCapacityStack<>();
    stack.push("only");
    Iterator<String> iterator = stack.iterator();
    assertEquals("only", iterator.next(), "Iterator should return the only element");

    assertThrows(NoSuchElementException.class, () -> iterator.next(),
        "Iterator should throw NoSuchElementException when no more elements are available");
  }

  @Test
  @DisplayName("Test: For-each loop iterates in LIFO order")
  void testForEachIterator() {
    DynamicCapacityStack<String> stack = new DynamicCapacityStack<>();

    stack.push("one");
    stack.push("two");
    stack.push("three");

    StringBuilder result = new StringBuilder();
    for (String item : stack) {
      result.append(item).append(' ');
    }

    String iteratedOrder = result.toString().trim();
    assertEquals("three two one", iteratedOrder, "For-each loop should iterate over the elements in LIFO order");
  }
}
