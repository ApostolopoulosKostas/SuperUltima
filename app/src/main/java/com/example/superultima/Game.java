package com.example.superultima;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a game session in SuperUltima.
 * Manages the players participating in the game.
 */
public class Game {

    /**
     * The list of players currently in the game.
     */
    private final List<Player> players = new ArrayList<>();
    private int currentPlayer;
    private boolean firstRound = true;
    private final List<CardInfo> leftoverCards = new ArrayList<>();

    /**
     * Constructs a new Game with a specified number of players.
     *
     * @param numberOfPlayers The number of players to initialize the game with.
     */
    public Game(int numberOfPlayers, List<CardInfo> deck) {

        if (numberOfPlayers < 2 || numberOfPlayers > 4) {
            throw new IllegalArgumentException("SuperUltima supports 2 to 4 players.");
        }

        // Create the players
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player());
        }

        // Shuffle the deck once
        Collections.shuffle(deck);

        // Deal the cards once
        dealCards(deck);

        // Choose a random starting player
        currentPlayer =
                (int) (Math.random() * players.size());
    }

    public CardInfo getCurrentCard() {
        return getCurrentPlayer().getTopCard();
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    // Deal the cards to each player
    private void dealCards(List<CardInfo> deck) {

        int cardsPerPlayer = deck.size() / players.size();// Calculate the number of cards per player

        int cardIndex = 0;// Initialize the card index

        for (Player player : players) {

            for (int i = 0; i < cardsPerPlayer; i++) {

                player.addCard(deck.get(cardIndex)); // Deal a card to the player
                cardIndex++;// Move to the next card in the deck
            }
        }

        while (cardIndex < deck.size()) {

            leftoverCards.add(deck.get(cardIndex));
            cardIndex++;
        }

    }

    public List<Player> getPlayers() {
        return players;
    }

    public void nextPlayer() {
        do {
            currentPlayer++;

            if (currentPlayer >= players.size()) {
                currentPlayer = 0;
            }

        } while (players.get(currentPlayer).getCardCount() == 0);
    }

    public CardInfo.Statistic getCurrentStatistic(int position) {
        return getCurrentCard().statistics[position];
    }

    // Here we determine the winner of the round.
    // The winner has the highest value.
    public int findWinner(int statisticPosition) {

        int winner = -1;

        for (int i = 0; i < players.size(); i++) {

            if (players.get(i).getCardCount() > 0) {
                winner = i;
                break;
            }
        }

        for (int i = 0; i < players.size(); i++) {

            if (i == winner || players.get(i).getCardCount() == 0) {
                continue;
            }

            CardInfo currentCard =
                    players.get(i).getTopCard();

            CardInfo winnerCard =
                    players.get(winner).getTopCard();

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




    // Collects the top card from every player
    // and gives them to the winner.
    public void collectCards(int winnerIndex) {

        Player winner =
                players.get(winnerIndex);

        for (Player player : players) {
            if (player.getCardCount() == 0) {
                continue;
            }

            CardInfo card =
                    player.removeTopCard();

            winner.addCard(card);
        }
    }

    // The winner becomes the current player.
    public void setCurrentPlayer(int playerIndex) {
        currentPlayer = playerIndex;


    }
    public boolean isGameOver() {

        int playersWithCards = 0;

        for (Player player : players) {

            if (player.getCardCount() > 0) {
                playersWithCards++;
            }
        }

        return playersWithCards == 1;
    }
    public int getWinner() {

        for (int i = 0; i < players.size(); i++) {

            if (players.get(i).getCardCount() > 0) {
                return i;
            }
        }

        return -1;
    }


    public int playRound(int statisticPosition) {

        int winner =
                findWinner(statisticPosition);

        collectCards(winner);

        if (firstRound) {
            players.get(winner).getCards().addAll(leftoverCards);
            leftoverCards.clear();
            firstRound = false;
        }
        setCurrentPlayer(winner);

        return winner;
    }
    public int getPlayerQuartets(int playerIndex) {
        return players.get(playerIndex).countQuartets();
    }
    public int[] getAllQuartets() {

        int[] quartets = new int[players.size()];

        for (int i = 0; i < players.size(); i++) {
            quartets[i] = players.get(i).countQuartets();
        }

        return quartets;
    }

}