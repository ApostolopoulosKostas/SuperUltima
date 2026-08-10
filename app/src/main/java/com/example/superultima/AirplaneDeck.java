package com.example.superultima;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AirplaneDeck {

    private final List<Airplane> cards = new ArrayList<>();

    public AirplaneDeck() {

        // A1
        cards.add(new Airplane(
                "A1",
                "F-16 Fighting Falcon",
                "FIGHTER+",
                R.drawable.a1,
                2.100,
                4200,
                10.0,
                14.8,
                12000,
                15.240,
                'A',
                1,
                false
        ));

        // A2
        cards.add(new Airplane(
                "A2",
                "Dassault Rafale C",
                "FIGHTER",
                R.drawable.a2,
                2.150,
                3300,
                10.9,
                15.3,
                15000,
                15.253,
                'A',
                2,
                false
        ));
    }

    public List<Airplane> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}



