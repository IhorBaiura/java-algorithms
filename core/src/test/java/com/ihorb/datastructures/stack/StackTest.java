package com.ihorb.datastructures.stack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("StackTest Tests")
public class StackTest {

  @Test
  @DisplayName("Test: New stack is empty")
  void testNewStackIsEmpty() {
    Stack<String> stack = new Stack<>();
    assertTrue(stack.isEmpty(), "A new stack should be empty");
    assertEquals(0, stack.size(), "Size of a new stack should be 0");
  }

  @Test
  @DisplayName("Test: Push and pop operations work in LIFO order")
  void testPushAndPop() {
    Stack<String> stack = new Stack<>();

    stack.push("first");

    assertFalse(stack.isEmpty(), "Stack should be not empty after pushing an item");

    stack.push("second");
    stack.push("third");

    assertEquals(3, stack.size(), "Stack size should be 3 after three pushes");
    assertEquals("third", stack.pop(), "Pop should return the last pushed element");
    assertEquals("second", stack.pop(), "Next pop should return the second pushed element");
    assertEquals("first", stack.pop(), "Next pop should return the first pushed element");
    assertTrue(stack.isEmpty(), "Stack should be empty after popping all items");
  }

  @Test
  @DisplayName("Test: Peek item with saving structure")
  void testPeek() {
    Stack<String> stack = new Stack<>();

    stack.push("first");

    assertFalse(stack.isEmpty(), "Stack should be not empty after pushing an item");
    assertEquals("first", stack.peek(),
        "Should return the most recently inserted item on the stack (without popping it).");
    assertEquals(1, stack.size(), "Stack size should be 1 after peek method");
  }

  @Test
  @DisplayName("Test: Popping from an empty stack throws exception")
  void testPopOnEmptyStackThrowsException() {
    Stack<Integer> stack = new Stack<>();
    RuntimeException exception = assertThrows(RuntimeException.class, () -> stack.pop(),
        "Popping from an empty stack should throw a RuntimeException");
    assertEquals("Stack is empty", exception.getMessage(), "Exception message should be 'Stack is empty'");
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
    Stack<String> stack = new Stack<>();
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
    Stack<String> stack = new Stack<>();
    stack.push("only");
    Iterator<String> iterator = stack.iterator();
    assertEquals("only", iterator.next(), "Iterator should return the only element");

    assertThrows(NoSuchElementException.class, () -> iterator.next(),
        "Iterator should throw NoSuchElementException when no more elements are available");
  }

  @Test
  @DisplayName("Test: For-each loop iterates in LIFO order")
  void testForEachIterator() {
    Stack<String> stack = new Stack<>();

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
