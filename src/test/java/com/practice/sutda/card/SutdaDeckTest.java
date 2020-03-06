package com.practice.sutda.card;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SutdaDeckTest {

    @DisplayName("지정한 카드 덱 수로 만들어지는지")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void makeDecksByArgNumTest(int numberOfCardDecks) {
        //given
        SutdaDeck sutdaDeck;
        int numberOfEachCard = numberOfCardDecks * 2;

        //when
        sutdaDeck = new SutdaDeck(numberOfCardDecks);

        //then
        assertThat(
                (int) sutdaDeck.getSutdaCardList()
                        .stream()
                        .filter(x -> x.getMonthNumber() == 1)
                        .count()
        ).isEqualTo(numberOfEachCard);
    }

    @DisplayName("셔플 테스트")
    @Test
    void shuffleTest() {
        //given
        SutdaDeck sutdaDeck = new SutdaDeck();

        //when
        List<SutdaCard> beforeSutdaCards = new ArrayList();
        beforeSutdaCards.addAll(sutdaDeck.getSutdaCardList());
        sutdaDeck.shuffle();
        List<SutdaCard> afterSutdaCards = sutdaDeck.getSutdaCardList();

        //then
        assertThat(beforeSutdaCards)
                .as("섯다 덱 카드의 순서가 바뀌었는가?")
                .isNotEqualTo(afterSutdaCards);
    }

    @DisplayName("카드 한장 골라오기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:1", "2:2", "3:2"}, delimiter = ':')
    void pickTest(int index, int result) {
        //given
        SutdaDeck sutdaDeck = new SutdaDeck();

        //when
        SutdaCard sutdaCard = sutdaDeck.pick(index);

        //then
        assertThat(sutdaCard.getMonthNumber())
                .as("인덱스로 잘 골라오는지")
                .isEqualTo(result);
    }
}
