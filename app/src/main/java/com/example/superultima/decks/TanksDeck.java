package com.example.superultima.decks;

import com.example.superultima.cardgame.CardInfo;
import com.example.superultima.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TanksDeck {

    private final List<CardInfo> cards = new ArrayList<>();

    public TanksDeck() {

        // =========================
        // A
        // =========================

        // A1
        CardInfo a1 = new CardInfo(
                "A1",
                "LEOPARD 2",
                "MAIN BATTLE TANK",
                R.drawable.tanks_a1,
                'A',
                1,
                false
        );

        a1.addStatistic(0, "WEIGHT", 55.1, "Tonnes");
        a1.addStatistic(1, "LENGTH", 9.67, "Meters (hull length)");
        a1.addStatistic(2, "HEIGHT", 2.79, "Meters (to turret)");
        a1.addStatistic(3, "POWER/WEIGHT", 27.3, "Hp/Tonne");
        a1.addStatistic(4, "AUTONOMY", 500, "km");
        a1.addStatistic(5, "SPEED", 72, "km/h");

        cards.add(a1);


        // A2
        CardInfo a2 = new CardInfo(
                "A2",
                "MARDER 1A3",
                "INFANTRY FIGHTING VEHICLE",
                R.drawable.tanks_a2,
                'A',
                2,
                false
        );

        a2.addStatistic(0, "WEIGHT", 33.5, "Tonnes");
        a2.addStatistic(1, "LENGTH", 6.88, "Meters (hull length)");
        a2.addStatistic(2, "HEIGHT", 3.02, "Meters (to top)");
        a2.addStatistic(3, "POWER/WEIGHT", 17.9, "Hp/Tonne");
        a2.addStatistic(4, "AUTONOMY", 500, "km");
        a2.addStatistic(5, "SPEED", 65, "km/h");

        cards.add(a2);


        // A3
        CardInfo a3 = new CardInfo(
                "A3",
                "FRECCIA IFV",
                "WHEELED INFANTRY FIGHTING VEHICLE",
                R.drawable.tanks_a3,
                'A',
                3,
                false
        );

        a3.addStatistic(0, "WEIGHT", 31.5, "Tonnes");
        a3.addStatistic(1, "LENGTH", 8.56, "Meters");
        a3.addStatistic(2, "HEIGHT", 3.18, "Meters");
        a3.addStatistic(3, "POWER/WEIGHT", 17.5, "Hp/Tonne");
        a3.addStatistic(4, "AUTONOMY", 800, "km");
        a3.addStatistic(5, "SPEED", 110, "km/h");

        cards.add(a3);


        // A4
        CardInfo a4 = new CardInfo(
                "A4",
                "M2 BRADLEY",
                "INFANTRY FIGHTING VEHICLE",
                R.drawable.tanks_a4,
                'A',
                4,
                false
        );

        a4.addStatistic(0, "WEIGHT", 36.25, "Tonnes");
        a4.addStatistic(1, "LENGTH", 6.55, "Meters");
        a4.addStatistic(2, "HEIGHT", 2.98, "Meters");
        a4.addStatistic(3, "POWER/WEIGHT", 18.2, "Hp/Tonne");
        a4.addStatistic(4, "AUTONOMY", 402, "km");
        a4.addStatistic(5, "SPEED", 61, "km/h");

        cards.add(a4);


        // =========================
        // B
        // =========================

        // B1
        CardInfo b1 = new CardInfo(
                "B1",
                "T-14 ARMATA",
                "MAIN BATTLE TANK",
                R.drawable.tanks_b1,
                'B',
                1,
                false
        );

        b1.addStatistic(0, "WEIGHT", 55.0, "Tonnes");
        b1.addStatistic(1, "LENGTH", 10.70, "Meters (with gun forward)");
        b1.addStatistic(2, "HEIGHT", 3.30, "Meters (to top)");
        b1.addStatistic(3, "POWER/WEIGHT", 27.3, "Hp/Tonne");
        b1.addStatistic(4, "AUTONOMY", 500, "km");
        b1.addStatistic(5, "SPEED", 90, "km/h");

        cards.add(b1);


        // B2
        CardInfo b2 = new CardInfo(
                "B2",
                "MERKAVA IV",
                "MAIN BATTLE TANK",
                R.drawable.tanks_b2,
                'B',
                2,
                false
        );

        b2.addStatistic(0, "WEIGHT", 65.0, "Tonnes");
        b2.addStatistic(1, "LENGTH", 9.04, "Meters (hull length)");
        b2.addStatistic(2, "HEIGHT", 2.66, "Meters (to top)");
        b2.addStatistic(3, "POWER/WEIGHT", 23.1, "Hp/Tonne");
        b2.addStatistic(4, "AUTONOMY", 500, "km");
        b2.addStatistic(5, "SPEED", 64, "km/h");

        cards.add(b2);


        // B3
        CardInfo b3 = new CardInfo(
                "B3",
                "SCHÜTZENPANZER PUMA",
                "INFANTRY FIGHTING VEHICLE",
                R.drawable.tanks_b3,
                'B',
                3,
                false
        );

        b3.addStatistic(0, "WEIGHT", 31.45, "Tonnes");
        b3.addStatistic(1, "LENGTH", 7.60, "Meters (hull length)");
        b3.addStatistic(2, "HEIGHT", 3.05, "Meters (to top)");
        b3.addStatistic(3, "POWER/WEIGHT", 34.3, "Hp/Tonne");
        b3.addStatistic(4, "AUTONOMY", 600, "km");
        b3.addStatistic(5, "SPEED", 70, "km/h");

        cards.add(b3);


        // B4
        CardInfo b4 = new CardInfo(
                "B4",
                "FV4201 CHIEFTAIN",
                "MAIN BATTLE TANK",
                R.drawable.tanks_b4,
                'B',
                4,
                false
        );

        b4.addStatistic(0, "WEIGHT", 55.0, "Tonnes");
        b4.addStatistic(1, "LENGTH", 7.52, "Meters (hull length)");
        b4.addStatistic(2, "HEIGHT", 2.89, "Meters (to top)");
        b4.addStatistic(3, "POWER/WEIGHT", 13.5, "Hp/Tonne");
        b4.addStatistic(4, "AUTONOMY", 400, "km");
        b4.addStatistic(5, "SPEED", 48, "km/h");

        cards.add(b4);


        // =========================
        // C
        // =========================

        // C1
        CardInfo c1 = new CardInfo(
                "C1",
                "FV4030/4 CHALLENGER 1",
                "MAIN BATTLE TANK",
                R.drawable.tanks_c1,
                'C',
                1,
                false
        );

        c1.addStatistic(0, "WEIGHT", 62.0, "Tonnes");
        c1.addStatistic(1, "LENGTH", 8.32, "Meters (hull length)");
        c1.addStatistic(2, "HEIGHT", 2.95, "Meters (to top)");
        c1.addStatistic(3, "POWER/WEIGHT", 19.4, "Hp/Tonne");
        c1.addStatistic(4, "AUTONOMY", 450, "km");
        c1.addStatistic(5, "SPEED", 56, "km/h");

        cards.add(c1);


        // C2
        CardInfo c2 = new CardInfo(
                "C2",
                "M48 PATTON",
                "MAIN BATTLE TANK",
                R.drawable.tanks_c2,
                'C',
                2,
                false
        );

        c2.addStatistic(0, "WEIGHT", 49.6, "Tonnes");
        c2.addStatistic(1, "LENGTH", 6.88, "Meters (hull length)");
        c2.addStatistic(2, "HEIGHT", 3.10, "Meters (to top)");
        c2.addStatistic(3, "POWER/WEIGHT", 16.5, "Hp/Tonne");
        c2.addStatistic(4, "AUTONOMY", 460, "km");
        c2.addStatistic(5, "SPEED", 45, "km/h");

        cards.add(c2);


        // C3
        CardInfo c3 = new CardInfo(
                "C3",
                "BMP-2",
                "INFANTRY FIGHTING VEHICLE",
                R.drawable.tanks_c3,
                'C',
                3,
                false
        );

        c3.addStatistic(0, "WEIGHT", 14.2, "Tonnes");
        c3.addStatistic(1, "LENGTH", 5.88, "Meters (hull length)");
        c3.addStatistic(2, "HEIGHT", 2.84, "Meters (to top)");
        c3.addStatistic(3, "POWER/WEIGHT", 19.7, "Hp/Tonne");
        c3.addStatistic(4, "AUTONOMY", 600, "km");
        c3.addStatistic(5, "SPEED", 65, "km/h");

        cards.add(c3);


        // C4
        CardInfo c4 = new CardInfo(
                "C4",
                "COMBAT VEHICLE 90 (CV90)",
                "INFANTRY FIGHTING VEHICLE",
                R.drawable.tanks_c4,
                'C',
                4,
                false
        );

        c4.addStatistic(0, "WEIGHT", 35.0, "Tonnes");
        c4.addStatistic(1, "LENGTH", 6.55, "Meters (hull length)");
        c4.addStatistic(2, "HEIGHT", 2.71, "Meters (to top)");
        c4.addStatistic(3, "POWER/WEIGHT", 27.1, "Hp/Tonne");
        c4.addStatistic(4, "AUTONOMY", 900, "km");
        c4.addStatistic(5, "SPEED", 70, "km/h");

        cards.add(c4);


        // =========================
        // D
        // =========================

        // D1
        CardInfo d1 = new CardInfo(
                "D1",
                "K2 BLACK PANTHER",
                "MAIN BATTLE TANK",
                R.drawable.tanks_d1,
                'D',
                1,
                false
        );

        d1.addStatistic(0, "WEIGHT", 55.0, "Tonnes");
        d1.addStatistic(1, "LENGTH", 10.83, "Meters (with gun forward)");
        d1.addStatistic(2, "HEIGHT", 2.22, "Meters (to top)");
        d1.addStatistic(3, "POWER/WEIGHT", 27.3, "Hp/Tonne");
        d1.addStatistic(4, "AUTONOMY", 450, "km");
        d1.addStatistic(5, "SPEED", 70, "km/h");

        cards.add(d1);


        // D2
        CardInfo d2 = new CardInfo(
                "D2",
                "TYPE 99",
                "MAIN BATTLE TANK",
                R.drawable.tanks_d2,
                'D',
                2,
                false
        );

        d2.addStatistic(0, "WEIGHT", 54.0, "Tonnes");
        d2.addStatistic(1, "LENGTH", 11.0, "Meters (with gun forward)");
        d2.addStatistic(2, "HEIGHT", 2.4, "Meters (to top)");
        d2.addStatistic(3, "POWER/WEIGHT", 22.2, "Hp/Tonne");
        d2.addStatistic(4, "AUTONOMY", 450, "km");
        d2.addStatistic(5, "SPEED", 80, "km/h");

        cards.add(d2);


        // D3
        CardInfo d3 = new CardInfo(
                "D3",
                "FV4034 CHALLENGER 2",
                "MAIN BATTLE TANK",
                R.drawable.tanks_d3,
                'D',
                3,
                false
        );

        d3.addStatistic(0, "WEIGHT", 75.0, "Tonnes");
        d3.addStatistic(1, "LENGTH", 11.55, "Meters (with gun forward)");
        d3.addStatistic(2, "HEIGHT", 2.50, "Meters (to top)");
        d3.addStatistic(3, "POWER/WEIGHT", 16.0, "Hp/Tonne");
        d3.addStatistic(4, "AUTONOMY", 550, "km");
        d3.addStatistic(5, "SPEED", 59, "km/h");

        cards.add(d3);


        // D4
        CardInfo d4 = new CardInfo(
                "D4",
                "KURGANETS-25",
                "INFANTRY FIGHTING VEHICLE",
                R.drawable.tanks_d4,
                'D',
                4,
                false
        );

        d4.addStatistic(0, "WEIGHT", 25.0, "Tonnes");
        d4.addStatistic(1, "LENGTH", 7.2, "Meters (hull length)");
        d4.addStatistic(2, "HEIGHT", 3.0, "Meters (to top)");
        d4.addStatistic(3, "POWER/WEIGHT", 32.0, "Hp/Tonne");
        d4.addStatistic(4, "AUTONOMY", 500, "km");
        d4.addStatistic(5, "SPEED", 80, "km/h");

        cards.add(d4);


        // =========================
        // E
        // =========================

        // E1
        CardInfo e1 = new CardInfo(
                "E1",
                "BMP-3",
                "INFANTRY FIGHTING VEHICLE",
                R.drawable.tanks_e1,
                'E',
                1,
                false
        );

        e1.addStatistic(0, "WEIGHT", 18.7, "Tonnes");
        e1.addStatistic(1, "LENGTH", 7.14, "Meters (hull length)");
        e1.addStatistic(2, "HEIGHT", 2.45, "Meters (to top)");
        e1.addStatistic(3, "POWER/WEIGHT", 26.7, "Hp/Tonne");
        e1.addStatistic(4, "AUTONOMY", 600, "km");
        e1.addStatistic(5, "SPEED", 70, "km/h");

        cards.add(e1);


        // E2
        CardInfo e2 = new CardInfo(
                "E2",
                "M1 ABRAMS",
                "MAIN BATTLE TANK",
                R.drawable.tanks_e2,
                'E',
                2,
                false
        );

        e2.addStatistic(0, "WEIGHT", 66.8, "Tonnes");
        e2.addStatistic(1, "LENGTH", 9.77, "Meters (with gun forward)");
        e2.addStatistic(2, "HEIGHT", 2.44, "Meters (to top)");
        e2.addStatistic(3, "POWER/WEIGHT", 22.5, "Hp/Tonne");
        e2.addStatistic(4, "AUTONOMY", 426, "km");
        e2.addStatistic(5, "SPEED", 67, "km/h");

        cards.add(e2);


        // E3
        CardInfo e3 = new CardInfo(
                "E3",
                "KAMPFPANZER LEOPARD 1",
                "MAIN BATTLE TANK",
                R.drawable.tanks_e3,
                'E',
                3,
                false
        );

        e3.addStatistic(0, "WEIGHT", 42.2, "Tonnes");
        e3.addStatistic(1, "LENGTH", 9.54, "Meters (with gun forward)");
        e3.addStatistic(2, "HEIGHT", 2.61, "Meters (to top)");
        e3.addStatistic(3, "POWER/WEIGHT", 19.9, "Hp/Tonne");
        e3.addStatistic(4, "AUTONOMY", 600, "km");
        e3.addStatistic(5, "SPEED", 65, "km/h");

        cards.add(e3);


        // E4
        CardInfo e4 = new CardInfo(
                "E4",
                "C1 ARIETE",
                "MAIN BATTLE TANK",
                R.drawable.tanks_e4,
                'E',
                4,
                false
        );

        e4.addStatistic(0, "WEIGHT", 54.0, "Tonnes");
        e4.addStatistic(1, "LENGTH", 9.67, "Meters (with gun forward)");
        e4.addStatistic(2, "HEIGHT", 2.51, "Meters (to top)");
        e4.addStatistic(3, "POWER/WEIGHT", 23.5, "Hp/Tonne");
        e4.addStatistic(4, "AUTONOMY", 550, "km");
        e4.addStatistic(5, "SPEED", 65, "km/h");

        cards.add(e4);


        // =========================
        // F
        // =========================

        // F1
        CardInfo f1 = new CardInfo(
                "F1",
                "T-72",
                "MAIN BATTLE TANK",
                R.drawable.tanks_f1,
                'F',
                1,
                false
        );

        f1.addStatistic(0, "WEIGHT", 41.5, "Tonnes");
        f1.addStatistic(1, "LENGTH", 9.53, "Meters (with gun forward)");
        f1.addStatistic(2, "HEIGHT", 2.19, "Meters (to top)");
        f1.addStatistic(3, "POWER/WEIGHT", 18.8, "Hp/Tonne");
        f1.addStatistic(4, "AUTONOMY", 500, "km");
        f1.addStatistic(5, "SPEED", 60, "km/h");

        cards.add(f1);


        // F2
        CardInfo f2 = new CardInfo(
                "F2",
                "ASCOD",
                "INFANTRY FIGHTING VEHICLE",
                R.drawable.tanks_f2,
                'F',
                2,
                false
        );

        f2.addStatistic(0, "WEIGHT", 28.0, "Tonnes");
        f2.addStatistic(1, "LENGTH", 6.83, "Meters (hull length)");
        f2.addStatistic(2, "HEIGHT", 2.45, "Meters (to top)");
        f2.addStatistic(3, "POWER/WEIGHT", 25.7, "Hp/Tonne");
        f2.addStatistic(4, "AUTONOMY", 500, "km");
        f2.addStatistic(5, "SPEED", 72, "km/h");

        cards.add(f2);


        // F3 - SUPER ULTIMA
        CardInfo f3 = new CardInfo(
                "F3",
                "T-90",
                "MAIN BATTLE TANK",
                R.drawable.tanks_f3,
                'F',
                3,
                true
        );

        f3.addStatistic(0, "WEIGHT", 46.5, "Tonnes");
        f3.addStatistic(1, "LENGTH", 9.53, "Meters (with gun forward)");
        f3.addStatistic(2, "HEIGHT", 2.22, "Meters (to top)");
        f3.addStatistic(3, "POWER/WEIGHT", 21.5, "Hp/Tonne");
        f3.addStatistic(4, "AUTONOMY", 550, "km");
        f3.addStatistic(5, "SPEED", 60, "km/h");

        cards.add(f3);


        // F4
        CardInfo f4 = new CardInfo(
                "F4",
                "T-80",
                "MAIN BATTLE TANK",
                R.drawable.tanks_f4,
                'F',
                4,
                false
        );

        f4.addStatistic(0, "WEIGHT", 46.0, "Tonnes");
        f4.addStatistic(1, "LENGTH", 9.56, "Meters (with gun forward)");
        f4.addStatistic(2, "HEIGHT", 2.21, "Meters (to top)");
        f4.addStatistic(3, "POWER/WEIGHT", 27.2, "Hp/Tonne");
        f4.addStatistic(4, "AUTONOMY", 400, "km");
        f4.addStatistic(5, "SPEED", 70, "km/h");

        cards.add(f4);


        // =========================
        // G
        // =========================

        // G1
        CardInfo g1 = new CardInfo(
                "G1",
                "LAV-25",
                "LIGHT ARMORED RECONNAISSANCE VEHICLE",
                R.drawable.tanks_g1,
                'G',
                1,
                false
        );

        g1.addStatistic(0, "WEIGHT", 12.8, "Tonnes");
        g1.addStatistic(1, "LENGTH", 6.39, "Meters (hull length)");
        g1.addStatistic(2, "HEIGHT", 2.69, "Meters (to top)");
        g1.addStatistic(3, "POWER/WEIGHT", 21.5, "Hp/Tonne");
        g1.addStatistic(4, "AUTONOMY", 668, "km");
        g1.addStatistic(5, "SPEED", 100, "km/h");

        cards.add(g1);


        // G2
        CardInfo g2 = new CardInfo(
                "G2",
                "TYPE 10",
                "MAIN BATTLE TANK",
                R.drawable.tanks_g2,
                'G',
                2,
                false
        );

        g2.addStatistic(0, "WEIGHT", 44.0, "Tonnes");
        g2.addStatistic(1, "LENGTH", 9.48, "Meters (with gun forward)");
        g2.addStatistic(2, "HEIGHT", 2.30, "Meters (to top)");
        g2.addStatistic(3, "POWER/WEIGHT", 27.3, "Hp/Tonne");
        g2.addStatistic(4, "AUTONOMY", 500, "km");
        g2.addStatistic(5, "SPEED", 70, "km/h");

        cards.add(g2);


        // G3
        CardInfo g3 = new CardInfo(
                "G3",
                "BMP-1",
                "INFANTRY FIGHTING VEHICLE",
                R.drawable.tanks_g3,
                'G',
                3,
                false
        );

        g3.addStatistic(0, "WEIGHT", 13.2, "Tonnes");
        g3.addStatistic(1, "LENGTH", 6.74, "Meters (hull length)");
        g3.addStatistic(2, "HEIGHT", 2.06, "Meters (to top)");
        g3.addStatistic(3, "POWER/WEIGHT", 22.7, "Hp/Tonne");
        g3.addStatistic(4, "AUTONOMY", 600, "km");
        g3.addStatistic(5, "SPEED", 65, "km/h");

        cards.add(g3);


        // G4
        CardInfo g4 = new CardInfo(
                "G4",
                "TYPE 96",
                "MAIN BATTLE TANK",
                R.drawable.tanks_g4,
                'G',
                4,
                false
        );

        g4.addStatistic(0, "WEIGHT", 42.8, "Tonnes");
        g4.addStatistic(1, "LENGTH", 10.28, "Meters (with gun forward)");
        g4.addStatistic(2, "HEIGHT", 2.30, "Meters (to top)");
        g4.addStatistic(3, "POWER/WEIGHT", 18.2, "Hp/Tonne");
        g4.addStatistic(4, "AUTONOMY", 400, "km");
        g4.addStatistic(5, "SPEED", 65, "km/h");

        cards.add(g4);


        // =========================
        // H
        // =========================

        // H1
        CardInfo h1 = new CardInfo(
                "H1",
                "LECLERC",
                "MAIN BATTLE TANK",
                R.drawable.tanks_h1,
                'H',
                1,
                false
        );

        h1.addStatistic(0, "WEIGHT", 57.4, "Tonnes");
        h1.addStatistic(1, "LENGTH", 9.87, "Meters (with gun forward)");
        h1.addStatistic(2, "HEIGHT", 2.53, "Meters (to top)");
        h1.addStatistic(3, "POWER/WEIGHT", 26.5, "Hp/Tonne");
        h1.addStatistic(4, "AUTONOMY", 550, "km");
        h1.addStatistic(5, "SPEED", 71, "km/h");

        cards.add(h1);


        // H2
        CardInfo h2 = new CardInfo(
                "H2",
                "T-90",
                "MAIN BATTLE TANK",
                R.drawable.tanks_h2,
                'H',
                2,
                false
        );

        h2.addStatistic(0, "WEIGHT", 46.5, "Tonnes");
        h2.addStatistic(1, "LENGTH", 9.53, "Meters (with gun forward)");
        h2.addStatistic(2, "HEIGHT", 2.22, "Meters (to top)");
        h2.addStatistic(3, "POWER/WEIGHT", 21.5, "Hp/Tonne");
        h2.addStatistic(4, "AUTONOMY", 550, "km");
        h2.addStatistic(5, "SPEED", 60, "km/h");

        cards.add(h2);


        // H3
        CardInfo h3 = new CardInfo(
                "H3",
                "VBCI",
                "WHEELED INFANTRY FIGHTING VEHICLE",
                R.drawable.tanks_h3,
                'H',
                3,
                false
        );

        h3.addStatistic(0, "WEIGHT", 25.6, "Tonnes");
        h3.addStatistic(1, "LENGTH", 8.31, "Meters (hull length)");
        h3.addStatistic(2, "HEIGHT", 3.00, "Meters (to top)");
        h3.addStatistic(3, "POWER/WEIGHT", 21.5, "Hp/Tonne");
        h3.addStatistic(4, "AUTONOMY", 750, "km");
        h3.addStatistic(5, "SPEED", 100, "km/h");

        cards.add(h3);


        // H4
        CardInfo h4 = new CardInfo(
                "H4",
                "AMX-30",
                "MAIN BATTLE TANK",
                R.drawable.tanks_h4,
                'H',
                4,
                false
        );

        h4.addStatistic(0, "WEIGHT", 36.0, "Tonnes");
        h4.addStatistic(1, "LENGTH", 9.48, "Meters (hull length)");
        h4.addStatistic(2, "HEIGHT", 2.28, "Meters (to top)");
        h4.addStatistic(3, "POWER/WEIGHT", 19.4, "Hp/Tonne");
        h4.addStatistic(4, "AUTONOMY", 600, "km");
        h4.addStatistic(5, "SPEED", 100, "km/h");

        cards.add(h4);
    }

    public List<CardInfo> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}