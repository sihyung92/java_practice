package com.practice.sutda.card;

public enum Card {
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

    private static final Card[] cardNumbers = Card.values();
    private static final String ERROR_MESSAGE_OUT_OF_NUMBER = "올바르지 않은 숫자입니다.";
    private final int number;
    private final String name;

    Card(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public static Card of(int number) {
        if (number < 1 || 12 < number) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_NUMBER);
        }
        return cardNumbers[number - 1];
    }

    public int getNumber() {
        return number;
    }
}
