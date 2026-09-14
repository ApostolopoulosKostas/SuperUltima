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

}
