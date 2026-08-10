package com.example.superultima;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final AirplaneDeck deck;
    private final List<Player> players;

    public Game(int numberOfPlayers) {

        deck = new AirplaneDeck();
        players = new ArrayList<>();

        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player("Player " + i));
        }
    }

    public void startGame() {

        deck.shuffle();

        dealCards();
    }

    private void dealCards() {

        List<Airplane> cards = deck.getCards();

        int playerIndex = 0;

        for (Airplane card : cards) {

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
//    public void testGame() { Game game = new Game(2);
//        game.startGame();
//        for (Player player : game.getPlayers())
//        { System.out.println(player.getName());
//        for (Airplane card : player.getCards())
//        { System.out.println(card.code); } } }
}



