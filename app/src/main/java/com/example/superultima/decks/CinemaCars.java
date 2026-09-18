package com.example.superultima.decks;

import com.example.superultima.R;
import com.example.superultima.cardgame.CardInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CinemaCars {

    private final List<CardInfo> cards = new ArrayList<>();

    public CinemaCars() {
//A
//A1
        CardInfo a1 = new CardInfo(
                "A1",
                "Dodje Charger",
                "Dukes of hazard",
                R.drawable.moviecars_a1,
                'A',
                1,
                false
        );

        a1.addStatistic(0, "Speed", 220, "km/h");
        a1.addStatistic(1, "Acceleration", 5.2, "0-100");
        a1.addStatistic(2, "Cubic Centimeters", 6.974, "cc");
        a1.addStatistic(3, "Horsepower", 425, "bhp");
        a1.addStatistic(4, "Premiere year", 1979, "year");
        a1.addStatistic(5, "Εngine Τorque", 664, "nm");

        cards.add(a1);
//A2
        CardInfo a2 = new CardInfo(
                "A2",
                "Delorean DMC-12",
                "Back to the future",
                R.drawable.moviecars_a2,
                'A',
                2,
                false
        );

        a2.addStatistic(0, "Speed", 210, "km/h");
        a2.addStatistic(1, "Acceleration", 8.6, "0-100");
        a2.addStatistic(2, "Cubic Centimeters", 2.849, "cc");
        a2.addStatistic(3, "Horsepower", 145, "bhp");
        a2.addStatistic(4, "Premiere year", 1985, "year");
        a2.addStatistic(5, "Εngine Τorque", 225, "nm");

        cards.add(a2);


//A3
        CardInfo a3 = new CardInfo(
                "A3",
                "Pontiac Firebird Trans-Am",
                "Knight Rider",
                R.drawable.moviecars_a3,
                'A',
                3,
                false
        );

        a3.addStatistic(0, "Speed", 201, "km/h");
        a3.addStatistic(1, "Acceleration", 9.2, "0-100");
        a3.addStatistic(2, "Cubic Centimeters", 5.013, "cc");
        a3.addStatistic(3, "Horsepower", 192, "bhp");
        a3.addStatistic(4, "Premiere year", 1982, "year");
        a3.addStatistic(5, "Εngine Τorque", 325, "nm");

        cards.add(a3);

//A4
        CardInfo a4 = new CardInfo(
                "A4",
                "Cadillac Miller-Meteor Ecto-1",
                "Ghostbusters",
                R.drawable.moviecars_a4,
                'A',
                4,
                false
        );

        a4.addStatistic(0, "Speed", 193, "km/h");
        a4.addStatistic(1, "Acceleration", 11.5, "0-100");
        a4.addStatistic(2, "Cubic Centimeters", 6.390, "cc");
        a4.addStatistic(3, "Horsepower", 325, "bhp");
        a4.addStatistic(4, "Premiere year", 1984, "year");
        a4.addStatistic(5, "Εngine Τorque", 583, "nm");

        cards.add(a4);
//B

//B1
        CardInfo b1 = new CardInfo(
                "B1",
                "Ferrari Testarossa",
                "Miami Vice tv series",
                R.drawable.moviecars_b1,
                'B',
                1,
                false
        );

        b1.addStatistic(0, "Speed", 290, "km/h");
        b1.addStatistic(1, "Acceleration", 5.7, "0-100");
        b1.addStatistic(2, "Cubic Centimeters", 4.942, "cc");
        b1.addStatistic(3, "Horsepower", 390, "bhp");
        b1.addStatistic(4, "Premiere year", 1986, "year");
        b1.addStatistic(5, "Εngine Τorque", 490, "nm");

        cards.add(b1);

//B2
        CardInfo b2 = new CardInfo(
                "B2",
                "Lotus Esprit",
                "James Bond:spy who love me",
                R.drawable.moviecars_b2,
                'B',
                2,
                false
        );

        b2.addStatistic(0, "Speed", 200, "km/h");
        b2.addStatistic(1, "Acceleration", 8.7, "0-100");
        b2.addStatistic(2, "Cubic Centimeters", 1.973, "cc");
        b2.addStatistic(3, "Horsepower", 156, "bhp");
        b2.addStatistic(4, "Premiere year", 1977, "year");
        b2.addStatistic(5, "Εngine Τorque", 190, "nm");

        cards.add(b2);

//B3
        CardInfo b3 = new CardInfo(
                "B3",
                "Volkswagen Beetle",
                "The love bug",
                R.drawable.moviecars_b3,
                'B',
                3,
                true
        );

        b3.addStatistic(0, "Speed", 126, "km/h");
        b3.addStatistic(1, "Acceleration", 26.5, "0-100");
        b3.addStatistic(2, "Cubic Centimeters", 1.285, "cc");
        b3.addStatistic(3, "Horsepower", 43, "bhp");
        b3.addStatistic(4, "Premiere year", 1968, "year");
        b3.addStatistic(5, "Εngine Τorque", 86, "nm");

        cards.add(b3);

//B4
        CardInfo b4 = new CardInfo(
                "B4",
                "Plymouth Fury",
                "Christine",
                R.drawable.moviecars_b4,
                'B',
                4,
                false
        );

        b4.addStatistic(0, "Speed", 196, "km/h");
        b4.addStatistic(1, "Acceleration", 8.8, "0-100");
        b4.addStatistic(2, "Cubic Centimeters", 5.736, "cc");
        b4.addStatistic(3, "Horsepower", 305, "bhp");
        b4.addStatistic(4, "Premiere year", 1983, "year");
        b4.addStatistic(5, "Εngine Τorque", 502, "nm");

        cards.add(b4);
//C
//C1
        CardInfo c1 = new CardInfo(
                "C1",
                "Ferrari 308 GTS",
                "2 Fast 2 Furious",
                R.drawable.moviecars_c1,
                'C',
                1,
                false
        );

        c1.addStatistic(0, "Speed", 252, "km/h");
        c1.addStatistic(1, "Acceleration", 6.0, "0-100");
        c1.addStatistic(2, "Cubic Centimeters", 2.927, "cc");
        c1.addStatistic(3, "Horsepower", 224, "bhp");
        c1.addStatistic(4, "Premiere year", 1980, "year");
        c1.addStatistic(5, "Εngine Τorque", 284, "nm");

        cards.add(c1);

//C2
        CardInfo c2 = new CardInfo(
                "C2",
                "Nissan GT-R R34",
                "2 Fast 2 Furious",
                R.drawable.moviecars_c2,
                'C',
                2,
                false
        );

        c2.addStatistic(0, "Speed", 249, "km/h");
        c2.addStatistic(1, "Acceleration", 4.8, "0-100");
        c2.addStatistic(2, "Cubic Centimeters", 2.568, "cc");
        c2.addStatistic(3, "Horsepower", 276, "bhp");
        c2.addStatistic(4, "Premiere year", 2003, "year");
        c2.addStatistic(5, "Εngine Τorque", 293, "nm");

        cards.add(c2);

//C3
        CardInfo c3 = new CardInfo(
                "C3",
                "Ford Thunderbird convertable",
                "Thelma and Louise",
                R.drawable.moviecars_c3,
                'C',
                3,
                false
        );

        c3.addStatistic(0, "Speed", 205, "km/h");
        c3.addStatistic(1, "Acceleration", 9.6, "0-100");
        c3.addStatistic(2, "Cubic Centimeters", 6.384, "cc");
        c3.addStatistic(3, "Horsepower", 315, "bhp");
        c3.addStatistic(4, "Premiere year", 1991, "year");
        c3.addStatistic(5, "Εngine Τorque", 579, "nm");

        cards.add(c3);
//C4
        CardInfo c4 = new CardInfo(
                "C4",
                "Dodge Monaco",
                "The Blues Brothers",
                R.drawable.moviecars_c4,
                'C',
                4,
                false
        );

        c4.addStatistic(0, "Speed", 183, "km/h");
        c4.addStatistic(1, "Acceleration", 12, "0-100");
        c4.addStatistic(2, "Cubic Centimeters", 5.898, "cc");
        c4.addStatistic(3, "Horsepower", 180, "bhp");
        c4.addStatistic(4, "Premiere year", 1980, "year");
        c4.addStatistic(5, "Εngine Τorque", 393, "nm");

        cards.add(c4);
//D
//D1


        CardInfo d1 = new CardInfo(
                "D1",
                "Aston Martin DB5",
                "James Bond:Goldfinger",
                R.drawable.moviecars_d1,
                'D',
                1,
                false
        );

        d1.addStatistic(0, "Speed", 230, "km/h");
        d1.addStatistic(1, "Acceleration", 8.4, "0-100");
        d1.addStatistic(2, "Cubic Centimeters", 3.995, "cc");
        d1.addStatistic(3, "Horsepower", 286, "bhp");
        d1.addStatistic(4, "Premiere year", 1965, "year");
        d1.addStatistic(5, "Εngine Τorque", 380, "nm");

        cards.add(d1);

//D2
        CardInfo d2 = new CardInfo(
                "D2",
                "Nissan Silvia S15",
                "Fast and Furious:Tokyo Drift",
                R.drawable.moviecars_d2,
                'D',
                2,
                false
        );

        d2.addStatistic(0, "Speed", 230, "km/h");
        d2.addStatistic(1, "Acceleration", 8.1, "0-100");
        d2.addStatistic(2, "Cubic Centimeters", 1.998, "cc");
        d2.addStatistic(3, "Horsepower", 162, "bhp");
        d2.addStatistic(4, "Premiere year", 2006, "year");
        d2.addStatistic(5, "Εngine Τorque", 192, "nm");

        cards.add(d2);

//D3
        CardInfo d3 = new CardInfo(
                "D3",
                "Volvo P1800 S",
                "The Saint series",
                R.drawable.moviecars_d3,
                'D',
                3,
                false
        );

        d3.addStatistic(0, "Speed", 176, "km/h");
        d3.addStatistic(1, "Acceleration", 12.9, "0-100");
        d3.addStatistic(2, "Cubic Centimeters", 1.782, "cc");
        d3.addStatistic(3, "Horsepower", 103, "bhp");
        d3.addStatistic(4, "Premiere year", 1962, "year");
        d3.addStatistic(5, "Εngine Τorque", 147, "nm");

        cards.add(d3);

//D4
        CardInfo d4 = new CardInfo(
                "D4",
                "Mercury Monterey",
                "Cobra",
                R.drawable.moviecars_d4,
                'D',
                4,
                false
        );

        d4.addStatistic(0, "Speed", 133, "km/h");
        d4.addStatistic(1, "Acceleration", 19.8, "0-100");
        d4.addStatistic(2, "Cubic Centimeters", 5.253, "cc");
        d4.addStatistic(3, "Horsepower", 110, "bhp");
        d4.addStatistic(4, "Premiere year", 1986, "year");
        d4.addStatistic(5, "Εngine Τorque", 271, "nm");

        cards.add(d4);

 //E
 //E1
        CardInfo e1 = new CardInfo(
                "E1",
                "Audi R8 Spyder",
                "Iron Man 2",
                R.drawable.moviecars_e1,
                'E',
                1,
                false
        );

        e1.addStatistic(0, "Speed", 317, "km/h");
        e1.addStatistic(1, "Acceleration", 3.8, "0-100");
        e1.addStatistic(2, "Cubic Centimeters", 5.204, "cc");
        e1.addStatistic(3, "Horsepower", 560, "bhp");
        e1.addStatistic(4, "Premiere year", 2010, "year");
        e1.addStatistic(5, "Εngine Τorque", 540, "nm");

        cards.add(e1);
//E2
        CardInfo e2 = new CardInfo(
                "E2",
                "Porche 928 Coupe",
                "Risky bussiness",
                R.drawable.moviecars_e2,
                'E',
                2,
                false
        );

        e2.addStatistic(0, "Speed", 230, "km/h");
        e2.addStatistic(1, "Acceleration", 7.5, "0-100");
        e2.addStatistic(2, "Cubic Centimeters", 4.474, "cc");
        e2.addStatistic(3, "Horsepower", 219, "bhp");
        e2.addStatistic(4, "Premiere year", 1983, "year");
        e2.addStatistic(5, "Εngine Τorque", 344, "nm");

        cards.add(e2);
 //E3
        CardInfo e3 = new CardInfo(
                "E3",
                "Alfa Romeo 1600 spider Duetto",
                "The graduate",
                R.drawable.moviecars_e3,
                'E',
                3,
                false
        );

        e3.addStatistic(0, "Speed", 185, "km/h");
        e3.addStatistic(1, "Acceleration", 10.3, "0-100");
        e3.addStatistic(2, "Cubic Centimeters", 1.570, "cc");
        e3.addStatistic(3, "Horsepower", 125, "bhp");
        e3.addStatistic(4, "Premiere year", 1967, "year");
        e3.addStatistic(5, "Εngine Τorque", 156, "nm");

        cards.add(e3);
 //E4
        CardInfo e4 = new CardInfo(
                "E4",
                "Ford Shelby GT500",
                "Gone in 60 seconds",
                R.drawable.moviecars_e4,
                'E',
                4,
                false
        );

        e4.addStatistic(0, "Speed", 207, "km/h");
        e4.addStatistic(1, "Acceleration", 6.0, "0-100");
        e4.addStatistic(2, "Cubic Centimeters", 6.997, "cc");
        e4.addStatistic(3, "Horsepower", 335, "bhp");
        e4.addStatistic(4, "Premiere year", 2000, "year");
        e4.addStatistic(5, "Εngine Τorque", 570, "nm");

        cards.add(e4);
 //F
 //F1
        CardInfo f1 = new CardInfo(
                "F1",
                "Chevrolet Camaro",
                "Transformers",
                R.drawable.moviecars_f1,
                'F',
                1,
                false
        );

        f1.addStatistic(0, "Speed", 249, "km/h");
        f1.addStatistic(1, "Acceleration", 5.1, "0-100");
        f1.addStatistic(2, "Cubic Centimeters", 6.162, "cc");
        f1.addStatistic(3, "Horsepower", 431, "bhp");
        f1.addStatistic(4, "Premiere year", 2007, "year");
        f1.addStatistic(5, "Εngine Τorque", 584, "nm");

        cards.add(f1);
//F2
        CardInfo f2 = new CardInfo(
                "F2",
                "Koenigsegg Agera R",
                "Need for speed",
                R.drawable.moviecars_f2,
                'F',
                2,
                false
        );

        f2.addStatistic(0, "Speed", 420, "km/h");
        f2.addStatistic(1, "Acceleration", 2.8, "0-100");
        f2.addStatistic(2, "Cubic Centimeters", 5.032, "cc");
        f2.addStatistic(3, "Horsepower", 1140, "bhp");
        f2.addStatistic(4, "Premiere year", 2013, "year");
        f2.addStatistic(5, "Εngine Τorque", 1200, "nm");

        cards.add(f2);
 //F3
        CardInfo f3 = new CardInfo(
                "F3",
                "Mustang Mach 1",
                "Gone in 60 seconds",
                R.drawable.moviecars_f3,
                'F',
                3,
                false
        );

        f3.addStatistic(0, "Speed", 204, "km/h");
        f3.addStatistic(1, "Acceleration", 6.5, "0-100");
        f3.addStatistic(2, "Cubic Centimeters", 5.776, "cc");
        f3.addStatistic(3, "Horsepower", 243, "bhp");
        f3.addStatistic(4, "Premiere year", 1974, "year");
        f3.addStatistic(5, "Εngine Τorque", 426, "nm");

        cards.add(f3);
//F4
        CardInfo f4 = new CardInfo(
                "F4",
                "Crysler Imperial",
                "Green Hornet",
                R.drawable.moviecars_f4,
                'F',
                4,
                false
        );

        f4.addStatistic(0, "Speed", 195, "km/h");
        f4.addStatistic(1, "Acceleration", 10.3, "0-100");
        f4.addStatistic(2, "Cubic Centimeters", 5.786, "cc");
        f4.addStatistic(3, "Horsepower", 350, "bhp");
        f4.addStatistic(4, "Premiere year", 2011, "year");
        f4.addStatistic(5, "Εngine Τorque", 651, "nm");

        cards.add(f4);
//G
//G1
        CardInfo g1 = new CardInfo(
                "G1",
                "Aston Martin DBS",
                "James Bond Casino Royale",
                R.drawable.moviecars_g1,
                'G',
                1,
                false
        );

        g1.addStatistic(0, "Speed", 307, "km/h");
        g1.addStatistic(1, "Acceleration", 4.3, "0-100");
        g1.addStatistic(2, "Cubic Centimeters", 5.935, "cc");
        g1.addStatistic(3, "Horsepower", 617, "bhp");
        g1.addStatistic(4, "Premiere year", 2006, "year");
        g1.addStatistic(5, "Εngine Τorque", 570, "nm");

        cards.add(g1);
 //G2
        CardInfo g2 = new CardInfo(
                "G2",
                "Audi A8 6.0 W12",
                "Transporter 2",
                R.drawable.moviecars_g2,
                'G',
                2,
                false
        );

        g2.addStatistic(0, "Speed", 250, "km/h");
        g2.addStatistic(1, "Acceleration", 5.0, "0-100");
        g2.addStatistic(2, "Cubic Centimeters", 5.0, "cc");
        g2.addStatistic(3, "Horsepower", 5.998, "bhp");
        g2.addStatistic(4, "Premiere year", 2005, "year");
        g2.addStatistic(5, "Εngine Τorque", 610, "nm");

        cards.add(g2);
//G3
        CardInfo g3 = new CardInfo(
                "G3",
                "Chevy Nova",
                "Death Proof",
                R.drawable.moviecars_g3,
                'G',
                3,
                false
        );

        g3.addStatistic(0, "Speed", 200, "km/h");
        g3.addStatistic(1, "Acceleration", 6.5, "0-100");
        g3.addStatistic(2, "Cubic Centimeters", 6.590, "cc");
        g3.addStatistic(3, "Horsepower", 375, "bhp");
        g3.addStatistic(4, "Premiere year", 2007, "year");
        g3.addStatistic(5, "Εngine Τorque", 563, "nm");

        cards.add(g3);
//G4
        CardInfo g4 = new CardInfo(
                "G4",
                "Mazda RX7",
                "Fast and Furious",
                R.drawable.moviecars_g4,
                'G',
                4,
                false
        );

        g4.addStatistic(0, "Speed", 250, "km/h");
        g4.addStatistic(1, "Acceleration", 5.7, "0-100");
        g4.addStatistic(2, "Cubic Centimeters", 1.308, "cc");
        g4.addStatistic(3, "Horsepower", 255, "bhp");
        g4.addStatistic(4, "Premiere year", 2001, "year");
        g4.addStatistic(5, "Εngine Τorque", 594, "nm");

        cards.add(g4);
 //H
 //H1
        CardInfo h1 = new CardInfo(
                "H1",
                "Porche 917K",
                "Le Mans",
                R.drawable.moviecars_h1,
                'H',
                1,
                false
        );

        h1.addStatistic(0, "Speed", 354, "km/h");
        h1.addStatistic(1, "Acceleration", 1.9, "0-100");
        h1.addStatistic(2, "Cubic Centimeters", 4.907, "cc");
        h1.addStatistic(3, "Horsepower", 600, "bhp");
        h1.addStatistic(4, "Premiere year", 1971, "year");
        h1.addStatistic(5, "Εngine Τorque", 563, "nm");

        cards.add(h1);
 //H2
        CardInfo h2 = new CardInfo(
                "H2",
                "Ford Mustang GT390 Fastback",
                "Bullitt",
                R.drawable.moviecars_h2,
                'H',
                2,
                false
        );

        h2.addStatistic(0, "Speed", 194, "km/h");
        h2.addStatistic(1, "Acceleration", 6.5, "0-100");
        h2.addStatistic(2, "Cubic Centimeters", 6.384, "cc");
        h2.addStatistic(3, "Horsepower", 325, "bhp");
        h2.addStatistic(4, "Premiere year", 1968, "year");
        h2.addStatistic(5, "Εngine Τorque", 579, "nm");

        cards.add(h2);
 //H3
        CardInfo h3 = new CardInfo(
                "H3",
                "Lamborgini Countach LP 500S",
                "The Cannonball run 2",
                R.drawable.moviecars_h3,
                'H',
                3,
                false
        );

        h3.addStatistic(0, "Speed", 273, "km/h");
        h3.addStatistic(1, "Acceleration", 5.8, "0-100");
        h3.addStatistic(2, "Cubic Centimeters", 4.754, "cc");
        h3.addStatistic(3, "Horsepower", 575, "bhp");
        h3.addStatistic(4, "Premiere year", 1984, "year");
        h3.addStatistic(5, "Εngine Τorque", 508, "nm");

        cards.add(h3);
//H4
        CardInfo h4 = new CardInfo(
                "H4",
                "Fiat 128 1300",
                "Rush",
                R.drawable.moviecars_h4,
                'H',
                4,
                false
        );

        h4.addStatistic(0, "Speed", 145, "km/h");
        h4.addStatistic(1, "Acceleration", 15.1, "0-100");
        h4.addStatistic(2, "Cubic Centimeters", 1.290, "cc");
        h4.addStatistic(3, "Horsepower", 59, "bhp");
        h4.addStatistic(4, "Premiere year", 2013, "year");
        h4.addStatistic(5, "Εngine Τorque", 97, "nm");

        cards.add(h4);



    }
    public List<CardInfo> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    }
















