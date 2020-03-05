package com.practice.sutda.card;

import java.util.*;

public class SutdaDeck {
    private static final int DEFAULT_NUMBER_OF_CARD_BUNDLE = 2;
    private List<SutdaCard> sutdaCardList;

    public SutdaDeck() {
        this(DEFAULT_NUMBER_OF_CARD_BUNDLE);
    }

    public SutdaDeck(int numberOfCardDecks) {
        List<SutdaCard> cardBundle = Arrays.asList(SutdaCard.values());
        sutdaCardList = new ArrayList<>();
        for (int i = 0; i < numberOfCardDecks; i++) {
            sutdaCardList.addAll(cardBundle);
        }
    }

    public List<SutdaCard> getSutdaCardList() {
        return Collections.unmodifiableList(sutdaCardList);
    }

    public SutdaDeck shuffle() {
        Collections.shuffle(sutdaCardList);
        return this;
    }

    public SutdaCard pickRandom() {
        Random random = new Random();
        return sutdaCardList.get(random.nextInt(sutdaCardList.size()));
    }

    public SutdaCard pick(int index) {
        return sutdaCardList.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SutdaDeck that = (SutdaDeck) o;
        return Objects.equals(sutdaCardList, that.sutdaCardList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sutdaCardList);
    }

}
