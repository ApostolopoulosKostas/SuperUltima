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
     * Cards held aside during a tie. When a round ties, no one wins yet -
     * the cards wait here and get added to whoever wins the NEXT round.
     */
    private List<CardInfo> pot = new ArrayList<>();

    /**
     * The outcome of a single round: who won (or -1 for a tie), and the
     * stat value each player's card had, so the UI can show both sides.
     */
    public static class RoundResult implements Serializable {
        private static final long serialVersionUID = 1L;

        /** Index of the winning player, or -1 if the round was a tie. */
        public final int winnerIndex;

        /**
         * The compared stat's value for each player, indexed by player id.
         * Double.NaN means that player had no card in this round (already out).
         */
        public final double[] statValues;

        public RoundResult(int winnerIndex, double[] statValues) {
            this.winnerIndex = winnerIndex;
            this.statValues = statValues;
        }

        public boolean isTie() {
            return winnerIndex == -1;
        }
    }

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
     * The player with the highest value wins all cards played in the round
     * (plus anything left over from a previous tie). If two or more players
     * tie for the highest value, no one wins yet - the cards carry over into
     * the pot and get claimed by the winner of the next round.
     * @param statIndex The index of the statistic being compared (0-5).
     * @return A RoundResult describing the winner (or tie) and each player's stat value.
     */
    public RoundResult playRound(int statIndex) {
        double[] statValues = new double[playerCount];
        java.util.Arrays.fill(statValues, Double.NaN);

        int roundWinner = -1;
        double highestValue = Double.NEGATIVE_INFINITY;
        boolean tie = false;
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
                    statValues[i] = value;

                    if (value > highestValue) {
                        // Strictly higher: this player is the new sole leader.
                        highestValue = value;
                        roundWinner = i;
                        tie = false;
                    } else if (value == highestValue) {
                        // Equal to the current best: it's a tie (for now).
                        tie = true;
                    }
                }
            }
        }

        // This round's cards always go into the pot first.
        pot.addAll(roundCards);

        if (tie) {
            // No one wins yet - the pot (including these cards) carries over
            // to whoever wins the next round. Turn stays with the same player.
            return new RoundResult(-1, statValues);
        }

        // The winner takes the entire pot: this round's cards plus anything
        // carried over from a previous tie.
        playerDecks.get(roundWinner).addAll(pot);
        pot.clear();

        // The round winner gets the next turn.
        currentPlayerTurn = roundWinner;

        return new RoundResult(roundWinner, statValues);
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