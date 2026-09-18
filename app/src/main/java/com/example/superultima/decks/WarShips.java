package com.example.superultima.decks;

import com.example.superultima.R;
import com.example.superultima.cardgame.CardInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WarShips {
    private final List<CardInfo> cards = new ArrayList<>();

    public WarShips() {
        // =========================
// A
// =========================

// A1
        CardInfo a1 = new CardInfo(
                "A1",
                "Ford class",
                "AIRCRAFT CARRIER",
                R.drawable.warships_a1,
                'A',
                1,
                false
        );

        a1.addStatistic(0, "DISPLACEMENT", 100000, "tn");
        a1.addStatistic(1, "LENGTH", 333, "m");
        a1.addStatistic(2, "WEAPON RANGE", 50, "km");
        a1.addStatistic(3, "CREW", 2600, "people");
        a1.addStatistic(4, "OPERATIONAL RANGE", 99999, "nm");
        a1.addStatistic(5, "SPEED", 30, "knots");

        cards.add(a1);

// A2
        CardInfo a2 = new CardInfo(
                "A2",
                "Queen Elizabeth",
                "AIRCRAFT CARRIER",
                R.drawable.warships_a2,
                'A',
                2,
                false
        );

        a2.addStatistic(0, "DISPLACEMENT", 80600, "tn");
        a2.addStatistic(1, "LENGTH", 284, "m");
        a2.addStatistic(2, "WEAPON RANGE", 25, "km");
        a2.addStatistic(3, "CREW", 679, "people");
        a2.addStatistic(4, "OPERATIONAL RANGE", 10000, "nm");
        a2.addStatistic(5, "SPEED", 25, "knots");

        cards.add(a2);

// A3
        CardInfo a3 = new CardInfo(
                "A3",
                "Charles de Gaulle",
                "AIRCRAFT CARRIER",
                R.drawable.warships_a3,
                'A',
                3,
                false
        );

        a3.addStatistic(0, "DISPLACEMENT", 42500, "tn");
        a3.addStatistic(1, "LENGTH", 261.5, "m");
        a3.addStatistic(2, "WEAPON RANGE", 30, "km");
        a3.addStatistic(3, "CREW", 1350, "people");
        a3.addStatistic(4, "OPERATIONAL RANGE", 99999, "nm");
        a3.addStatistic(5, "SPEED", 27, "knots");

        cards.add(a3);

// A4
        CardInfo a4 = new CardInfo(
                "A4",
                "Ticonderoga",
                "CRUISER",
                R.drawable.warships_a4,
                'A',
                4,
                false
        );

        a4.addStatistic(0, "DISPLACEMENT", 9800, "tn");
        a4.addStatistic(1, "LENGTH", 173, "m");
        a4.addStatistic(2, "WEAPON RANGE", 167, "km");
        a4.addStatistic(3, "CREW", 387, "people");
        a4.addStatistic(4, "OPERATIONAL RANGE", 6000, "nm");
        a4.addStatistic(5, "SPEED", 32.5, "knots");

        cards.add(a4);


// =========================
// B
// =========================

// B1
        CardInfo b1 = new CardInfo(
                "B1",
                "Slava",
                "CRUISER",
                R.drawable.warships_b1,
                'B',
                1,
                false
        );

        b1.addStatistic(0, "DISPLACEMENT", 11490, "tn");
        b1.addStatistic(1, "LENGTH", 186.4, "m");
        b1.addStatistic(2, "WEAPON RANGE", 550, "km");
        b1.addStatistic(3, "CREW", 485, "people");
        b1.addStatistic(4, "OPERATIONAL RANGE", 6800, "nm");
        b1.addStatistic(5, "SPEED", 32, "knots");

        cards.add(b1);

// B2
        CardInfo b2 = new CardInfo(
                "B2",
                "Zumwalt",
                "DESTROYER",
                R.drawable.warships_b2,
                'B',
                2,
                false
        );

        b2.addStatistic(0, "DISPLACEMENT", 15995, "tn");
        b2.addStatistic(1, "LENGTH", 182.9, "m");
        b2.addStatistic(2, "WEAPON RANGE", 1670, "km");
        b2.addStatistic(3, "CREW", 142, "people");
        b2.addStatistic(4, "OPERATIONAL RANGE", 4500, "nm");
        b2.addStatistic(5, "SPEED", 33.5, "knots");

        cards.add(b2);

// B3
        CardInfo b3 = new CardInfo(
                "B3",
                "Sejong the Great Destroyer",
                "DESTROYER",
                R.drawable.warships_b3,
                'B',
                3,
                false
        );

        b3.addStatistic(0, "DISPLACEMENT", 10000, "tn");
        b3.addStatistic(1, "LENGTH", 166, "m");
        b3.addStatistic(2, "WEAPON RANGE", 167, "km");
        b3.addStatistic(3, "CREW", 300, "people");
        b3.addStatistic(4, "OPERATIONAL RANGE", 5500, "nm");
        b3.addStatistic(5, "SPEED", 30, "knots");

        cards.add(b3);

// B4
        CardInfo b4 = new CardInfo(
                "B4",
                "Arleigh Burke",
                "DESTROYER",
                R.drawable.warships_b4,
                'B',
                4,
                false
        );

        b4.addStatistic(0, "DISPLACEMENT", 9700, "tn");
        b4.addStatistic(1, "LENGTH", 155.3, "m");
        b4.addStatistic(2, "WEAPON RANGE", 240, "km");
        b4.addStatistic(3, "CREW", 323, "people");
        b4.addStatistic(4, "OPERATIONAL RANGE", 4400, "nm");
        b4.addStatistic(5, "SPEED", 31, "knots");

        cards.add(b4);


// =========================
// C
// =========================

// C1
        CardInfo c1 = new CardInfo(
                "C1",
                "Type 055",
                "DESTROYER",
                R.drawable.warships_c1,
                'C',
                1,
                false
        );

        c1.addStatistic(0, "DISPLACEMENT", 12000, "tn");
        c1.addStatistic(1, "LENGTH", 180, "m");
        c1.addStatistic(2, "WEAPON RANGE", 540, "km");
        c1.addStatistic(3, "CREW", 300, "people");
        c1.addStatistic(4, "OPERATIONAL RANGE", 5000, "nm");
        c1.addStatistic(5, "SPEED", 30, "knots");

        cards.add(c1);

// C2
        CardInfo c2 = new CardInfo(
                "C2",
                "Type 45",
                "DESTROYER",
                R.drawable.warships_c2,
                'C',
                2,
                false
        );

        c2.addStatistic(0, "DISPLACEMENT", 8500, "tn");
        c2.addStatistic(1, "LENGTH", 152.4, "m");
        c2.addStatistic(2, "WEAPON RANGE", 120, "km");
        c2.addStatistic(3, "CREW", 191, "people");
        c2.addStatistic(4, "OPERATIONAL RANGE", 7000, "nm");
        c2.addStatistic(5, "SPEED", 32, "knots");

        cards.add(c2);

// C3
        CardInfo c3 = new CardInfo(
                "C3",
                "Horizon",
                "DESTROYER",
                R.drawable.warships_c3,
                'C',
                3,
                false
        );

        c3.addStatistic(0, "DISPLACEMENT", 7050, "tn");
        c3.addStatistic(1, "LENGTH", 152.87, "m");
        c3.addStatistic(2, "WEAPON RANGE", 180, "km");
        c3.addStatistic(3, "CREW", 236, "people");
        c3.addStatistic(4, "OPERATIONAL RANGE", 6100, "nm");
        c3.addStatistic(5, "SPEED", 29, "knots");

        cards.add(c3);

// C4
        CardInfo c4 = new CardInfo(
                "C4",
                "Sovremenny",
                "DESTROYER",
                R.drawable.warships_c4,
                'C',
                4,
                false
        );

        c4.addStatistic(0, "DISPLACEMENT", 7940, "tn");
        c4.addStatistic(1, "LENGTH", 156.5, "m");
        c4.addStatistic(2, "WEAPON RANGE", 120, "km");
        c4.addStatistic(3, "CREW", 350, "people");
        c4.addStatistic(4, "OPERATIONAL RANGE", 4344.88, "nm");
        c4.addStatistic(5, "SPEED", 32, "knots");

        cards.add(c4);


// =========================
// D
// =========================

// D1
        CardInfo d1 = new CardInfo(
                "D1",
                "Sachsen",
                "FRIGATE",
                R.drawable.warships_d1,
                'D',
                1,
                false
        );

        d1.addStatistic(0, "DISPLACEMENT", 5800, "tn");
        d1.addStatistic(1, "LENGTH", 143, "m");
        d1.addStatistic(2, "WEAPON RANGE", 167, "km");
        d1.addStatistic(3, "CREW", 230, "people");
        d1.addStatistic(4, "OPERATIONAL RANGE", 4000, "nm");
        d1.addStatistic(5, "SPEED", 29, "knots");

        cards.add(d1);

// D2
        CardInfo d2 = new CardInfo(
                "D2",
                "Aquitaine",
                "FRIGATE",
                R.drawable.warships_d2,
                'D',
                2,
                false
        );

        d2.addStatistic(0, "DISPLACEMENT", 6000, "tn");
        d2.addStatistic(1, "LENGTH", 142, "m");
        d2.addStatistic(2, "WEAPON RANGE", 180, "km");
        d2.addStatistic(3, "CREW", 145, "people");
        d2.addStatistic(4, "OPERATIONAL RANGE", 6000, "nm");
        d2.addStatistic(5, "SPEED", 27, "knots");

        cards.add(d2);

// D3
        CardInfo d3 = new CardInfo(
                "D3",
                "Alvaro de Bazan",
                "FRIGATE",
                R.drawable.warships_d3,
                'D',
                3,
                false
        );

        d3.addStatistic(0, "DISPLACEMENT", 6391, "tn");
        d3.addStatistic(1, "LENGTH", 146.7, "m");
        d3.addStatistic(2, "WEAPON RANGE", 167, "km");
        d3.addStatistic(3, "CREW", 250, "people");
        d3.addStatistic(4, "OPERATIONAL RANGE", 4500, "nm");
        d3.addStatistic(5, "SPEED", 28.5, "knots");

        cards.add(d3);

// D4
        CardInfo d4 = new CardInfo(
                "D4",
                "De Zeven Provincien",
                "FRIGATE",
                R.drawable.warships_d4,
                'D',
                4,
                false
        );

        d4.addStatistic(0, "DISPLACEMENT", 6050, "tn");
        d4.addStatistic(1, "LENGTH", 144.24, "m");
        d4.addStatistic(2, "WEAPON RANGE", 167, "km");
        d4.addStatistic(3, "CREW", 232, "people");
        d4.addStatistic(4, "OPERATIONAL RANGE", 4000, "nm");
        d4.addStatistic(5, "SPEED", 30, "knots");

        cards.add(d4);


// =========================
// E
// =========================

// E1
        CardInfo e1 = new CardInfo(
                "E1",
                "Admiral Gorshkov",
                "FRIGATE",
                R.drawable.warships_e1,
                'E',
                1,
                false
        );

        e1.addStatistic(0, "DISPLACEMENT", 5400, "tn");
        e1.addStatistic(1, "LENGTH", 135, "m");
        e1.addStatistic(2, "WEAPON RANGE", 450, "km");
        e1.addStatistic(3, "CREW", 210, "people");
        e1.addStatistic(4, "OPERATIONAL RANGE", 4000, "nm");
        e1.addStatistic(5, "SPEED", 29.5, "knots");

        cards.add(e1);

// E2
        CardInfo e2 = new CardInfo(
                "E2",
                "Freedom",
                "LITTORAL COMBAT SHIP",
                R.drawable.warships_e2,
                'E',
                2,
                false
        );

        e2.addStatistic(0, "DISPLACEMENT", 3500, "tn");
        e2.addStatistic(1, "LENGTH", 115.3, "m");
        e2.addStatistic(2, "WEAPON RANGE", 185, "km");
        e2.addStatistic(3, "CREW", 50, "people");
        e2.addStatistic(4, "OPERATIONAL RANGE", 3500, "nm");
        e2.addStatistic(5, "SPEED", 47, "knots");

        cards.add(e2);

// E3
        CardInfo e3 = new CardInfo(
                "E3",
                "Iver Huitfeldt",
                "FRIGATE",
                R.drawable.warships_e3,
                'E',
                3,
                false
        );

        e3.addStatistic(0, "DISPLACEMENT", 6645, "tn");
        e3.addStatistic(1, "LENGTH", 138.7, "m");
        e3.addStatistic(2, "WEAPON RANGE", 167, "km");
        e3.addStatistic(3, "CREW", 165, "people");
        e3.addStatistic(4, "OPERATIONAL RANGE", 9000, "nm");
        e3.addStatistic(5, "SPEED", 28, "knots");

        cards.add(e3);

// E4
        CardInfo e4 = new CardInfo(
                "E4",
                "Type 23",
                "FRIGATE",
                R.drawable.warships_e4,
                'E',
                4,
                false
        );

        e4.addStatistic(0, "DISPLACEMENT", 4900, "tn");
        e4.addStatistic(1, "LENGTH", 133, "m");
        e4.addStatistic(2, "WEAPON RANGE", 25, "km");
        e4.addStatistic(3, "CREW", 185, "people");
        e4.addStatistic(4, "OPERATIONAL RANGE", 7500, "nm");
        e4.addStatistic(5, "SPEED", 28, "knots");

        cards.add(e4);


// =========================
// F
// =========================

// F1
        CardInfo f1 = new CardInfo(
                "F1",
                "F123 Brandenburg",
                "FRIGATE",
                R.drawable.warships_f1,
                'F',
                1,
                false
        );

        f1.addStatistic(0, "DISPLACEMENT", 4490, "tn");
        f1.addStatistic(1, "LENGTH", 138.85, "m");
        f1.addStatistic(2, "WEAPON RANGE", 124, "km");
        f1.addStatistic(3, "CREW", 219, "people");
        f1.addStatistic(4, "OPERATIONAL RANGE", 4000, "nm");
        f1.addStatistic(5, "SPEED", 29, "knots");

        cards.add(f1);

// F2
        CardInfo f2 = new CardInfo(
                "F2",
                "Oliver Hazard Perry",
                "FRIGATE",
                R.drawable.warships_f2,
                'F',
                2,
                false
        );

        f2.addStatistic(0, "DISPLACEMENT", 4100, "tn");
        f2.addStatistic(1, "LENGTH", 136, "m");
        f2.addStatistic(2, "WEAPON RANGE", 124, "km");
        f2.addStatistic(3, "CREW", 176, "people");
        f2.addStatistic(4, "OPERATIONAL RANGE", 4500, "nm");
        f2.addStatistic(5, "SPEED", 30, "knots");

        cards.add(f2);

// F3
        CardInfo f3 = new CardInfo(
                "F3",
                "MEKO 200",
                "FRIGATE",
                R.drawable.warships_f3,
                'F',
                3,
                false
        );

        f3.addStatistic(0, "DISPLACEMENT", 3400, "tn");
        f3.addStatistic(1, "LENGTH", 118, "m");
        f3.addStatistic(2, "WEAPON RANGE", 124, "km");
        f3.addStatistic(3, "CREW", 220, "people");
        f3.addStatistic(4, "OPERATIONAL RANGE", 6000, "nm");
        f3.addStatistic(5, "SPEED", 32, "knots");

        cards.add(f3);

// F4
        CardInfo f4 = new CardInfo(
                "F4",
                "Elli / Kortenaer",
                "FRIGATE",
                R.drawable.warships_f4,
                'F',
                4,
                true
        );

        f4.addStatistic(0, "DISPLACEMENT", 3800, "tn");
        f4.addStatistic(1, "LENGTH", 130.5, "m");
        f4.addStatistic(2, "WEAPON RANGE", 124, "km");
        f4.addStatistic(3, "CREW", 198, "people");
        f4.addStatistic(4, "OPERATIONAL RANGE", 4700, "nm");
        f4.addStatistic(5, "SPEED", 30, "knots");

        cards.add(f4);


// =========================
// G
// =========================

// G1
        CardInfo g1 = new CardInfo(
                "G1",
                "Gowind 2500",
                "CORVETTE",
                R.drawable.warships_g1,
                'G',
                1,
                false
        );

        g1.addStatistic(0, "DISPLACEMENT", 2500, "tn");
        g1.addStatistic(1, "LENGTH", 102, "m");
        g1.addStatistic(2, "WEAPON RANGE", 200, "km");
        g1.addStatistic(3, "CREW", 65, "people");
        g1.addStatistic(4, "OPERATIONAL RANGE", 3700, "nm");
        g1.addStatistic(5, "SPEED", 28, "knots");

        cards.add(g1);

// G2
        CardInfo g2 = new CardInfo(
                "G2",
                "Braunschweig K130",
                "CORVETTE",
                R.drawable.warships_g2,
                'G',
                2,
                false
        );

        g2.addStatistic(0, "DISPLACEMENT", 1840, "tn");
        g2.addStatistic(1, "LENGTH", 89.12, "m");
        g2.addStatistic(2, "WEAPON RANGE", 200, "km");
        g2.addStatistic(3, "CREW", 65, "people");
        g2.addStatistic(4, "OPERATIONAL RANGE", 4000, "nm");
        g2.addStatistic(5, "SPEED", 26, "knots");

        cards.add(g2);

// G3
        CardInfo g3 = new CardInfo(
                "G3",
                "Saar 5",
                "CORVETTE",
                R.drawable.warships_g3,
                'G',
                3,
                false
        );

        g3.addStatistic(0, "DISPLACEMENT", 1275, "tn");
        g3.addStatistic(1, "LENGTH", 85.64, "m");
        g3.addStatistic(2, "WEAPON RANGE", 200, "km");
        g3.addStatistic(3, "CREW", 64, "people");
        g3.addStatistic(4, "OPERATIONAL RANGE", 3500, "nm");
        g3.addStatistic(5, "SPEED", 33, "knots");

        cards.add(g3);

// G4
        CardInfo g4 = new CardInfo(
                "G4",
                "Visby",
                "CORVETTE",
                R.drawable.warships_g4,
                'G',
                4,
                false
        );

        g4.addStatistic(0, "DISPLACEMENT", 640, "tn");
        g4.addStatistic(1, "LENGTH", 72.7, "m");
        g4.addStatistic(2, "WEAPON RANGE", 200, "km");
        g4.addStatistic(3, "CREW", 43, "people");
        g4.addStatistic(4, "OPERATIONAL RANGE", 2500, "nm");
        g4.addStatistic(5, "SPEED", 35, "knots");

        cards.add(g4);


// =========================
// H
// =========================

// H1
        CardInfo h1 = new CardInfo(
                "H1",
                "Super Vita",
                "MISSILE BOAT",
                R.drawable.warships_h1,
                'H',
                1,
                false
        );

        h1.addStatistic(0, "DISPLACEMENT", 668, "tn");
        h1.addStatistic(1, "LENGTH", 61.9, "m");
        h1.addStatistic(2, "WEAPON RANGE", 180, "km");
        h1.addStatistic(3, "CREW", 45, "people");
        h1.addStatistic(4, "OPERATIONAL RANGE", 2250, "nm");
        h1.addStatistic(5, "SPEED", 34.5, "knots");

        cards.add(h1);

// H2
        CardInfo h2 = new CardInfo(
                "H2",
                "Ambassador",
                "MISSILE BOAT",
                R.drawable.warships_h2,
                'H',
                2,
                false
        );

        h2.addStatistic(0, "DISPLACEMENT", 600, "tn");
        h2.addStatistic(1, "LENGTH", 63, "m");
        h2.addStatistic(2, "WEAPON RANGE", 124, "km");
        h2.addStatistic(3, "CREW", 36, "people");
        h2.addStatistic(4, "OPERATIONAL RANGE", 2000, "nm");
        h2.addStatistic(5, "SPEED", 41, "knots");

        cards.add(h2);

// H3
        CardInfo h3 = new CardInfo(
                "H3",
                "La Combattante 3",
                "MISSILE BOAT",
                R.drawable.warships_h3,
                'H',
                3,
                false
        );

        h3.addStatistic(0, "DISPLACEMENT", 359, "tn");
        h3.addStatistic(1, "LENGTH", 56.2, "m");
        h3.addStatistic(2, "WEAPON RANGE", 124, "km");
        h3.addStatistic(3, "CREW", 42, "people");
        h3.addStatistic(4, "OPERATIONAL RANGE", 2000, "nm");
        h3.addStatistic(5, "SPEED", 36.5, "knots");

        cards.add(h3);

// H4
        CardInfo h4 = new CardInfo(
                "H4",
                "Skjold",
                "CORVETTE",
                R.drawable.warships_h4,
                'H',
                4,
                false
        );

        h4.addStatistic(0, "DISPLACEMENT", 274, "tn");
        h4.addStatistic(1, "LENGTH", 47.5, "m");
        h4.addStatistic(2, "WEAPON RANGE", 185, "km");
        h4.addStatistic(3, "CREW", 15, "people");
        h4.addStatistic(4, "OPERATIONAL RANGE", 800, "nm");
        h4.addStatistic(5, "SPEED", 60, "knots");

        cards.add(h4);
    }
    public List<CardInfo> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);

    }
}

