package com.example.superultima.cardgame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    private int playerCount;
    private int currentPlayerTurn = 0;
    private List<List<CardInfo>> playerDecks;

    public Game(
            int playerCount,
            List<CardInfo> fullDeck) {

        this.playerCount = playerCount;
        this.playerDecks = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {
            playerDecks.add(new ArrayList<>());
        }

        List<CardInfo> shuffledDeck =
                new ArrayList<>(fullDeck);

        Collections.shuffle(shuffledDeck);

        for (int i = 0; i < shuffledDeck.size(); i++) {

            playerDecks
                    .get(i % playerCount)
                    .add(shuffledDeck.get(i));
        }
    }

    public int getCurrentPlayerTurn() {
        return currentPlayerTurn;
    }

    // The card belonging to a specific player.
    public CardInfo getPlayerCard(int playerId) {

        if (playerId < 0 ||
                playerId >= playerDecks.size()) {
            return null;
        }

        List<CardInfo> playerDeck =
                playerDecks.get(playerId);

        if (playerDeck.isEmpty()) {
            return null;
        }

        return playerDeck.get(0);
    }

    // The card of the player whose turn it is.
    public CardInfo getCurrentCard() {

        return getPlayerCard(currentPlayerTurn);
    }

    public CardInfo.Statistic getCurrentStatistic(
            int position) {

        CardInfo card =
                getCurrentCard();

        if (card != null
                && position >= 0
                && position < card.statistics.length) {

            return card.statistics[position];
        }

        return null;
    }

    public int playRound(int statIndex) {

        int roundWinner =
                currentPlayerTurn;

        double highestValue =
                Double.NEGATIVE_INFINITY;

        List<CardInfo> roundCards =
                new ArrayList<>();

        for (int i = 0;
             i < playerCount;
             i++) {

            List<CardInfo> playerDeck =
                    playerDecks.get(i);

            if (!playerDeck.isEmpty()) {

                CardInfo card =
                        playerDeck.remove(0);

                roundCards.add(card);

                CardInfo.Statistic stat =
                        card.statistics[statIndex];

                if (stat != null) {

                    double value =
                            stat.value;

                    if (value > highestValue) {

                        highestValue = value;
                        roundWinner = i;
                    }
                }
            }
        }

        playerDecks
                .get(roundWinner)
                .addAll(roundCards);

        currentPlayerTurn =
                roundWinner;

        return roundWinner;
    }

    public boolean isGameOver() {

        int activePlayers = 0;

        for (List<CardInfo> deck :
                playerDecks) {

            if (!deck.isEmpty()) {
                activePlayers++;
            }
        }

        return activePlayers <= 1;
    }

    public int getWinner() {

        for (int i = 0;
             i < playerCount;
             i++) {

            if (!playerDecks.get(i).isEmpty()) {
                return i;
            }
        }

        return 0;
    }
}