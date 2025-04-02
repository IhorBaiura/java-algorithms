package com.ihorb.datastructures.stack;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("FixedCapacityStack Tests")
public class FixedCapacityStackTest {

  @Test
  @DisplayName("Test: New stack is empty")
  void testNewStackIsEmpty() {
    FixedCapacityStack<String> stack = new FixedCapacityStack<>(10);
    assertTrue(stack.isEmpty(), "A new stack should be empty");
    assertEquals(0, stack.size(), "Size of a new stack should be 0");
  }

  @Test
  @DisplayName("Test: Push and pop operations work in LIFO order")
  void testPushAndPop() {
    FixedCapacityStack<String> stack = new FixedCapacityStack<>(10);

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
    FixedCapacityStack<Integer> stack = new FixedCapacityStack<>(5);
    RuntimeException exception = assertThrows(RuntimeException.class, () -> stack.pop(),
        "Popping from an empty stack should throw a RuntimeException");
    assertEquals("Stack is empty", exception.getMessage(), "Exception message should be 'Stack is empty'");
  }

  @Test
  @DisplayName("Test: Pushing over capacity throws exception")
  void testPushOverCapacityThrowsException() {
    FixedCapacityStack<Integer> stack = new FixedCapacityStack<>(2);
    stack.push(1);
    stack.push(2);
    RuntimeException exception = assertThrows(RuntimeException.class, () -> stack.push(3),
        "Pushing over capacity should throw a RuntimeException");
    assertEquals("Stack is full", exception.getMessage(), "Exception message should be 'Stack is full'");
  }
}
