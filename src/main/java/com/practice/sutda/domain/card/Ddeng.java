package com.practice.sutda.domain.card;

public class Ddeng {
    private boolean ddeng;

    public Ddeng(SutdaCard firstSutdaCard, SutdaCard secondSutdaCard) {
        if (firstSutdaCard == secondSutdaCard) {
            ddeng = true;
        }
    }

    public boolean isDdeng() {
        return ddeng;
    }

}