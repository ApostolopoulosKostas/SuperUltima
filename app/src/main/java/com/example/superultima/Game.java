package com.example.superultima;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a game session in SuperUltima.
 * Manages the players participating in the game.
 */
public class Game {
    /** The list of players currently in the game. */
    private final List<Player> players = new ArrayList<>();

    /**
     * Constructs a new Game with a specified number of players.
     *
     * @param numberOfPlayers The number of players to initialize the game with.
     */

    private int currentPlayer;
    public Game(int numberOfPlayers, List<CardInfo> deck) {
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player());
            Collections.shuffle(deck);

            if (players.isEmpty()) {
                return;
            }
            dealCards(deck);

            currentPlayer = (int) (Math.random() * players.size());
        }
    }

    public CardInfo getCurrentCard() {
        return getCurrentPlayer().getTopCard();
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }



    private void dealCards(List<CardInfo> deck) {

        int playerIndex = 0;

        for (CardInfo card : deck) {

            players.get(playerIndex).addCard(card);

            playerIndex++;

            if (playerIndex >= players.size()) {
                playerIndex = 0;
            }
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
    public void nextPlayer() {
        currentPlayer++;

        if (currentPlayer >= players.size()) {
            currentPlayer = 0;
        }
    }
    public CardInfo.Statistic getCurrentStatistic(int position) {
        return getCurrentCard().statistics[position];
    }
        //Here we determine the winner of the round,The winner with the
        // highest value
        public int findWinner(int statisticPosition) {

            int winner = 0;

            for (int i = 1; i < players.size(); i++) {

                CardInfo currentCard = players.get(i).getTopCard();
                CardInfo winnerCard = players.get(winner).getTopCard();

                // SUPER ULTIMA vs normal card
                if (currentCard.superUltima && !winnerCard.superUltima) {

                    if (winnerCard.number != 1) {
                        winner = i;
                        continue;
                    }

                } else if (!currentCard.superUltima && winnerCard.superUltima) {

                    if (currentCard.number != 1) {
                        continue;
                    }
                }

                // Normal statistic comparison
                double currentValue =
                        currentCard.statistics[statisticPosition].value;

                double winnerValue =
                        winnerCard.statistics[statisticPosition].value;

                if (currentValue > winnerValue) {
                    winner = i;
                }
            }

            return winner;
        }
}
