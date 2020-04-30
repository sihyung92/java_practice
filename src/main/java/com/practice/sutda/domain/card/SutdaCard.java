package com.practice.sutda.domain.card;

import java.util.stream.Stream;

public enum SutdaCard {
    FINE(1, "1월", false),
    CRANE(1, "1광", true),
    PLUM(2, "2월", false),
    WHISTLING_BIRD(2, "2월", false),
    CHERRY_BLOSSOM(3, "3광", true),
    MEMBRANE(3, "3월", false),
    RATTAN(4, "4월", false),
    BIRD(4, "4월", false),
    CALAMUS(5, "5월", false),
    CALAMUS_MEMBRANE(5, "5월", false),
    PEONY(6, "5월", false),
    BUTTERFLY(6, "5월", false),
    SEVEN_ONE(7, "7월", false),
    SEVEN_TWO(7, "7월", false),
    EIGHT(8, "8월", false),
    EIGHT_TWO(8, "8광", true),
    NINE_ONE(9, "9월", false),
    NINE_TWO(9, "9월", false),
    TEN_ONE(10, "10월", false),
    TEN_TWO(10, "10월", false);

    private static final SutdaCard[] SUTDA_CARD_NUMBERS = SutdaCard.values();
    private static final String ERROR_MESSAGE_OUT_OF_NUMBER = "올바르지 않은 숫자입니다.";
    private static final int MIN_SUTDA_NUMBER = 1;
    private static final int MAX_SUTDA_NUMBER = 10;

    private final int monthNumber;
    private final String name;
    private final boolean kwang;

    SutdaCard(int monthNumber, String name, boolean kwang) {
        this.monthNumber = monthNumber;
        this.name = name;
        this.kwang = kwang;
    }

    public static SutdaCard of(int number) {
        if (number < MIN_SUTDA_NUMBER || MAX_SUTDA_NUMBER < number) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_NUMBER);
        }
        return Stream.of(SUTDA_CARD_NUMBERS)
                .filter(x -> x.monthNumber == number)
                .findFirst()
                .get();
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public boolean isKwang() {
        return kwang;
    }

}
