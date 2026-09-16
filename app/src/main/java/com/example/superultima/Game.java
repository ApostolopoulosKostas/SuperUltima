package com.example.superultima;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int playerCount;
    private int currentPlayerTurn = 0; // Host starts first (Player 0)
    private List<List<CardInfo>> playerDecks;

    public Game(int playerCount, List<CardInfo> fullDeck) {
        this.playerCount = playerCount;
        this.playerDecks = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {
            playerDecks.add(new ArrayList<>());
        }

        // Deal cards evenly among players
        for (int i = 0; i < fullDeck.size(); i++) {
            playerDecks.get(i % playerCount).add(fullDeck.get(i));
        }
    }

    public int getCurrentPlayerTurn() {
        return currentPlayerTurn;
    }

    public CardInfo getCurrentCard() {
        List<CardInfo> activeDeck = playerDecks.get(currentPlayerTurn);
        if (activeDeck.isEmpty()) return null;
        return activeDeck.get(0);
    }

    public CardInfo.Statistic getCurrentStatistic(int position) {
        CardInfo card = getCurrentCard();
        if (card != null && position < card.statistics.length) {
            return card.statistics[position];
        }
        return null;
    }

    public int playRound(int statIndex) {
        int roundWinner = currentPlayerTurn;
        double highestValue = -1;

        // Collect played cards from each active deck
        List<CardInfo> roundCards = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            List<CardInfo> deck = playerDecks.get(i);
            if (!deck.isEmpty()) {
                CardInfo card = deck.remove(0);
                roundCards.add(card);

                double value = card.statistics[statIndex].value;
                if (value > highestValue) {
                    highestValue = value;
                    roundWinner = i;
                }
            }
        }

        // Award all round cards to winner's deck
        playerDecks.get(roundWinner).addAll(roundCards);

        // Winner gets next turn
        this.currentPlayerTurn = roundWinner;

        return roundWinner;
    }

    public boolean isGameOver() {
        int activePlayers = 0;
        for (List<CardInfo> deck : playerDecks) {
            if (!deck.isEmpty()) activePlayers++;
        }
        return activePlayers <= 1;
    }

    public int getWinner() {
        for (int i = 0; i < playerCount; i++) {
            if (!playerDecks.get(i).isEmpty()) return i;
        }
        return 0;
    }
}