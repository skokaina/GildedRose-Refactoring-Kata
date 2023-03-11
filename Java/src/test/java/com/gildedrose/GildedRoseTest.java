package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

  /**
   * Test if quality of normal item decreases by 2 after sellIn date has passed
   */
  @Test
  public void normalItemQualityDecreasesByTwoAfterSellInDate() {
    Item[] items = new Item[] {new Item("Normal Item", 0, 10)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(8, app.items[0].quality);
  }

  /**
   * Test if quality of normal item decreases by 1 after 1 day
   */
  @Test
  public void normalItemQualityDecreasesByOne() {
    Item[] items = new Item[] {new Item("+5 Dexterity Vest", 10, 20)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(19, app.items[0].quality);
  }

  /**
   * Test if quality of Aged Brie increases by 2 after sellIn date has passed
   */
  @Test
  public void agedBrieQualityIncreasesByTwoAfterSellInDate() {
    Item[] items = new Item[] {new Item("Aged Brie", 0, 10)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(12, app.items[0].quality);
  }

  /**
   * Test if quality of Aged Brie increases by 1 after 1 day
   */
  @Test
  public void agedBrieQualityIncreasesByOne() {
    Item[] items = new Item[] {new Item("Aged Brie", 10, 10)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(11, app.items[0].quality);
  }

  /**
   * Test if quality of Backstage passes increases by 1 when sellIn is greater than 10
   */
  @Test
  public void backstagePassesQualityIncreasesByOneWhenSellInGreaterThanTen() {
    Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(11, app.items[0].quality);
  }

  /**
   * Test if quality of Backstage passes increases by 2 when sellIn is between 6 and 10
   */
  @Test
  public void backstagePassesQualityIncreasesByTwoWhenSellInBetweenSixAndTen() {
    Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(22, app.items[0].quality);
  }
}
