package com.argentrose;

import java.util.Objects;
import java.util.StringJoiner;

public class Product {
    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;
    private final String description;
    private int sellIn;
    private int quality;

    public Product(String description, int sellIn, int quality) {
        this.description = description;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void decreaseSellIn() {
        this.sellIn = this.sellIn - 1;
    }

    public void increaseQuality(int delta) {
        updateQuality(this.quality + delta);
    }

    public void decreaseQuality(int delta) {
        updateQuality(this.quality - delta);
    }

    public boolean isTheatrePasses() {
        return "Theatre Passes".equalsIgnoreCase(description);
    }

    public void dropQualityToZero() {
        updateQuality(MIN_QUALITY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, sellIn, quality);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return sellIn == product.sellIn && quality == product.quality && Objects.equals(description, product.description);
    }

    @Override
    public String toString() {
        return new StringJoiner(", \n", Product.class.getSimpleName() + "[", "]")
                .add("description='" + description + "'")
                .add("sellIn=" + sellIn)
                .add("quality=" + quality)
                .toString();
    }

    private static int enforceQualityInvariant(int newQuality) {
        return Math.max(MIN_QUALITY, Math.min(MAX_QUALITY, newQuality));
    }

    private void updateQuality(int newQuality) {
        this.quality = enforceQualityInvariant(newQuality);
    }
}
