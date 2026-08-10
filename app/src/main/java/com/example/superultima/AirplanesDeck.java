package com.example.superultima;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AirplanesDeck {

    private final List<CardInfo> cards = new ArrayList<>();

    public AirplanesDeck() {
                     // A

        // A1
        cards.add(new CardInfo(
                "A1",
                "F-16 Fighting Falcon",
                "FIGHTER",
                R.drawable.a1,
                2414,
                3220,
                9.8,
                14.8,
                16875,
                15240,
                'A',
                1,
                false
        ));

// A2
        cards.add(new CardInfo(
                "A2",
                "Dassault Rafale C",
                "FIGHTER",
                R.drawable.a2,
                1390,
                3700,
                10.9,
                15.3,
                24500,
                15240,
                'A',
                2,
                false
        ));

// A3
        cards.add(new CardInfo(
                "A3",
                "Eurofighter EF 2000 Typhoon",
                "FIGHTER",
                R.drawable.a3,
                2495,
                3790,
                10.95,
                15.96,
                23500,
                16764,
                'A',
                3,
                false
        ));

// A4
        cards.add(new CardInfo(
                "A4",
                "F-22 Raptor",
                "FIGHTER",
                R.drawable.a4,
                2410,
                2960,
                13.6,
                18.9,
                38000,
                15240,
                'A',
                4,
                true
        ));


                      // B

// B1
        cards.add(new CardInfo(
                "B1",
                "Dassault Mirage F1CR",
                "RECON",
                R.drawable.b1,
                2338,
                3300,
                8.4,
                15.3,
                16500,
                20000,
                'B',
                1,
                false
        ));

// B2
        cards.add(new CardInfo(
                "B2",
                "Grumman RQ-4 Global Hawk",
                "RECON",
                R.drawable.b2,
                629,
                22780,
                39.9,
                14.5,
                14628,
                18288,
                'B',
                2,
                false
        ));

// B3
        cards.add(new CardInfo(
                "B3",
                "Lockheed SR-71 Blackbird",
                "RECON",
                R.drawable.b3,
                3540,
                5400,
                16.94,
                32.74,
                77111,
                25900,
                'B',
                3,
                false
        ));

// B4
        cards.add(new CardInfo(
                "B4",
                "Lockheed U-2R",
                "RECON",
                R.drawable.b4,
                805,
                10300,
                31.39,
                19.2,
                18143,
                27430,
                'B',
                4,
                false
        ));


                        // C

// C1
        cards.add(new CardInfo(
                "C1",
                "Aermacchi M-346",
                "TRAINER",
                R.drawable.c1,
                1255,
                2100,
                9.72,
                11.49,
                9500,
                13716,
                'C',
                1,
                false
        ));

// C2
        cards.add(new CardInfo(
                "C2",
                "T-2C Buckeye",
                "TRAINER",
                R.drawable.c2,
                840,
                1770,
                11.61,
                11.67,
                7756,
                13716,
                'C',
                2,
                false
        ));

// C3
        cards.add(new CardInfo(
                "C3",
                "Aero L-59 Super Albatros",
                "TRAINER",
                R.drawable.c3,
                865,
                2000,
                9.54,
                12.20,
                7700,
                11500,
                'C',
                3,
                false
        ));

// C4
        cards.add(new CardInfo(
                "C4",
                "Dassault/Dornier Alpha Jet",
                "TRAINER",
                R.drawable.c4,
                1000,
                2900,
                9.11,
                13.23,
                8000,
                14630,
                'C',
                4,
                false
        ));


                      // D

// D1
        cards.add(new CardInfo(
                "D1",
                "Mirage 2000N",
                "STRIKE FIGHTER",
                R.drawable.d1,
                2335,
                3335,
                9.13,
                14.36,
                17000,
                17060,
                'D',
                1,
                false
        ));

// D2
        cards.add(new CardInfo(
                "D2",
                "F/A-18 Hornet",
                "STRIKE FIGHTER",
                R.drawable.d2,
                1915,
                3300,
                12.30,
                17.07,
                23540,
                15240,
                'D',
                2,
                false
        ));

// D3
        cards.add(new CardInfo(
                "D3",
                "F-15E Strike Eagle",
                "STRIKE FIGHTER",
                R.drawable.d3,
                3017,
                3840,
                13.00,
                19.44,
                36450,
                18288,
                'D',
                3,
                false
        ));

// D4
        cards.add(new CardInfo(
                "D4",
                "F-4 Phantom II",
                "FIGHTER",
                R.drawable.d4,
                2370,
                2600,
                11.70,
                19.20,
                28030,
                18300,
                'D',
                4,
                false
        ));


                      // E

// E1
        cards.add(new CardInfo(
                "E1",
                "Airbus A300",
                "TRANSPORT",
                R.drawable.e1,
                860,
                7500,
                44.84,
                54.08,
                170500,
                13100,
                'E',
                1,
                false
        ));

// E2
        cards.add(new CardInfo(
                "E2",
                "C-130 Hercules",
                "TRANSPORT",
                R.drawable.e2,
                670,
                3800,
                39.70,
                29.30,
                70300,
                8615,
                'E',
                2,
                false
        ));

// E3
        cards.add(new CardInfo(
                "E3",
                "C-5B Galaxy",
                "TRANSPORT",
                R.drawable.e3,
                932,
                4440,
                67.89,
                75.31,
                381000,
                10700,
                'E',
                3,
                false
        ));

// E4
        cards.add(new CardInfo(
                "E4",
                "C-17A Globemaster III",
                "TRANSPORT",
                R.drawable.e4,
                833,
                4440,
                51.75,
                53.00,
                265352,
                13716,
                'E',
                4,
                false
        ));


                      // F

// F1
        cards.add(new CardInfo(
                "F1",
                "Tornado ECR",
                "RECON",
                R.drawable.f1,
                2400,
                3900,
                13.91,
                16.72,
                28000,
                15240,
                'F',
                1,
                false
        ));

// F2
        cards.add(new CardInfo(
                "F2",
                "Embraer R-99",
                "RECON",
                R.drawable.f2,
                750,
                3000,
                28.72,
                29.90,
                23000,
                11278,
                'F',
                2,
                false
        ));

// F3
        cards.add(new CardInfo(
                "F3",
                "Boeing E-3 AWACS",
                "AWACS",
                R.drawable.f3,
                855,
                7400,
                44.42,
                46.61,
                147417,
                12496,
                'F',
                3,
                false
        ));

// F4
        cards.add(new CardInfo(
                "F4",
                "Grumman EA-6B Prowler",
                "ELECTRONIC WARFARE",
                R.drawable.f4,
                1040,
                3250,
                16.15,
                18.24,
                29900,
                11500,
                'F',
                4,
                false
        ));


                       // G

// G1
        cards.add(new CardInfo(
                "G1",
                "KC-10A Extender",
                "TANKER",
                R.drawable.g1,
                996,
                18500,
                50.41,
                54.36,
                267620,
                12192,
                'G',
                1,
                false
        ));

// G2
        cards.add(new CardInfo(
                "G2",
                "KC-135 Stratotanker",
                "TANKER",
                R.drawable.g2,
                933,
                17766,
                39.88,
                41.53,
                146285,
                15240,
                'G',
                2,
                false
        ));

// G3
        cards.add(new CardInfo(
                "G3",
                "Vickers VC10",
                "TRANSPORT",
                R.drawable.g3,
                917,
                9600,
                42.62,
                35.84,
                151950,
                13100,
                'G',
                3,
                false
        ));

// G4
        cards.add(new CardInfo(
                "G4",
                "Lockheed S-3 Viking",
                "RECON",
                R.drawable.g4,
                806,
                5100,
                20.93,
                16.26,
                23800,
                12190,
                'G',
                4,
                false
        ));


                          // H

// H1
        cards.add(new CardInfo(
                "H1",
                "F-111C",
                "STRIKE FIGHTER",
                R.drawable.h1,
                2655,
                5900,
                19.20,
                22.40,
                45400,
                17000,
                'H',
                1,
                false
        ));

// H2
        cards.add(new CardInfo(
                "H2",
                "Sukhoi Su-24 Fencer",
                "STRIKE FIGHTER",
                R.drawable.h2,
                1315,
                2775,
                17.64,
                24.53,
                39700,
                11000,
                'H',
                2,
                false
        ));

// H3
        cards.add(new CardInfo(
                "H3",
                "B-2 Spirit",
                "BOMBER",
                R.drawable.h3,
                1010,
                11100,
                52.43,
                21.03,
                170600,
                15200,
                'H',
                3,
                false
        ));

// H4
        cards.add(new CardInfo(
                "H4",
                "Rockwell B-1B Lancer",
                "BOMBER",
                R.drawable.h4,
                1335,
                12000,
                41.67,
                44.81,
                216000,
                18000,
                'H',
                4,
                false
        ));
    }

    public List<CardInfo> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}



