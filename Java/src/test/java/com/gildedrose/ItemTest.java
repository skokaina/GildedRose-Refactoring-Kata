package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

  /**
   * Test if the Item object's quality field can be set and retrieved correctly
   */
  @Test
  public void itemQualityField() {
    Item item = new Item("foo", 0, 0);
    assertEquals(0, item.quality);
  }

  /**
   * Test if the toString method returns the correct string representation of the Item object
   */
  @Test
  public void toStringMethod() {
    Item item = new Item("item", 1, 1);
    String result = item.toString();
    assertEquals("item, 1, 1", result);
  }

  /**
   * Test if the Item constructor sets the name, sellIn and quality fields correctly
   */
  @Test
  public void itemConstructor() {
    Item item = new Item("foo", 0, 0);
    assertEquals("foo", item.name);
    assertEquals(0, item.sellIn);
    assertEquals(0, item.quality);
  }

  /**
   * Test if the Item object's name field can be set and retrieved correctly
   */
  @Test
  public void itemNameField() {
    Item item = new Item("foo", 0, 0);
    String name = item.name;
    assertEquals("foo", name);
  }

  /**
   * Test if the Item object's sellIn field can be set and retrieved correctly
   */
  @Test
  public void itemSellInField() {
    Item item = new Item("item", 10, 20);
    int sellIn = item.sellIn;
    assertEquals(10, sellIn);
  }
}