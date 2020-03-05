package com.practice.sutda.card;

public class Kwang {
    private boolean kwang;

    public Kwang(SutdaCard firstSutdaCard, SutdaCard secondSutdaCard) {
        if (firstSutdaCard == secondSutdaCard) {
            kwang = true;
        }
    }

    public boolean isKwang() {
        return kwang;
    }

}