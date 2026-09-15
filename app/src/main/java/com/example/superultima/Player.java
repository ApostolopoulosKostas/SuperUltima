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


    public CardInfo getTopCard() {
        return cards.get(0);
    }

    //after a round,
    // we can take each player's played card and eventually give those cards to the winner
    public CardInfo removeTopCard() {
        return cards.remove(0);
    }
    //puts a card at the bottom of players pile
    public void addCardToBottom(CardInfo card) {
        cards.add(card);



    }
    public int countQuartets() {

        int quartets = 0;

        for (char letter = 'A'; letter <= 'Z'; letter++) {

            int count = 0;

            for (CardInfo card : cards) {

                if (card.letter == letter) {
                    count++;
                }
            }

            if (count == 4) {
                quartets++;
            }
        }

        return quartets;
    }

}
