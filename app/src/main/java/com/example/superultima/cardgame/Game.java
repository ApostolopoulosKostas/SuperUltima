package com.example.superultima.cardgame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The core logic for a Super Ultima game session.
 * Handles deck distribution, turn management, and determining round winners.
 */
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Number of players in the game (Local + Remote or Local + CPU). */
    private int playerCount;
    
    /** Index of the player whose turn it is to pick a statistic. */
    private int currentPlayerTurn = 0;
    
    /** Each player has their own list of cards (their deck). */
    private List<List<CardInfo>> playerDecks;

    /**
     * Initializes a new game, shuffles the deck, and deals cards to all players.
     * @param playerCount Total players (2-4).
     * @param fullDeck The complete list of cards to be used.
     */
    public Game(int playerCount, List<CardInfo> fullDeck) {
        this.playerCount = playerCount;
        this.playerDecks = new ArrayList<>();

        // Create an empty deck for each player.
        for (int i = 0; i < playerCount; i++) {
            playerDecks.add(new ArrayList<>());
        }

        // Shuffle the starting deck to ensure randomness.
        List<CardInfo> shuffledDeck = new ArrayList<>(fullDeck);
        Collections.shuffle(shuffledDeck);

        // Distribute cards evenly among players.
        for (int i = 0; i < shuffledDeck.size(); i++) {
            playerDecks.get(i % playerCount).add(shuffledDeck.get(i));
        }
    }

    public int getCurrentPlayerTurn() {
        return currentPlayerTurn;
    }

    /**
     * Retrieves the top card currently held by a specific player.
     * @param playerId The index of the player.
     * @return The top CardInfo object, or null if the player has no cards left.
     */
    public CardInfo getPlayerCard(int playerId) {
        if (playerId < 0 || playerId >= playerDecks.size()) {
            return null;
        }

        List<CardInfo> playerDeck = playerDecks.get(playerId);
        if (playerDeck.isEmpty()) {
            return null;
        }

        return playerDeck.get(0);
    }

    /**
     * Retrieves the top card of the player whose turn it is.
     */
    public CardInfo getCurrentCard() {
        return getPlayerCard(currentPlayerTurn);
    }

    /**
     * Plays a round by comparing the selected statistic across all active players.
     * The player with the highest value wins all cards played in the round.
     * @param statIndex The index of the statistic being compared (0-5).
     * @return The index of the player who won the round.
     */
    public int playRound(int statIndex) {
        int roundWinner = currentPlayerTurn;
        double highestValue = Double.NEGATIVE_INFINITY;
        List<CardInfo> roundCards = new ArrayList<>();

        // Collect the top card from every player who still has cards.
        for (int i = 0; i < playerCount; i++) {
            List<CardInfo> playerDeck = playerDecks.get(i);

            if (!playerDeck.isEmpty()) {
                // Remove the top card for the comparison.
                CardInfo card = playerDeck.remove(0);
                roundCards.add(card);

                // Check the value of the chosen statistic on this card.
                CardInfo.Statistic stat = card.statistics[statIndex];
                if (stat != null) {
                    double value = stat.value;
                    // Update winner if this card has a higher value.
                    if (value > highestValue) {
                        highestValue = value;
                        roundWinner = i;
                    }
                }
            }
        }

        // The winner receives all cards from the round at the bottom of their deck.
        playerDecks.get(roundWinner).addAll(roundCards);

        // The round winner gets the next turn.
        currentPlayerTurn = roundWinner;

        return roundWinner;
    }

    /**
     * Checks if the game is over (when only one player has cards left).
     */
    public boolean isGameOver() {
        int activePlayers = 0;
        for (List<CardInfo> deck : playerDecks) {
            if (!deck.isEmpty()) {
                activePlayers++;
            }
        }
        return activePlayers <= 1;
    }

    /**
     * Returns the index of the overall game winner.
     */
    public int getWinner() {
        for (int i = 0; i < playerCount; i++) {
            if (!playerDecks.get(i).isEmpty()) {
                return i;
            }
        }
        return 0;
    }
}
