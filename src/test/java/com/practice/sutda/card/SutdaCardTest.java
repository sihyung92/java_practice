package com.practice.sutda.card;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SutdaCardTest {
    @DisplayName("카드만들기테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 13})
    public void makeCardTest(int arg) {
        assertThatThrownBy(() -> SutdaCard.of(arg)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("올바르지 않은 숫자입니다.");
    }

    @DisplayName("광이 잘 생성되는지")
    @ParameterizedTest
    @CsvSource(value = {"1,1,true", "2,2,true", "11,11,true", "1,2,false"})
    public void kwangTest(int cardNumber1, int cardNumber2, boolean expectedResult) {
        Kwang kwang = new Kwang(SutdaCard.of(cardNumber1), SutdaCard.of(cardNumber2));
        assertThat(kwang.isKwang()).isEqualTo(expectedResult);
    }
}
