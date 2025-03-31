package com.ihorb.datastructures.queue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Queue Tests")
public class QueueTest {

  @Test
  @DisplayName("Test: New queue is empty and length is zero")
  void testNewQueueIsEmpty() {
    Queue<String> queue = new Queue<>();
    assertTrue(queue.isEmpty(), "A new queue should be empty");
    assertEquals(0, queue.lenght(), "Length of a new queue should be 0");
  }

  @Test
  @DisplayName("Test: Enqueue and Dequeue operations work in FIFO order")
  void testEnqueueDequeue() {
    Queue<String> queue = new Queue<>();
    queue.enqueue("first");
    queue.enqueue("second");
    queue.enqueue("third");

    assertEquals("first", queue.dequeue(), "Dequeue should return the first enqueued element");
    assertEquals("second", queue.dequeue(), "Dequeue should return the second enqueued element");
    assertEquals("third", queue.dequeue(), "Dequeue should return the third enqueued element");
    assertTrue(queue.isEmpty(), "Queue should be empty after all elements are dequeued");
  }

  @Test
  @DisplayName("Test: Length returns the correct number of elements")
  void testLength() {
    Queue<Integer> queue = new Queue<>();
    assertEquals(0, queue.lenght(), "Empty queue should have length 0");
    queue.enqueue(1);
    queue.enqueue(2);
    assertEquals(2, queue.lenght(), "Queue should have length 2 after enqueuing two elements");
  }

  @Test
  @DisplayName("Test: Iterator iterates over all elements in FIFO order")
  void testIterator() {
    Queue<String> queue = new Queue<>();
    queue.enqueue("first string");
    queue.enqueue("second string");
    queue.enqueue("third string");

    List<String> iteratedElements = new ArrayList<>();
    for (String item : queue) {
      iteratedElements.add(item);
    }

    List<String> expected = Arrays.asList("first string", "second string", "third string");
    assertEquals(expected, iteratedElements, "Iterator should return all elements in FIFO order");
  }

  @Test
  @DisplayName("Test: Iterator's next() throws NoSuchElementException when no more elements")
  void testIteratorNoSuchElementException() {
    Queue<String> queue = new Queue<>();
    queue.enqueue("only value");
    Iterator<String> it = queue.iterator();
    assertEquals("only value", it.next(), "Iterator should return the only element");
    assertThrows(NoSuchElementException.class, () -> it.next(),
        "Iterator should throw NoSuchElementException when no more elements are available");
  }
}
