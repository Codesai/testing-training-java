package com.argentrose;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class ArgentRoseStore {

    private final List<Product> inventory;

    public ArgentRoseStore(List<Product> inventory) {
        this.inventory = new ArrayList<>(inventory);
    }

    public void update() {
        for (Product product : inventory) {
            product.decreaseSellIn();

            if (product.isTheatrePasses()) {
                updateTheatrePasses(product, product.getSellIn());
            } else {
                updateRegularProduct(product, product.getSellIn());
            }
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(inventory);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ArgentRoseStore that = (ArgentRoseStore) o;
        return Objects.equals(inventory, that.inventory);
    }

    @Override
    public String toString() {
        return new StringJoiner(", \n",
                                ArgentRoseStore.class.getSimpleName() + "[", "]")
                .add("inventory=" + inventory)
                .toString();
    }

    private void updateTheatrePasses(Product product, int newSellIn) {
        if (newSellIn <= 0) {
            product.dropQualityToZero();
        } else if (newSellIn < 5) {
            product.increaseQuality(3);
        } else {
            product.increaseQuality(1);
        }
    }

    private void updateRegularProduct(Product product, int newSellIn) {
        int changeBeforeExpiry = 2;
        int decrease = (newSellIn < -1) ? changeBeforeExpiry * 2 : changeBeforeExpiry;
        product.decreaseQuality(decrease);
    }
}
