package com.example.superultima.cardgame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the data for a single card in the Super Ultima game.
 * Each card contains identification details (code, name, type), an image,
 * and a set of numerical statistics used for gameplay comparison.
 */
public class CardInfo implements Serializable {

    /** Unique code for the card (e.g., "A1"). */
    public String code;
    /** Display name of the item on the card (e.g., "F-16 Fighting Falcon"). */
    public String name;
    /** Category of the card (e.g., "FIGHTER"). */
    public String type;
    /** Resource ID for the card's image drawable. */
    public int image;

    /** Letter classification for deck grouping (e.g., 'A'). */
    public char letter;
    /** Number classification within the group (e.g., 1). */
    public int number;
    /** Flag indicating if this is a special "Super Ultima" card with unique rules. */
    public boolean superUltima;

    /** 
     * Array of statistics for this card. 
     * Fixed at 6 slots to match the UI layout.
     */
    public Statistic[] statistics = new Statistic[6];

    /**
     * Constructs a new CardInfo object.
     */
    public CardInfo(
            String code,
            String name,
            String type,
            int image,
            char letter,
            int number,
            boolean superUltima) {

        this.code = code;
        this.name = name;
        this.type = type;
        this.image = image;
        this.letter = letter;
        this.number = number;
        this.superUltima = superUltima;
    }

    /**
     * Adds a statistic to the card at a specific position.
     * @param position Index from 0 to 5.
     * @param label Name of the statistic (e.g., "Speed").
     * @param value Numerical value of the statistic.
     * @param unit Unit of measurement (e.g., "km/h").
     */
    public void addStatistic(
            int position,
            String label,
            double value,
            String unit) {

        if (position >= 0 && position < 6) {
            statistics[position] = new Statistic(label, value, unit);
        }
    }

    /**
     * Helper method to get all non-null statistics as a list.
     * Useful for iteration and filtering.
     */
    public List<Statistic> getStatistics() {
        List<Statistic> list = new ArrayList<>();
        for (Statistic stat : statistics) {
            if (stat != null) {
                list.add(stat);
            }
        }
        return list;
    }

    /**
     * Represents a single numerical attribute of a card.
     */
    public static class Statistic implements Serializable {
        /** Display label for the statistic. */
        public String label;
        /** Numeric value for comparison. */
        public double value;
        /** Optional unit suffix (e.g., "kg"). */
        public String unit;

        public Statistic(
                String label,
                double value,
                String unit) {

            this.label = label;
            this.value = value;
            this.unit = unit;
        }
    }
}
