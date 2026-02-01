package com.argentrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgentRoseStoreTest {

    @Test
    @DisplayName("Canary test do not keep me")
    public void canary_test_do_not_keep_me() {
        assertThat(true).isEqualTo(true);
    }

}
