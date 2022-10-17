package com.gildedrose

private const val AGED_BRIE = "Aged Brie"

private const val SULFURAS = "Sulfuras, Hand of Ragnaros"

private const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item: Item in items) {
            updateItem(item)
        }
    }

    private fun updateItem(item: Item) {
        updateItemQuality(item)

        if (item.name != SULFURAS) {
            item.sellIn = item.sellIn - 1
        }

        if (item.sellIn < 0) {
            if (item.name != AGED_BRIE) {
                if (item.name != BACKSTAGE_PASSES) {
                    if (item.quality > 0) {
                        if (item.name != SULFURAS) {
                            item.quality = item.quality - 1
                        }
                    }
                } else {
                    item.quality = 0
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1
                }
            }
        }
    }

    private fun updateItemQuality(item:Item) {
        if (item.name != AGED_BRIE && item.name != BACKSTAGE_PASSES) {
            if (item.quality > 0) {
                if (item.name != SULFURAS) {
                    item.quality = item.quality - 1
                }
            }
        }  else {
            if (item.quality < 50) {
                item.quality = item.quality + 1

                if (item.name == BACKSTAGE_PASSES) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1
                        }
                    }
                }
            }
        }
    }
}

