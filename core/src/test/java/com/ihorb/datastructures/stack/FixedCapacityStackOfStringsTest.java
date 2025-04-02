package com.ihorb.datastructures.stack;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("FixedCapacityStackOfStrings Tests")
public class FixedCapacityStackOfStringsTest {

  private FixedCapacityStackOfStrings stack;

  @BeforeEach
  void setUp() {
    stack = new FixedCapacityStackOfStrings(5);
  }

  @Test
  @DisplayName("New stack should be empty")
  public void testNewStackIsEmpty() {
    assertTrue(stack.isEmpty(), "Stack should be empty initially");
    assertEquals(0, stack.size(), "Size should be 0");
  }

  @Test
  @DisplayName("Push and Pop operations")
  public void testPushPopOperations() {
    stack.push("first");
    stack.push("second");

    assertFalse(stack.isEmpty(), "Stack should not be empty after pushes");
    assertEquals(2, stack.size(), "Size should be 2");
    assertEquals("second", stack.pop(), "Popped value should be 'second'");
    assertEquals("first", stack.pop(), "Popped value should be 'first'");
    assertTrue(stack.isEmpty(), "Stack should be empty after popping all items");
  }

  @Test
  @DisplayName("Multiple push and pop operations")
  public void testMultiplePushAndPop() {
    stack.push("A");
    stack.push("B");
    stack.push("C");

    assertEquals(3, stack.size(), "Size should be 3");
    assertEquals("C", stack.pop(), "Popped element should be 'C'");
    assertEquals("B", stack.pop(), "Popped element should be 'B'");
    assertEquals(1, stack.size(), "Size should be 1 after two pops");

    stack.push("D");

    assertEquals(2, stack.size(), "Size should be 2");
    assertEquals("D", stack.pop(), "Popped element should be 'D'");
    assertEquals("A", stack.pop(), "Popped element should be 'A'");
  }

  @Test
  @DisplayName("Pop from empty stack throws exception")
  void testPopFromEmptyStackThrowsException() {
    assertThrows(RuntimeException.class, () -> stack.pop());
  }

  @Test
  @DisplayName("Push over capacity")
  void testPushOverCapacityThrowsException() {
    FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(2);

    stack.push("one");
    stack.push("two");

    RuntimeException exception = assertThrows(RuntimeException.class, () -> stack.push("three"));
    assertEquals("Stack is full", exception.getMessage());
  }

  @Test
  @DisplayName("Size of stack")
  void testSize() {
    stack.push("one");
    assertEquals(1, stack.size(), "Size should be 1");
  }
}
