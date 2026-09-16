package com.example.superultima;

public class CpuPlayer {

    public static int getBestStatIndex(CardInfo card) {

        if (card == null) {
            return 0;
        }

        int bestIndex = 0;
        double highestValue = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < card.statistics.length; i++) {

            CardInfo.Statistic stat =
                    card.statistics[i];

            if (stat == null) {
                continue;
            }

            if (stat.value > highestValue) {
                highestValue = stat.value;
                bestIndex = i;
            }
        }

        return bestIndex;
    }
}