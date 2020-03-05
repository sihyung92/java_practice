package com.practice.sutda.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    @DisplayName("2장을 만드는지")
    @Test
    public void playerCardNumberTest() {
        Player player = new Player();
        player.spendTurn();
        assertThat(player.size()).isEqualTo(2);
    }

}
