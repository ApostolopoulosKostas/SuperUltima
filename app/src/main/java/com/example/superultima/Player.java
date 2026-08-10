package com.example.superultima;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private final List<Airplane> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Airplane> getCards() {
        return cards;
    }

    public void addCard(Airplane card) {
        cards.add(card);
    }
}



