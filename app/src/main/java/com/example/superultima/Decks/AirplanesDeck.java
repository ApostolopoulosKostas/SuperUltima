package com.example.superultima.Decks;

import com.example.superultima.CardInfo;
import com.example.superultima.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AirplanesDeck {

    private final List<CardInfo> cards = new ArrayList<>();

    public AirplanesDeck() {

        // =========================
        // A
        // =========================

        // A1
        CardInfo a1 = new CardInfo(
                "A1",
                "F-16 Fighting Falcon",
                "FIGHTER",
                R.drawable.airplanes_a1,
                'A',
                1,
                false
        );

        a1.addStatistic(0, "SPEED", 2414, "km/h");
        a1.addStatistic(1, "AUTONOMY", 3220, "km");
        a1.addStatistic(2, "WINGSPAN", 9.8, "m");
        a1.addStatistic(3, "LENGTH", 14.8, "m");
        a1.addStatistic(4, "WEIGHT", 16875, "kg");
        a1.addStatistic(5, "MAX HEIGHT", 15240, "m");

        cards.add(a1);

        // A2
        CardInfo a2 = new CardInfo(
                "A2",
                "Dassault Rafale C",
                "FIGHTER",
                R.drawable.airplanes_a2,
                'A',
                2,
                false
        );

        a2.addStatistic(0, "SPEED", 1390, "km/h");
        a2.addStatistic(1, "AUTONOMY", 3700, "km");
        a2.addStatistic(2, "WINGSPAN", 10.9, "m");
        a2.addStatistic(3, "LENGTH", 15.3, "m");
        a2.addStatistic(4, "WEIGHT", 24500, "kg");
        a2.addStatistic(5, "MAX HEIGHT", 15240, "m");

        cards.add(a2);

        // A3
        CardInfo a3 = new CardInfo(
                "A3",
                "Eurofighter EF 2000 Typhoon",
                "FIGHTER",
                R.drawable.airplanes_a3,
                'A',
                3,
                false
        );

        a3.addStatistic(0, "SPEED", 2495, "km/h");
        a3.addStatistic(1, "AUTONOMY", 3790, "km");
        a3.addStatistic(2, "WINGSPAN", 10.95, "m");
        a3.addStatistic(3, "LENGTH", 15.96, "m");
        a3.addStatistic(4, "WEIGHT", 23500, "kg");
        a3.addStatistic(5, "MAX HEIGHT", 16764, "m");

        cards.add(a3);

        // A4
        CardInfo a4 = new CardInfo(
                "A4",
                "F-22 Raptor",
                "FIGHTER",
                R.drawable.airplanes_a4,
                'A',
                4,
                true
        );

        a4.addStatistic(0, "SPEED", 2410, "km/h");
        a4.addStatistic(1, "AUTONOMY", 2960, "km");
        a4.addStatistic(2, "WINGSPAN", 13.6, "m");
        a4.addStatistic(3, "LENGTH", 18.9, "m");
        a4.addStatistic(4, "WEIGHT", 38000, "kg");
        a4.addStatistic(5, "MAX HEIGHT", 15240, "m");

        cards.add(a4);


        // =========================
        // B
        // =========================

        // B1
        CardInfo b1 = new CardInfo(
                "B1",
                "Dassault Mirage F1CR",
                "RECON",
                R.drawable.airplanes_b1,
                'B',
                1,
                false
        );

        b1.addStatistic(0, "SPEED", 2338, "km/h");
        b1.addStatistic(1, "AUTONOMY", 3300, "km");
        b1.addStatistic(2, "WINGSPAN", 8.4, "m");
        b1.addStatistic(3, "LENGTH", 15.3, "m");
        b1.addStatistic(4, "WEIGHT", 16500, "kg");
        b1.addStatistic(5, "MAX HEIGHT", 20000, "m");

        cards.add(b1);

        // B2
        CardInfo b2 = new CardInfo(
                "B2",
                "Grumman RQ-4 Global Hawk",
                "RECON",
                R.drawable.airplanes_b2,
                'B',
                2,
                false
        );

        b2.addStatistic(0, "SPEED", 629, "km/h");
        b2.addStatistic(1, "AUTONOMY", 22780, "km");
        b2.addStatistic(2, "WINGSPAN", 39.9, "m");
        b2.addStatistic(3, "LENGTH", 14.5, "m");
        b2.addStatistic(4, "WEIGHT", 14628, "kg");
        b2.addStatistic(5, "MAX HEIGHT", 18288, "m");

        cards.add(b2);

        // B3
        CardInfo b3 = new CardInfo(
                "B3",
                "Lockheed SR-71 Blackbird",
                "RECON",
                R.drawable.airplanes_b3,
                'B',
                3,
                false
        );

        b3.addStatistic(0, "SPEED", 3540, "km/h");
        b3.addStatistic(1, "AUTONOMY", 5400, "km");
        b3.addStatistic(2, "WINGSPAN", 16.94, "m");
        b3.addStatistic(3, "LENGTH", 32.74, "m");
        b3.addStatistic(4, "WEIGHT", 77111, "kg");
        b3.addStatistic(5, "MAX HEIGHT", 25900, "m");

        cards.add(b3);

        // B4
        CardInfo b4 = new CardInfo(
                "B4",
                "Lockheed U-2R",
                "RECON",
                R.drawable.airplanes_b4,
                'B',
                4,
                false
        );

        b4.addStatistic(0, "SPEED", 805, "km/h");
        b4.addStatistic(1, "AUTONOMY", 10300, "km");
        b4.addStatistic(2, "WINGSPAN", 31.39, "m");
        b4.addStatistic(3, "LENGTH", 19.2, "m");
        b4.addStatistic(4, "WEIGHT", 18143, "kg");
        b4.addStatistic(5, "MAX HEIGHT", 27430, "m");

        cards.add(b4);


        // =========================
        // C
        // =========================

        // C1
        CardInfo c1 = new CardInfo(
                "C1",
                "Aermacchi M-346",
                "TRAINER",
                R.drawable.airplanes_c1,
                'C',
                1,
                false
        );

        c1.addStatistic(0, "SPEED", 1255, "km/h");
        c1.addStatistic(1, "AUTONOMY", 2100, "km");
        c1.addStatistic(2, "WINGSPAN", 9.72, "m");
        c1.addStatistic(3, "LENGTH", 11.49, "m");
        c1.addStatistic(4, "WEIGHT", 9500, "kg");
        c1.addStatistic(5, "MAX HEIGHT", 13716, "m");

        cards.add(c1);

        // C2
        CardInfo c2 = new CardInfo(
                "C2",
                "T-2C Buckeye",
                "TRAINER",
                R.drawable.airplanes_c2,
                'C',
                2,
                false
        );

        c2.addStatistic(0, "SPEED", 840, "km/h");
        c2.addStatistic(1, "AUTONOMY", 1770, "km");
        c2.addStatistic(2, "WINGSPAN", 11.61, "m");
        c2.addStatistic(3, "LENGTH", 11.67, "m");
        c2.addStatistic(4, "WEIGHT", 7756, "kg");
        c2.addStatistic(5, "MAX HEIGHT", 13716, "m");

        cards.add(c2);

        // C3
        CardInfo c3 = new CardInfo(
                "C3",
                "Aero L-59 Super Albatros",
                "TRAINER",
                R.drawable.airplanes_c3,
                'C',
                3,
                false
        );

        c3.addStatistic(0, "SPEED", 865, "km/h");
        c3.addStatistic(1, "AUTONOMY", 2000, "km");
        c3.addStatistic(2, "WINGSPAN", 9.54, "m");
        c3.addStatistic(3, "LENGTH", 12.20, "m");
        c3.addStatistic(4, "WEIGHT", 7700, "kg");
        c3.addStatistic(5, "MAX HEIGHT", 11500, "m");

        cards.add(c3);

        // C4
        CardInfo c4 = new CardInfo(
                "C4",
                "Dassault/Dornier Alpha Jet",
                "TRAINER",
                R.drawable.airplanes_c4,
                'C',
                4,
                false
        );

        c4.addStatistic(0, "SPEED", 1000, "km/h");
        c4.addStatistic(1, "AUTONOMY", 2900, "km");
        c4.addStatistic(2, "WINGSPAN", 9.11, "m");
        c4.addStatistic(3, "LENGTH", 13.23, "m");
        c4.addStatistic(4, "WEIGHT", 8000, "kg");
        c4.addStatistic(5, "MAX HEIGHT", 14630, "m");

        cards.add(c4);


        // =========================
        // D
        // =========================

        // D1
        CardInfo d1 = new CardInfo(
                "D1",
                "Mirage 2000N",
                "STRIKE FIGHTER",
                R.drawable.airplanes_d1,
                'D',
                1,
                false
        );

        d1.addStatistic(0, "SPEED", 2335, "km/h");
        d1.addStatistic(1, "AUTONOMY", 3335, "km");
        d1.addStatistic(2, "WINGSPAN", 9.13, "m");
        d1.addStatistic(3, "LENGTH", 14.36, "m");
        d1.addStatistic(4, "WEIGHT", 17000, "kg");
        d1.addStatistic(5, "MAX HEIGHT", 17060, "m");

        cards.add(d1);

        // D2
        CardInfo d2 = new CardInfo(
                "D2",
                "F/A-18 Hornet",
                "STRIKE FIGHTER",
                R.drawable.airplanes_d2,
                'D',
                2,
                false
        );

        d2.addStatistic(0, "SPEED", 1915, "km/h");
        d2.addStatistic(1, "AUTONOMY", 3300, "km");
        d2.addStatistic(2, "WINGSPAN", 12.30, "m");
        d2.addStatistic(3, "LENGTH", 17.07, "m");
        d2.addStatistic(4, "WEIGHT", 23540, "kg");
        d2.addStatistic(5, "MAX HEIGHT", 15240, "m");

        cards.add(d2);

        // D3
        CardInfo d3 = new CardInfo(
                "D3",
                "F-15E Strike Eagle",
                "STRIKE FIGHTER",
                R.drawable.airplanes_d3,
                'D',
                3,
                false
        );

        d3.addStatistic(0, "SPEED", 3017, "km/h");
        d3.addStatistic(1, "AUTONOMY", 3840, "km");
        d3.addStatistic(2, "WINGSPAN", 13.00, "m");
        d3.addStatistic(3, "LENGTH", 19.44, "m");
        d3.addStatistic(4, "WEIGHT", 36450, "kg");
        d3.addStatistic(5, "MAX HEIGHT", 18288, "m");

        cards.add(d3);

        // D4
        CardInfo d4 = new CardInfo(
                "D4",
                "F-4 Phantom II",
                "FIGHTER",
                R.drawable.airplanes_d4,
                'D',
                4,
                false
        );

        d4.addStatistic(0, "SPEED", 2370, "km/h");
        d4.addStatistic(1, "AUTONOMY", 2600, "km");
        d4.addStatistic(2, "WINGSPAN", 11.70, "m");
        d4.addStatistic(3, "LENGTH", 19.20, "m");
        d4.addStatistic(4, "WEIGHT", 28030, "kg");
        d4.addStatistic(5, "MAX HEIGHT", 18300, "m");

        cards.add(d4);


        // =========================
        // E
        // =========================

        // E1
        CardInfo e1 = new CardInfo(
                "E1",
                "Airbus A300",
                "TRANSPORT",
                R.drawable.airplanes_e1,
                'E',
                1,
                false
        );

        e1.addStatistic(0, "SPEED", 860, "km/h");
        e1.addStatistic(1, "AUTONOMY", 7500, "km");
        e1.addStatistic(2, "WINGSPAN", 44.84, "m");
        e1.addStatistic(3, "LENGTH", 54.08, "m");
        e1.addStatistic(4, "WEIGHT", 170500, "kg");
        e1.addStatistic(5, "MAX HEIGHT", 13100, "m");

        cards.add(e1);

        // E2
        CardInfo e2 = new CardInfo(
                "E2",
                "C-130 Hercules",
                "TRANSPORT",
                R.drawable.airplanes_e2,
                'E',
                2,
                false
        );

        e2.addStatistic(0, "SPEED", 670, "km/h");
        e2.addStatistic(1, "AUTONOMY", 3800, "km");
        e2.addStatistic(2, "WINGSPAN", 39.70, "m");
        e2.addStatistic(3, "LENGTH", 29.30, "m");
        e2.addStatistic(4, "WEIGHT", 70300, "kg");
        e2.addStatistic(5, "MAX HEIGHT", 8615, "m");

        cards.add(e2);

        // E3
        CardInfo e3 = new CardInfo(
                "E3",
                "C-5B Galaxy",
                "TRANSPORT",
                R.drawable.airplanes_e3,
                'E',
                3,
                false
        );

        e3.addStatistic(0, "SPEED", 932, "km/h");
        e3.addStatistic(1, "AUTONOMY", 4440, "km");
        e3.addStatistic(2, "WINGSPAN", 67.89, "m");
        e3.addStatistic(3, "LENGTH", 75.31, "m");
        e3.addStatistic(4, "WEIGHT", 381000, "kg");
        e3.addStatistic(5, "MAX HEIGHT", 10700, "m");

        cards.add(e3);

        // E4
        CardInfo e4 = new CardInfo(
                "E4",
                "C-17A Globemaster III",
                "TRANSPORT",
                R.drawable.airplanes_e4,
                'E',
                4,
                false
        );

        e4.addStatistic(0, "SPEED", 833, "km/h");
        e4.addStatistic(1, "AUTONOMY", 4440, "km");
        e4.addStatistic(2, "WINGSPAN", 51.75, "m");
        e4.addStatistic(3, "LENGTH", 53.00, "m");
        e4.addStatistic(4, "WEIGHT", 265352, "kg");
        e4.addStatistic(5, "MAX HEIGHT", 13716, "m");

        cards.add(e4);


        // =========================
        // F
        // =========================

        // F1
        CardInfo f1 = new CardInfo(
                "F1",
                "Tornado ECR",
                "RECON",
                R.drawable.airplanes_f1,
                'F',
                1,
                false
        );

        f1.addStatistic(0, "SPEED", 2400, "km/h");
        f1.addStatistic(1, "AUTONOMY", 3900, "km");
        f1.addStatistic(2, "WINGSPAN", 13.91, "m");
        f1.addStatistic(3, "LENGTH", 16.72, "m");
        f1.addStatistic(4, "WEIGHT", 28000, "kg");
        f1.addStatistic(5, "MAX HEIGHT", 15240, "m");

        cards.add(f1);

        // F2
        CardInfo f2 = new CardInfo(
                "F2",
                "Embraer R-99",
                "RECON",
                R.drawable.airplanes_f2,
                'F',
                2,
                false
        );

        f2.addStatistic(0, "SPEED", 750, "km/h");
        f2.addStatistic(1, "AUTONOMY", 3000, "km");
        f2.addStatistic(2, "WINGSPAN", 28.72, "m");
        f2.addStatistic(3, "LENGTH", 29.90, "m");
        f2.addStatistic(4, "WEIGHT", 23000, "kg");
        f2.addStatistic(5, "MAX HEIGHT", 11278, "m");

        cards.add(f2);

        // F3
        CardInfo f3 = new CardInfo(
                "F3",
                "Boeing E-3 AWACS",
                "AWACS",
                R.drawable.airplanes_f3,
                'F',
                3,
                false
        );

        f3.addStatistic(0, "SPEED", 855, "km/h");
        f3.addStatistic(1, "AUTONOMY", 7400, "km");
        f3.addStatistic(2, "WINGSPAN", 44.42, "m");
        f3.addStatistic(3, "LENGTH", 46.61, "m");
        f3.addStatistic(4, "WEIGHT", 147417, "kg");
        f3.addStatistic(5, "MAX HEIGHT", 12496, "m");

        cards.add(f3);

        // F4
        CardInfo f4 = new CardInfo(
                "F4",
                "Grumman EA-6B Prowler",
                "ELECTRONIC WARFARE",
                R.drawable.airplanes_f4,
                'F',
                4,
                false
        );

        f4.addStatistic(0, "SPEED", 1040, "km/h");
        f4.addStatistic(1, "AUTONOMY", 3250, "km");
        f4.addStatistic(2, "WINGSPAN", 16.15, "m");
        f4.addStatistic(3, "LENGTH", 18.24, "m");
        f4.addStatistic(4, "WEIGHT", 29900, "kg");
        f4.addStatistic(5, "MAX HEIGHT", 11500, "m");

        cards.add(f4);


        // =========================
        // G
        // =========================

        // G1
        CardInfo g1 = new CardInfo(
                "G1",
                "KC-10A Extender",
                "TANKER",
                R.drawable.airplanes_g1,
                'G',
                1,
                false
        );

        g1.addStatistic(0, "SPEED", 996, "km/h");
        g1.addStatistic(1, "AUTONOMY", 18500, "km");
        g1.addStatistic(2, "WINGSPAN", 50.41, "m");
        g1.addStatistic(3, "LENGTH", 54.36, "m");
        g1.addStatistic(4, "WEIGHT", 267620, "kg");
        g1.addStatistic(5, "MAX HEIGHT", 12192, "m");

        cards.add(g1);

        // G2
        CardInfo g2 = new CardInfo(
                "G2",
                "KC-135 Stratotanker",
                "TANKER",
                R.drawable.airplanes_g2,
                'G',
                2,
                false
        );

        g2.addStatistic(0, "SPEED", 933, "km/h");
        g2.addStatistic(1, "AUTONOMY", 17766, "km");
        g2.addStatistic(2, "WINGSPAN", 39.88, "m");
        g2.addStatistic(3, "LENGTH", 41.53, "m");
        g2.addStatistic(4, "WEIGHT", 146285, "kg");
        g2.addStatistic(5, "MAX HEIGHT", 15240, "m");

        cards.add(g2);

        // G3
        CardInfo g3 = new CardInfo(
                "G3",
                "Vickers VC10",
                "TRANSPORT",
                R.drawable.airplanes_g3,
                'G',
                3,
                false
        );

        g3.addStatistic(0, "SPEED", 917, "km/h");
        g3.addStatistic(1, "AUTONOMY", 9600, "km");
        g3.addStatistic(2, "WINGSPAN", 42.62, "m");
        g3.addStatistic(3, "LENGTH", 35.84, "m");
        g3.addStatistic(4, "WEIGHT", 151950, "kg");
        g3.addStatistic(5, "MAX HEIGHT", 13100, "m");

        cards.add(g3);

        // G4
        CardInfo g4 = new CardInfo(
                "G4",
                "Lockheed S-3 Viking",
                "RECON",
                R.drawable.airplanes_g4,
                'G',
                4,
                false
        );

        g4.addStatistic(0, "SPEED", 806, "km/h");
        g4.addStatistic(1, "AUTONOMY", 5100, "km");
        g4.addStatistic(2, "WINGSPAN", 20.93, "m");
        g4.addStatistic(3, "LENGTH", 16.26, "m");
        g4.addStatistic(4, "WEIGHT", 23800, "kg");
        g4.addStatistic(5, "MAX HEIGHT", 12190, "m");

        cards.add(g4);


        // =========================
        // H
        // =========================

        // H1
        CardInfo h1 = new CardInfo(
                "H1",
                "F-111C",
                "STRIKE FIGHTER",
                R.drawable.airplanes_h1,
                'H',
                1,
                false
        );

        h1.addStatistic(0, "SPEED", 2655, "km/h");
        h1.addStatistic(1, "AUTONOMY", 5900, "km");
        h1.addStatistic(2, "WINGSPAN", 19.20, "m");
        h1.addStatistic(3, "LENGTH", 22.40, "m");
        h1.addStatistic(4, "WEIGHT", 45400, "kg");
        h1.addStatistic(5, "MAX HEIGHT", 17000, "m");

        cards.add(h1);

        // H2
        CardInfo h2 = new CardInfo(
                "H2",
                "Sukhoi Su-24 Fencer",
                "STRIKE FIGHTER",
                R.drawable.airplanes_h2,
                'H',
                2,
                false
        );

        h2.addStatistic(0, "SPEED", 1315, "km/h");
        h2.addStatistic(1, "AUTONOMY", 2775, "km");
        h2.addStatistic(2, "WINGSPAN", 17.64, "m");
        h2.addStatistic(3, "LENGTH", 24.53, "m");
        h2.addStatistic(4, "WEIGHT", 39700, "kg");
        h2.addStatistic(5, "MAX HEIGHT", 11000, "m");

        cards.add(h2);

        // H3
        CardInfo h3 = new CardInfo(
                "H3",
                "B-2 Spirit",
                "BOMBER",
                R.drawable.airplanes_h3,
                'H',
                3,
                false
        );

        h3.addStatistic(0, "SPEED", 1010, "km/h");
        h3.addStatistic(1, "AUTONOMY", 11100, "km");
        h3.addStatistic(2, "WINGSPAN", 52.43, "m");
        h3.addStatistic(3, "LENGTH", 21.03, "m");
        h3.addStatistic(4, "WEIGHT", 170600, "kg");
        h3.addStatistic(5, "MAX HEIGHT", 15200, "m");

        cards.add(h3);

        // H4
        CardInfo h4 = new CardInfo(
                "H4",
                "Rockwell B-1B Lancer",
                "BOMBER",
                R.drawable.airplanes_h4,
                'H',
                4,
                false
        );

        h4.addStatistic(0, "SPEED", 1335, "km/h");
        h4.addStatistic(1, "AUTONOMY", 12000, "km");
        h4.addStatistic(2, "WINGSPAN", 41.67, "m");
        h4.addStatistic(3, "LENGTH", 44.81, "m");
        h4.addStatistic(4, "WEIGHT", 216000, "kg");
        h4.addStatistic(5, "MAX HEIGHT", 18000, "m");

        cards.add(h4);
    }

    public List<CardInfo> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
