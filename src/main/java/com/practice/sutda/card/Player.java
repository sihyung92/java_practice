package com.practice.sutda.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    public static final int BOUND = 12;
    public static final String MESSAGE_ERROR_ROW_CARD = "카드 숫자가 모자랍니다";
    public static final int CARD_SIZE = 2;

    private List<Card> cards = new ArrayList<>();
    private Kwang kwang;
    static Random random = new Random();

    public void spendTurn() {
        drawCard();
        validateCard();
        createKwang();
    }

    private void drawCard() {
        if (cards.size() < CARD_SIZE) {
            cards.add(Card.of(createRandomNumberExclusiveZero(BOUND)));
            drawCard();
        }
    }

    private void validateCard() {
        if (cards.size() > CARD_SIZE + 1) {
            throw new IllegalArgumentException(MESSAGE_ERROR_ROW_CARD);
        }
    }

    private void createKwang() {
        kwang = new Kwang(cards.get(0), cards.get(1));
    }


    public boolean isKwang() {
        return kwang.isKwang();
    }

    public int size() {
        return cards.size();
    }

    private int createRandomNumberExclusiveZero(int bound) {
        return random.nextInt(bound) + 1;
    }
}
