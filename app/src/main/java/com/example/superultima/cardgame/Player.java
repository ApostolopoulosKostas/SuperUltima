package com.example.superultima.cardgame;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player in the Super Ultima game.
 * Each player manages a collection of cards (their deck) and provides methods
 * for adding, removing, and counting cards, as well as checking for quartets.
 */
public class Player {

    /** The list of cards currently held by the player. */
    private final List<CardInfo> cards = new ArrayList<>();

    /**
     * Adds a card to the player's collection.
     * @param card The CardInfo object to add.
     */
    public void addCard(CardInfo card) {
        cards.add(card);
    }

    /**
     * Removes and returns a card at a specific index.
     * @param index The position of the card to remove.
     * @return The removed CardInfo object.
     */
    public CardInfo removeCard(int index) {
        return cards.remove(index);
    }

    /**
     * Returns the full list of cards held by this player.
     */
    public List<CardInfo> getCards() {
        return cards;
    }

    /**
     * Returns the total number of cards currently in the player's deck.
     */
    public int getCardCount() {
        return cards.size();
    }

    /**
     * Retrieves the card currently at the top of the player's deck without removing it.
     * @return The top CardInfo object.
     */
    public CardInfo getTopCard() {
        if (cards.isEmpty()) return null;
        return cards.get(0);
    }

    /**
     * Removes and returns the card at the top of the player's deck.
     * Used when a card is played in a round.
     * @return The removed top CardInfo object.
     */
    public CardInfo removeTopCard() {
        if (cards.isEmpty()) return null;
        return cards.remove(0);
    }

    /**
     * Adds a card to the bottom of the player's deck.
     * Typically used when a player wins a round and collects played cards.
     * @param card The CardInfo object to add to the bottom.
     */
    public void addCardToBottom(CardInfo card) {
        cards.add(card);
    }

    /**
     * Counts how many "quartets" (sets of 4 cards with the same letter) the player has.
     * In some variants of Super Ultima, quartets can provide bonus points or win conditions.
     * @return The number of completed quartets.
     */
    public int countQuartets() {
        int quartets = 0;

        // Iterate through all possible group letters (A-Z).
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            int count = 0;
            // Count how many cards the player has for this specific letter.
            for (CardInfo card : cards) {
                if (card.letter == letter) {
                    count++;
                }
            }
            // If the player has all 4 cards of the group, it's a quartet.
            if (count == 4) {
                quartets++;
            }
        }

        return quartets;
    }
}
