package com.example.superultima;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<CardInfo> cards = new ArrayList<>();

    public void addCard(CardInfo card) {
        cards.add(card);
    }

    public CardInfo removeCard(int index) {
        return cards.remove(index);
    }

    public List<CardInfo> getCards() {
        return cards;
    }

    public int getCardCount() {
        return cards.size();
    }
}