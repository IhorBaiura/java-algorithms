package com.ihorb.datastructures.bag;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Bag Tests")
public class BagTest {
  @Test
  @DisplayName("Test: New Bag is empty")
  void testNewBagEmpty() {
    Bag<String> bag = new Bag<>();
    assertTrue(bag.isEmpty(), "A new bag should be empty");
    assertEquals(0, bag.count(), "New bag count should be 0");
  }

  @Test
  @DisplayName("Test: Adding an item increases count")
  void testAddItem() {
    Bag<Integer> bag = new Bag<>();
    bag.add(42);
    assertFalse(bag.isEmpty(), "Bag should not be empty after adding an item");
    assertEquals(1, bag.count(), "Bag count should be 1 after adding one item");
  }

  @Test
  @DisplayName("Test: Bag iterator returns all added items in LIFO order")
  void testBagIterator() {
    Bag<String> bag = new Bag<>();
    bag.add("apple");
    bag.add("banana");
    bag.add("cherry");

    // Since the bag adds items to the front,
    // the iterator returns them in reverse order of insertion.
    // Insertion order: "apple", "banana", "cherry"
    // Expected iteration order: "cherry", "banana", "apple"
    List<String> expected = new ArrayList<>();
    expected.add("cherry");
    expected.add("banana");
    expected.add("apple");

    List<String> iterated = new ArrayList<>();
    for (String item : bag) {
      iterated.add(item);
    }
    assertEquals(expected, iterated, "Iterator should return items in LIFO order");
  }

  @Test
  @DisplayName("Test: Iterator remove() method throws UnsupportedOperationException")
  void testIteratorRemoveThrowsException() {
    Bag<String> bag = new Bag<>();
    bag.add("test");
    Iterator<String> iterator = bag.iterator();
    assertThrows(UnsupportedOperationException.class, () -> iterator.remove(),
        "Calling remove() on the iterator should throw UnsupportedOperationException");
  }
}
