package com.practice.sutda.user;

import com.practice.sutda.card.SutdaCard;
import com.practice.sutda.card.Ddeng;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    public static final int BOUND = 12;
    public static final String MESSAGE_ERROR_ROW_CARD = "카드 숫자가 모자랍니다";
    public static final int CARD_SIZE = 2;

    private List<SutdaCard> sutdaCards = new ArrayList<>();
    private Ddeng ddeng;
    static Random random = new Random();

    public void spendTurn() {
        drawCard();
        validateCard();
        createKwang();
    }

    private void drawCard() {
        if (sutdaCards.size() < CARD_SIZE) {
            sutdaCards.add(SutdaCard.of(createRandomNumberExclusiveZero(BOUND)));
            drawCard();
        }
    }

    private void validateCard() {
        if (sutdaCards.size() > CARD_SIZE + 1) {
            throw new IllegalArgumentException(MESSAGE_ERROR_ROW_CARD);
        }
    }

    private void createKwang() {
        ddeng = new Ddeng(sutdaCards.get(0), sutdaCards.get(1));
    }


    public boolean getDdeng() {
        return ddeng.isDdeng();
    }

    public int size() {
        return sutdaCards.size();
    }

    private int createRandomNumberExclusiveZero(int bound) {
        return random.nextInt(bound) + 1;
    }
}
