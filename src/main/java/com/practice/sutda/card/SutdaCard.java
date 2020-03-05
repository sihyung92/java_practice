package com.practice.sutda.card;

public enum SutdaCard {
    ONE(1, "1월"),
    TWO(2, "2월"),
    THREE(3, "3월"),
    FOUR(4, "4월"),
    FIVE(5, "5월"),
    SIX(6, "6월"),
    SEVEN(7, "7월"),
    EIGHT(8, "8월"),
    NINE(9, "9월"),
    TEN(10, "10월"),
    ELEVEN(11, "11월"),
    TWELVE(12, "12월");

    private static final SutdaCard[] SUTDA_CARD_NUMBERS = SutdaCard.values();

    private static final String ERROR_MESSAGE_OUT_OF_NUMBER = "올바르지 않은 숫자입니다.";
    private static final int MIN_SUTDA_NUMBER = 1;
    private static final int MAX_SUTDA_NUMBER = 12;

    private final int number;
    private final String name;

    SutdaCard(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public static SutdaCard of(int number) {
        if (number < MIN_SUTDA_NUMBER || MAX_SUTDA_NUMBER < number) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_NUMBER);
        }
        return SUTDA_CARD_NUMBERS[number - 1];
    }

    public int getNumber() {
        return number;
    }
}
