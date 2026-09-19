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
                    "Main Battle tank",
                    R.drawable.tanks_a1,
                    'A',
                    1,
                    false
            );

            a1.addStatistic(0, "Weight", 55.1, "Tonnes");
            a1.addStatistic(1, "Length", 9.67, "Meters(hull length");
            a1.addStatistic(2, "Height", 2.79, "Meters(to turret");
            a1.addStatistic(3, "Power/Weight", 27.3, "Hp/Tonne");
            a1.addStatistic(4, "Autonomy", 500, "km");
            a1.addStatistic(5, "Speed", 72, "km/h");

            cards.add(a1);

            // A2
            CardInfo a2 = new CardInfo(
                    "A2",
                    "Marder 1a3",
                    "Infantry fighting vehicle",
                    R.drawable.tanks_a2,
                    'A',
                    2,
                    false
            );

        a2.addStatistic(0, "Weight", 33.5, "Tonnes");
        a2.addStatistic(1, "Length", 6.88, "Meters(hull length)");
        a2.addStatistic(2, "Height", 3.02, "Meters(to top)");
        a2.addStatistic(3, "Power/Weight", 17.9, "Hp/Tonne");
        a2.addStatistic(4, "Autonomy", 500, "km");
        a2.addStatistic(5, "Speed", 65, "km/h");

            cards.add(a2);

            // A3
            CardInfo a3 = new CardInfo(
                    "A3",
                    "Freccia IFV",
                    "Armoured vehicles",
                    R.drawable.tanks_a3,
                    'A',
                    3,
                    false
            );

        a3.addStatistic(0, "Weight", 31.5, "Tonnes");
        a3.addStatistic(1, "Length", 8.56, "Meters");
        a3.addStatistic(2, "Height", 3.18, "Meters");
        a3.addStatistic(3, "Power/Weight", 17.5, "Hp/Tonne");
        a3.addStatistic(4, "Autonomy", 800, "km");
        a3.addStatistic(5, "Speed", 110, "km/h");

            cards.add(a3);

            // A4
            CardInfo a4 = new CardInfo(
                    "A4",
                    "M2 Bradley",
                    "Infantry fighting ",
                    R.drawable.tanks_a4,
                    'A',
                    4,
                    false
            );

        a4.addStatistic(0, "Weight", 36.25, "Tonnes");
        a4.addStatistic(1, "Length", 6.55, "Meters");
        a4.addStatistic(2, "Height", 2.98, "Meters");
        a4.addStatistic(3, "Power/Weight", 18.2, "Hp/Tonne");
        a4.addStatistic(4, "Autonomy", 402, "km");
        a4.addStatistic(5, "Speed", 61, "km/h");

            cards.add(a4);


            // =========================
            // B
            // =========================

            // B1
            CardInfo b1 = new CardInfo(
                    "B1",
                    "T-14 Armata",
                    "Main Battle tank",
                    R.drawable.tanks_b1,
                    'B',
                    1,
                    false
            );

        b1.addStatistic(0, "Weight", 55.0, "Tonnes");
        b1.addStatistic(1, "Length", 10.70, "Meters(with gun forward)");
        b1.addStatistic(2, "Height", 3.30, "Meters(to top)");
        b1.addStatistic(3, "Power/Weight", 27.3, "Hp/Tonne");
        b1.addStatistic(4, "Autonomy", 500, "km");
        b1.addStatistic(5, "Speed", 90, "km/h");

            cards.add(b1);

            // B2
            CardInfo b2 = new CardInfo(
                    "B2",
                    "Merkava Iv",
                    "Main Battle tank",
                    R.drawable.tanks_b2,
                    'B',
                    2,
                    false
            );

        b2.addStatistic(0, "Weight", 65.0, "Tonnes");
        b2.addStatistic(1, "Length", 9.04, "Meters(hull length)");
        b2.addStatistic(2, "Height", 2.66, "Meters(to top)");
        b2.addStatistic(3, "Power/Weight", 23.1, "Hp/Tonne");
        b2.addStatistic(4, "Autonomy", 500, "km");
        b2.addStatistic(5, "Speed", 64, "km/h");

            cards.add(b2);

            // B3
            CardInfo b3 = new CardInfo(
                    "B3",
                    "Schützenpanzer Puma",
                    "Infantry fighting vehicle",
                    R.drawable.tanks_b3,
                    'B',
                    3,
                    false
            );

        b3.addStatistic(0, "Weight", 31.45, "Tonnes");
        b3.addStatistic(1, "Length", 7.60, "Meters(hull length)");
        b3.addStatistic(2, "Height", 3.05, "Meters(to top)");
        b3.addStatistic(3, "Power/Weight", 34.3, "Hp/Tonne");
        b3.addStatistic(4, "Autonomy", 600, "km");
        b3.addStatistic(5, "Speed", 70, "km/h");

            cards.add(b3);

            // B4
            CardInfo b4 = new CardInfo(
                    "B4",
                    " FV4201 Chieftain",
                    "Main battle tank",
                    R.drawable.tanks_b4,
                    'B',
                    4,
                    false
            );

        b4.addStatistic(0, "Weight", 55.0, "Tonnes");
        b4.addStatistic(1, "Length", 7.52, "Meters(hull length)");
        b4.addStatistic(2, "Height", 2.89, "Meters(to top)");
        b4.addStatistic(3, "Power/Weight", 13.5, "Hp/Tonne");
        b4.addStatistic(4, "Autonomy", 400, "km");
        b4.addStatistic(5, "Speed", 48, "km/h");

            cards.add(b4);


            // =========================
            // C
            // =========================

            // C1
            CardInfo c1 = new CardInfo(
                    "C1",
                    "FV4030/4 Challenger 1",
                    "Main Battle tank",
                    R.drawable.tanks_c1,
                    'C',
                    1,
                    false
            );

        c1.addStatistic(0, "Weight", 62.0, "Tonnes");
        c1.addStatistic(1, "Length", 8.32, "Meters(hull length)");
        c1.addStatistic(2, "Height", 2.95, "Meters(to top)");
        c1.addStatistic(3, "Power/Weight", 19.4, "Hp/Tonne");
        c1.addStatistic(4, "Autonomy", 450, "km");
        c1.addStatistic(5, "Speed", 56, "km/h");

            cards.add(c1);

            // C2
            CardInfo c2 = new CardInfo(
                    "C2",
                    "M48 Patton",
                    "First-generation MB",
                    R.drawable.tanks_c2,
                    'C',
                    2,
                    false
            );

        c2.addStatistic(0, "Weight", 49.6, "Tonnes");
        c2.addStatistic(1, "Length", 6.88, "Meters(hull length)");
        c2.addStatistic(2, "Height", 3.10, "Meters(to top)");
        c2.addStatistic(3, "Power/Weight", 16.5, "Hp/Tonne");
        c2.addStatistic(4, "Autonomy", 460, "km");
        c2.addStatistic(5, "Speed", 45, "km/h");

            cards.add(c2);

            // C3
            CardInfo c3 = new CardInfo(
                    "C3",
                    "M48 Patton",
                    "Infantry fighting vehicle ",
                    R.drawable.tanks_c3,
                    'C',
                    3,
                    false
            );

        c3.addStatistic(0, "Weight", 14.2, "Tonnes");
        c3.addStatistic(1, "Length", 5.88, "Meters(hull length)");
        c3.addStatistic(2, "Height", 2.84, "Meters(to top)");
        c3.addStatistic(3, "Power/Weight", 19.7, "Hp/Tonne");
        c3.addStatistic(4, "Autonomy", 600, "km");
        c3.addStatistic(5, "Speed", 65, "km/h");

            cards.add(c3);

            // C4
            CardInfo c4 = new CardInfo(
                    "C4",
                    "Combat Vehicle 90 (CV90)",
                    " Tracked armoured combat vehicle",
                    R.drawable.tanks_c4,
                    'C',
                    4,
                    false
            );

        c4.addStatistic(0, "Weight", 35.0, "Tonnes");
        c4.addStatistic(1, "Length", 6.55, "Meters(hull length)");
        c4.addStatistic(2, "Height", 2.71, "Meters(to top)");
        c4.addStatistic(3, "Power/Weight", 27.1, "Hp/Tonne");
        c4.addStatistic(4, "Autonomy", 900, "km");
        c4.addStatistic(5, "Speed", 70, "km/h");

            cards.add(c4);


            // =========================
            // D
            // =========================

            // D1
            CardInfo d1 = new CardInfo(
                    "D1",
                    "K2 Black Panther ",
                    "Main Battle tank",
                    R.drawable.tanks_d1,
                    'D',
                    1,
                    false
            );

        d1.addStatistic(0, "Weight", 55.0, "Tonnes");
        d1.addStatistic(1, "Length", 10.83, "Meters(with gun forward)");
        d1.addStatistic(2, "Height", 2.22, "Meters(to top)");
        d1.addStatistic(3, "Power/Weight", 27.3, "Hp/Tonne");
        d1.addStatistic(4, "Autonomy", 450, "km");
        d1.addStatistic(5, "Speed", 70, "km/h");

            cards.add(d1);

            // D2
            CardInfo d2 = new CardInfo(
                    "D2",
                    "Type 99",
                    "Main Battle tank",
                    R.drawable.tanks_d2,
                    'D',
                    2,
                    false
            );

        d2.addStatistic(0, "Weight", 54.0, "Tonnes");
        d2.addStatistic(1, "Length", 11.0, "Meters(with gun forward)");
        d2.addStatistic(2, "Height", 2.4, "Meters(to top)");
        d2.addStatistic(3, "Power/Weight", 22.2, "Hp/Tonne");
        d2.addStatistic(4, "Autonomy", 450, "km");
        d2.addStatistic(5, "Speed", 80, "km/h");

            cards.add(d2);

            // D3
            CardInfo d3 = new CardInfo(
                    "D3",
                    "FV4034 Challenger 2",
                    "Main Battle tank",
                    R.drawable.tanks_d3,
                    'D',
                    3,
                    false
            );

        d3.addStatistic(0, "Weight", 75.0, "Tonnes");
        d3.addStatistic(1, "Length", 11.55, "Meters(with gun forward)");
        d3.addStatistic(2, "Height", 2.50, "Meters(to top)");
        d3.addStatistic(3, "Power/Weight", 16.0, "Hp/Tonne");
        d3.addStatistic(4, "Autonomy", 550, "km");
        d3.addStatistic(5, "Speed", 59, "km/h");

            cards.add(d3);

            // D4
            CardInfo d4 = new CardInfo(
                    "D4",
                    "Kurganets-25",
                    "Amphibious infantry fighting vehicle ",
                    R.drawable.tanks_d4,
                    'D',
                    4,
                    false
            );

        d4.addStatistic(0, "Weight", 25.0, "Tonnes");
        d4.addStatistic(1, "Length", 7.2, "Meters(hull length)");
        d4.addStatistic(2, "Height", 3.0, "Meters(to top)");
        d4.addStatistic(3, "Power/Weight", 32.0, "Hp/Tonne");
        d4.addStatistic(4, "Autonomy", 500, "km");
        d4.addStatistic(5, "Speed", 80, "km/h");

            cards.add(d4);


            // =========================
            // E
            // =========================

            // E1
            CardInfo e1 = new CardInfo(
                    "E1",
                    "BMP-3",
                    "Infantry fighting vehicle",
                    R.drawable.tanks_e1,
                    'E',
                    1,
                    false
            );

        e1.addStatistic(0, "Weight", 18.7, "Tonnes");
        e1.addStatistic(1, "Length", 7.14, "Meters(hull length)");
        e1.addStatistic(2, "Height", 2.45, "Meters(to top)");
        e1.addStatistic(3, "Power/Weight", 26.7, "Hp/Tonne");
        e1.addStatistic(4, "Autonomy", 600, "km");
        e1.addStatistic(5, "Speed", 70, "km/h");

            cards.add(e1);

            // E2
            CardInfo e2 = new CardInfo(
                    "E2",
                    "M1 Abrams",
                    "Main Battle tank",
                    R.drawable.tanks_e2,
                    'E',
                    2,
                    false
            );

        e2.addStatistic(0, "Weight", 66.8, "Tonnes");
        e2.addStatistic(1, "Length", 9.77, "Meters(with gun forward)");
        e2.addStatistic(2, "Height", 2.44, "Meters(to top)");
        e2.addStatistic(3, "Power/Weight", 22.5, "Hp/Tonne");
        e2.addStatistic(4, "Autonomy", 426, "km");
        e2.addStatistic(5, "Speed", 67, "km/h");

            cards.add(e2);

            // E3
            CardInfo e3 = new CardInfo(
                    "E3",
                    "Kampfpanzer Leopard 1",
                    "Main Battle tank",
                    R.drawable.tanks_e3,
                    'E',
                    3,
                    false
            );

        e3.addStatistic(0, "Weight", 42.2, "Tonnes");
        e3.addStatistic(1, "Length", 9.54, "Meters(with gun forward)");
        e3.addStatistic(2, "Height", 2.61, "Meters(to top)");
        e3.addStatistic(3, "Power/Weight", 19.9, "Hp/Tonne");
        e3.addStatistic(4, "Autonomy", 600, "km");
        e3.addStatistic(5, "Speed", 65, "km/h");

            cards.add(e3);

            // E4
            CardInfo e4 = new CardInfo(
                    "E4",
                    "C1 Ariete",
                    "Main Battle tank",
                    R.drawable.tanks_e4,
                    'E',
                    4,
                    false
            );

        e4.addStatistic(0, "Weight", 54.0, "Tonnes");
        e4.addStatistic(1, "Length", 9.67, "Meters(with gun forward)");
        e4.addStatistic(2, "Height", 2.51, "Meters(to top)");
        e4.addStatistic(3, "Power/Weight", 23.5, "Hp/Tonne");
        e4.addStatistic(4, "Autonomy", 550, "km");
        e4.addStatistic(5, "Speed", 65, "km/h");

            cards.add(e4);


            // =========================
            // F
            // =========================

            // F1
            CardInfo f1 = new CardInfo(
                    "F1",
                    "T-72",
                    "Main Battle tank",
                    R.drawable.tanks_f1,
                    'F',
                    1,
                    false
            );

        f1.addStatistic(0, "Weight", 41.5, "Tonnes");
        f1.addStatistic(1, "Length", 9.53, "Meters(with gun forward)");
        f1.addStatistic(2, "Height", 2.19, "Meters(to top)");
        f1.addStatistic(3, "Power/Weight", 18.8, "Hp/Tonne");
        f1.addStatistic(4, "Autonomy", 500, "km");
        f1.addStatistic(5, "Speed", 60, "km/h");

            cards.add(f1);

            // F2
            CardInfo f2 = new CardInfo(
                    "F2",
                    " ASCOD",
                    "Armoured fighting vehicle",
                    R.drawable.tanks_f2,
                    'F',
                    2,
                    false
            );

        f2.addStatistic(0, "Weight", 28.0, "Tonnes");
        f2.addStatistic(1, "Length", 6.83, "Meters(hull length)");
        f2.addStatistic(2, "Height", 2.45, "Meters(to top)");
        f2.addStatistic(3, "Power/Weight", 25.7, "Hp/Tonne");
        f2.addStatistic(4, "Autonomy", 500, "km");
        f2.addStatistic(5, "Speed", 72, "km/h");

            cards.add(f2);

            // F3
            CardInfo f3 = new CardInfo(
                    "F3",
                    "T-90",
                    "Main Battle tank",
                    R.drawable.tanks_f3,
                    'F',
                    3,
                    true
            );

        f3.addStatistic(0, "Weight", 46.5, "Tonnes");
        f3.addStatistic(1, "Length", 9.53, "Meters(with gun forward)");
        f3.addStatistic(2, "Height", 2.22, "Meters(to top)");
        f3.addStatistic(3, "Power/Weight", 21.5, "Hp/Tonne");
        f3.addStatistic(4, "Autonomy", 550, "km");
        f3.addStatistic(5, "Speed", 60, "km/h");

            cards.add(f3);

            // F4
            CardInfo f4 = new CardInfo(
                    "F4",
                    "T-80",
                    "Main Battle tank",
                    R.drawable.tanks_f4,
                    'F',
                    4,
                    false
            );

        f4.addStatistic(0, "Weight", 46.0, "Tonnes");
        f4.addStatistic(1, "Length", 9.56, "Meters(with gun forward)");
        f4.addStatistic(2, "Height", 2.21, "Meters(to top)");
        f4.addStatistic(3, "Power/Weight", 27.2, "Hp/Tonne");
        f4.addStatistic(4, "Autonomy", 400, "km");
        f4.addStatistic(5, "Speed", 70, "km/h");

            cards.add(f4);


            // =========================
            // G
            // =========================

            // G1
            CardInfo g1 = new CardInfo(
                    "G1",
                    "LAV-25",
                    "Light armored vehicle",
                    R.drawable.tanks_g1,
                    'G',
                    1,
                    false
            );

        g1.addStatistic(0, "Weight", 12.8, "Tonnes");
        g1.addStatistic(1, "Length", 6.39, "Meters(hull length)");
        g1.addStatistic(2, "Height", 2.69, "Meters(to top)");
        g1.addStatistic(3, "Power/Weight", 21.5, "Hp/Tonne");
        g1.addStatistic(4, "Autonomy", 668, "km");
        g1.addStatistic(5, "Speed", 100, "km/h");

            cards.add(g1);

            // G2
            CardInfo g2 = new CardInfo(
                    "G2",
                    "Type 10",
                    "Main battle tank",
                    R.drawable.tanks_g2,
                    'G',
                    2,
                    false
            );

        g2.addStatistic(0, "Weight", 44.0, "Tonnes");
        g2.addStatistic(1, "Length", 9.48, "Meters(with gun forward)");
        g2.addStatistic(2, "Height", 2.30, "Meters(to top)");
        g2.addStatistic(3, "Power/Weight", 27.3, "Hp/Tonne");
        g2.addStatistic(4, "Autonomy", 500, "km");
        g2.addStatistic(5, "Speed", 70, "km/h");

            cards.add(g2);

            // G3
            CardInfo g3 = new CardInfo(
                    "G3",
                    "BMP-1",
                    " Amphibious tracked infantry fighting vehicle",
                    R.drawable.tanks_g3,
                    'G',
                    3,
                    false
            );

        g3.addStatistic(0, "Weight", 13.2, "Tonnes");
        g3.addStatistic(1, "Length", 6.74, "Meters(hull length)");
        g3.addStatistic(2, "Height", 2.06, "Meters(to top)");
        g3.addStatistic(3, "Power/Weight", 22.7, "Hp/Tonne");
        g3.addStatistic(4, "Autonomy", 600, "km");
        g3.addStatistic(5, "Speed", 65, "km/h");

            cards.add(g3);

            // G4
            CardInfo g4 = new CardInfo(
                    "G4",
                    "Type 96",
                    "Main Battle tank",
                    R.drawable.tanks_g4,
                    'G',
                    4,
                    false
            );

        g4.addStatistic(0, "Weight", 42.8, "Tonnes");
        g4.addStatistic(1, "Length", 10.28, "Meters(with gun forward)");
        g4.addStatistic(2, "Height", 2.30, "Meters(to top)");
        g4.addStatistic(3, "Power/Weight", 18.2, "Hp/Tonne");
        g4.addStatistic(4, "Autonomy", 400, "km");
        g4.addStatistic(5, "Speed", 65, "km/h");

            cards.add(g4);


            // =========================
            // H
            // =========================

            // H1
            CardInfo h1 = new CardInfo(
                    "H1",
                    "Leclerc",
                    "Main Battle tank",
                    R.drawable.tanks_h1,
                    'H',
                    1,
                    false
            );

        h1.addStatistic(0, "Weight", 57.4, "Tonnes");
        h1.addStatistic(1, "Length", 9.87, "Meters(with gun forward)");
        h1.addStatistic(2, "Height", 2.53, "Meters(to top)");
        h1.addStatistic(3, "Power/Weight", 26.5, "Hp/Tonne");
        h1.addStatistic(4, "Autonomy", 550, "km");
        h1.addStatistic(5, "Speed", 71, "km/h");

            cards.add(h1);

            // H2
            CardInfo h2 = new CardInfo(
                    "H2",
                    "T-90",
                    "Main Battle tank",
                    R.drawable.tanks_h2,
                    'H',
                    2,
                    false
            );

        h2.addStatistic(0, "Weight", 46.5, "Tonnes");
        h2.addStatistic(1, "Length", 9.53, "Meters(with gun forward)");
        h2.addStatistic(2, "Height", 2.22, "Meters(to top)");
        h2.addStatistic(3, "Power/Weight", 21.5, "Hp/Tonne");
        h2.addStatistic(4, "Autonomy", 550, "km");
        h2.addStatistic(5, "Speed", 60, "km/h");

            cards.add(h2);

            // H3
            CardInfo h3 = new CardInfo(
                    "H3",
                    "VBCI",
                    "Armoured infantry fighting vehicle",
                    R.drawable.tanks_h3,
                    'H',
                    3,
                    false
            );

        h3.addStatistic(0, "Weight", 25.6, "Tonnes");
        h3.addStatistic(1, "Length", 8.31, "Meters(hull length)");
        h3.addStatistic(2, "Height", 3.00, "Meters(to top)");
        h3.addStatistic(3, "Power/Weight", 21.5, "Hp/Tonne");
        h3.addStatistic(4, "Autonomy", 750, "km");
        h3.addStatistic(5, "Speed", 100, "km/h");

            cards.add(h3);

            // H4
            CardInfo h4 = new CardInfo(
                    "H4",
                    "ΑΜΧ-30",
                    "Main Battle tank",
                    R.drawable.tanks_h4,
                    'H',
                    4,
                    false
            );

            h4.addStatistic(0, "Weight", 036, "Tonnes");
            h4.addStatistic(1, "Length", 9.48, "Meters(hull length)");
            h4.addStatistic(2, "Height", 2.28, "Meters(to top)");
            h4.addStatistic(3, "Power/Weight", 2.28, "Hp/Tonne");
            h4.addStatistic(4, "Autonomy", 600, "km");
            h4.addStatistic(5, "Speed", 100, "km/h");

            cards.add(h4);
        }

        public List<CardInfo> getCards() {
            return cards;
        }

        public void shuffle() {
            Collections.shuffle(cards);
        }
    }










