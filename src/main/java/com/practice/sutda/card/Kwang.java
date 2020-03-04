package com.practice.sutda.card;

public class Kwang {
    private boolean kwang;

    public Kwang(Card firstCard, Card secondCard) {
        if (firstCard == secondCard) {
            kwang = true;
        }
    }

    public boolean isKwang() {
        return kwang;
    }

}