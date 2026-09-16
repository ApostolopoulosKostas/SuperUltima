package com.example.superultima;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CardInfo implements Serializable {

    public String code;
    public String name;
    public String type;
    public int image;

    public char letter;
    public int number;
    public boolean superUltima;

    // Kept as a fixed array so legacy card.statistics[i] calls never break
    public Statistic[] statistics = new Statistic[6];

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

    public void addStatistic(
            int position,
            String label,
            double value,
            String unit) {

        if (position >= 0 && position < 6) {
            statistics[position] = new Statistic(label, value, unit);
        }
    }

    // NEW HELPER: Converts the array into a List so GameActivity.getStatistics() works smoothly
    public List<Statistic> getStatistics() {
        List<Statistic> list = new ArrayList<>();
        for (Statistic stat : statistics) {
            if (stat != null) {
                list.add(stat);
            }
        }
        return list;
    }

    public static class Statistic implements Serializable {
        public String label;
        public double value;
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