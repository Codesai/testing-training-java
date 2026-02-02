package com.argentrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgentRoseStoreTest {

    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;

    @Test
    @DisplayName("Theatre Passes quality drops to 0 when expired")
    void theatre_passes_quality_drops_to_0_expired() {
        ArgentRoseStore store = argentRoseStoreWith(theatrePasses(-1, 38));

        store.update();

        assertThat(store).isEqualTo(argentRoseStoreWith(theatrePasses(-2, MIN_QUALITY)));
    }

    @Test
    @DisplayName("Theatre Passes increases quality by 1 when sell-in is greater than 6 days")
    void theatre_passes_quality_increases_by_one_when_sellIn_greater_than_six() {
        ArgentRoseStore store = argentRoseStoreWith(theatrePasses(30, 5));

        store.update();

        assertThat(store).isEqualTo(argentRoseStoreWith(theatrePasses(29, 6)));
    }

    @Test
    @DisplayName("Theatre Passes's quality can't grow over 50 when sell-in is greater than 6 days")
    void theatre_passes_quality_cant_grow_over_50_when_sell_in_is_greater_than_6_days() {
        ArgentRoseStore store = argentRoseStoreWith(theatrePasses(20, MAX_QUALITY));

        store.update();

        assertThat(store).isEqualTo(argentRoseStoreWith(theatrePasses(19, MAX_QUALITY)));
    }

    private Product theatrePasses(int sellIn, int quality) {
        return new Product("Theatre Passes", sellIn, quality);
    }

    private Product regularProduct(int sellIn, int quality) {
        return new Product("any not special product", sellIn, quality);
    }

    private ArgentRoseStore argentRoseStoreWith(Product... products) {
        return new ArgentRoseStore(Arrays.asList(products));
    }
}
