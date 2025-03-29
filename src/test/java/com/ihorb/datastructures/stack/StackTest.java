package com.ihorb.datastructures.stack;

import static org.junit.jupiter.api.Assertions.*;
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
  @DisplayName("Test: Popping from an empty stack throws exception")
  void testPopOnEmptyStackThrowsException() {
    Stack<Integer> stack = new Stack<>();
    RuntimeException exception = assertThrows(RuntimeException.class, () -> stack.pop(),
        "Popping from an empty stack should throw a RuntimeException");
    assertEquals("Stack is empty", exception.getMessage(), "Exception message should be 'Stack is empty'");
  }
}
