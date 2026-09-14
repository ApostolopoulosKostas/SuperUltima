package com.example.superultima;

public class CardInfo {

    String code;
    String name;
    String type;
    int image;

    char letter;
    int number;
    boolean superUltima;

    Statistic[] statistics = new Statistic[6];

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

        statistics[position] =
                new Statistic(label, value, unit);
    }

    static class Statistic {

        String label;
        double value;
        String unit;

        Statistic(
                String label,
                double value,
                String unit) {

            this.label = label;
            this.value = value;
            this.unit = unit;
        }
    }
}



