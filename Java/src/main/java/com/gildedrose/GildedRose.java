package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (isNormalItem(item)) {
            decreaseQuality(item);
        } else if (isAgedBrie(item)) {
            increaseQuality(item);
        } else if (isBackstagePasses(item)) {
            increaseQuality(item);
            if (item.sellIn < 11) {
                increaseQuality(item);
            }
            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            if (isNormalItem(item)) {
                decreaseQuality(item);
            } else if (isAgedBrie(item)) {
                increaseQuality(item);
            } else if (isBackstagePasses(item)) {
                item.quality = MIN_QUALITY;
            }
        }
    }

    private boolean isNormalItem(Item item) {
        return !isAgedBrie(item) && !isBackstagePasses(item) && !isSulfuras(item);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS);
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY && !isSulfuras(item)) {
            item.quality--;
        }
    }

    private void decreaseSellIn(Item item) {
        if (!isSulfuras(item)) {
            item.sellIn--;
        }
    }
}
