package com.example.superultima.decks;

import com.example.superultima.cardgame.CardInfo;
import com.example.superultima.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MythicalMonsters {

    private final List<CardInfo> cards = new ArrayList<>();

    public MythicalMonsters() {

        // =========================
        // A
        // =========================

        // A1
        CardInfo a1 = new CardInfo(
                "A1",
                "Minotaur",
                "BEAST",
                R.drawable.mythical_monsters_a1,
                'A',
                1,
                false
        );

        a1.addStatistic(0, "STRENGTH", 90, "STR");
        a1.addStatistic(1, "SPEED", 55, "km/h");
        a1.addStatistic(2, "MASS", 75, "kg");
        a1.addStatistic(3, "DURABILITY", 85, "HP");
        a1.addStatistic(4, "INTELLIGENCE", 45, "IQ");
        a1.addStatistic(5, "MAGIC POWER", 25, "MP");

        cards.add(a1);

        // A2
        CardInfo a2 = new CardInfo(
                "A2",
                "Medusa",
                "GORGON",
                R.drawable.mythical_monsters_a2,
                'A',
                2,
                false
        );

        a2.addStatistic(0, "STRENGTH", 40, "STR");
        a2.addStatistic(1, "SPEED", 60, "km/h");
        a2.addStatistic(2, "MASS", 45, "kg");
        a2.addStatistic(3, "DURABILITY", 50, "HP");
        a2.addStatistic(4, "INTELLIGENCE", 85, "IQ");
        a2.addStatistic(5, "MAGIC POWER", 95, "MP");

        cards.add(a2);

        // A3
        CardInfo a3 = new CardInfo(
                "A3",
                "Cerberus",
                "GUARDIAN BEAST",
                R.drawable.mythical_monsters_a3,
                'A',
                3,
                false
        );

        a3.addStatistic(0, "STRENGTH", 88, "STR");
        a3.addStatistic(1, "SPEED", 70, "km/h");
        a3.addStatistic(2, "MASS", 80, "kg");
        a3.addStatistic(3, "DURABILITY", 90, "HP");
        a3.addStatistic(4, "INTELLIGENCE", 55, "IQ");
        a3.addStatistic(5, "MAGIC POWER", 60, "MP");

        cards.add(a3);

        // A4
        CardInfo a4 = new CardInfo(
                "A4",
                "Hydra",
                "SERPENT",
                R.drawable.mythical_monsters_a4,
                'A',
                4,
                false
        );

        a4.addStatistic(0, "STRENGTH", 92, "STR");
        a4.addStatistic(1, "SPEED", 40, "km/h");
        a4.addStatistic(2, "MASS", 95, "kg");
        a4.addStatistic(3, "DURABILITY", 98, "HP");
        a4.addStatistic(4, "INTELLIGENCE", 50, "IQ");
        a4.addStatistic(5, "MAGIC POWER", 80, "MP");

        cards.add(a4);


        // =========================
        // B
        // =========================

        // B1
        CardInfo b1 = new CardInfo(
                "B1",
                "Cyclops",
                "GIANT",
                R.drawable.mythical_monsters_b1,
                'B',
                1,
                false
        );

        b1.addStatistic(0, "STRENGTH", 94, "STR");
        b1.addStatistic(1, "SPEED", 45, "km/h");
        b1.addStatistic(2, "MASS", 90, "kg");
        b1.addStatistic(3, "DURABILITY", 88, "HP");
        b1.addStatistic(4, "INTELLIGENCE", 40, "IQ");
        b1.addStatistic(5, "MAGIC POWER", 35, "MP");

        cards.add(b1);

        // B2
        CardInfo b2 = new CardInfo(
                "B2",
                "Chimera",
                "HYBRID",
                R.drawable.mythical_monsters_b2,
                'B',
                2,
                false
        );

        b2.addStatistic(0, "STRENGTH", 82, "STR");
        b2.addStatistic(1, "SPEED", 72, "km/h");
        b2.addStatistic(2, "MASS", 70, "kg");
        b2.addStatistic(3, "DURABILITY", 78, "HP");
        b2.addStatistic(4, "INTELLIGENCE", 50, "IQ");
        b2.addStatistic(5, "MAGIC POWER", 75, "MP");

        cards.add(b2);

        // B3
        CardInfo b3 = new CardInfo(
                "B3",
                "Pegasus",
                "FLYING CREATURE",
                R.drawable.mythical_monsters_b3,
                'B',
                3,
                false
        );

        b3.addStatistic(0, "STRENGTH", 55, "STR");
        b3.addStatistic(1, "SPEED", 98, "km/h");
        b3.addStatistic(2, "MASS", 65, "kg");
        b3.addStatistic(3, "DURABILITY", 65, "HP");
        b3.addStatistic(4, "INTELLIGENCE", 70, "IQ");
        b3.addStatistic(5, "MAGIC POWER", 70, "MP");

        cards.add(b3);

        // B4
        CardInfo b4 = new CardInfo(
                "B4",
                "Griffin",
                "HYBRID",
                R.drawable.mythical_monsters_b4,
                'B',
                4,
                false
        );

        b4.addStatistic(0, "STRENGTH", 85, "STR");
        b4.addStatistic(1, "SPEED", 88, "km/h");
        b4.addStatistic(2, "MASS", 75, "kg");
        b4.addStatistic(3, "DURABILITY", 82, "HP");
        b4.addStatistic(4, "INTELLIGENCE", 75, "IQ");
        b4.addStatistic(5, "MAGIC POWER", 60, "MP");

        cards.add(b4);


        // =========================
        // C
        // =========================

        // C1
        CardInfo c1 = new CardInfo(
                "C1",
                "Sphinx",
                "Guardian",
                R.drawable.mythical_monsters_c1,
                'C',
                1,
                false
        );

        c1.addStatistic(0, "STRENGTH", 60, "STR");
        c1.addStatistic(1, "SPEED", 45, "km/h");
        c1.addStatistic(2, "MASS", 70, "kg");
        c1.addStatistic(3, "DURABILITY", 70, "HP");
        c1.addStatistic(4, "INTELLIGENCE", 100, "IQ");
        c1.addStatistic(5, "MAGIC POWER", 90, "MP");

        cards.add(c1);

        // C2
        CardInfo c2 = new CardInfo(
                "C2",
                "Kraken",
                "MYTHICAL MONSTER",
                R.drawable.mythical_monsters_c2,
                'C',
                2,
                false
        );

        c2.addStatistic(0, "STRENGTH", 98, "STR");
        c2.addStatistic(1, "SPEED", 35, "km/h");
        c2.addStatistic(2, "MASS", 100, "kg");
        c2.addStatistic(3, "DURABILITY", 95, "HP");
        c2.addStatistic(4, "INTELLIGENCE", 65, "IQ");
        c2.addStatistic(5, "MAGIC POWER", 85, "MP");

        cards.add(c2);

        // C3
        CardInfo c3 = new CardInfo(
                "C3",
                "Dragon",
                "FLYING BEAST",
                R.drawable.mythical_monsters_c3,
                'C',
                3,
                false
        );

        c3.addStatistic(0, "STRENGTH", 100, "STR");
        c3.addStatistic(1, "SPEED", 75, "km/h");
        c3.addStatistic(2, "MASS", 98, "kg");
        c3.addStatistic(3, "DURABILITY", 50, "HP");
        c3.addStatistic(4, "INTELLIGENCE", 70, "IQ");
        c3.addStatistic(5, "MAGIC POWER", 20, "MP");

        cards.add(c3);

        // C4
        CardInfo c4 = new CardInfo(
                "C4",
                "Leviathan",
                "SEA MONSTER",
                R.drawable.mythical_monsters_c4,
                'C',
                4,
                false
        );

        c4.addStatistic(0, "STRENGTH", 97, "STR");
        c4.addStatistic(1, "SPEED", 30, "km/h");
        c4.addStatistic(2, "MASS", 100, "kg");
        c4.addStatistic(3, "DURABILITY", 100, "HP");
        c4.addStatistic(4, "INTELLIGENCE", 70, "IQ");
        c4.addStatistic(5, "MAGIC POWER", 90, "MP");

        cards.add(c4);


        // =========================
        // D
        // =========================

        // D1
        CardInfo d1 = new CardInfo(
                "D1",
                "Phoenix",
                "MYTHICAL MONSTER",
                R.drawable.mythical_monsters_d1,
                'D',
                1,
                false
        );

        d1.addStatistic(0, "STRENGTH", 45, "STR");
        d1.addStatistic(1, "SPEED", 95, "km/h");
        d1.addStatistic(2, "MASS", 55, "kg");
        d1.addStatistic(3, "DURABILITY", 100, "HP");
        d1.addStatistic(4, "INTELLIGENCE", 80, "IQ");
        d1.addStatistic(5, "MAGIC POWER", 100, "MP");

        cards.add(d1);

        // D2
        CardInfo d2 = new CardInfo(
                "D2",
                "Manticore",
                "HYBRID",
                R.drawable.mythical_monsters_d2,
                'D',
                2,
                false
        );

        d2.addStatistic(0, "STRENGTH", 78, "STR");
        d2.addStatistic(1, "SPEED", 75, "km/h");
        d2.addStatistic(2, "MASS", 65, "kg");
        d2.addStatistic(3, "DURABILITY", 70, "HP");
        d2.addStatistic(4, "INTELLIGENCE", 60, "IQ");
        d2.addStatistic(5, "MAGIC POWER", 65, "MP");

        cards.add(d2);

        // D3
        CardInfo d3 = new CardInfo(
                "D3",
                "Basilisk",
                "SERPENT",
                R.drawable.mythical_monsters_d3,
                'D',
                3,
                false
        );

        d3.addStatistic(0, "STRENGTH", 55, "STR");
        d3.addStatistic(1, "SPEED", 50, "km/h");
        d3.addStatistic(2, "MASS", 50, "kg");
        d3.addStatistic(3, "DURABILITY", 60, "HP");
        d3.addStatistic(4, "INTELLIGENCE", 65, "IQ");
        d3.addStatistic(5, "MAGIC POWER", 95, "MP");

        cards.add(d3);

        // D4
        CardInfo d4 = new CardInfo(
                "D4",
                "Wyvern",
                "DRAGON",
                R.drawable.mythical_monsters_d4,
                'D',
                4,
                false
        );

        d4.addStatistic(0, "STRENGTH", 80, "STR");
        d4.addStatistic(1, "SPEED", 85, "km/h");
        d4.addStatistic(2, "MASS", 78, "kg");
        d4.addStatistic(3, "DURABILITY", 80, "HP");
        d4.addStatistic(4, "INTELLIGENCE", 55, "IQ");
        d4.addStatistic(5, "MAGIC POWER", 65, "MP");

        cards.add(d4);


        // =========================
        // E
        // =========================

        // E1
        CardInfo e1 = new CardInfo(
                "E1",
                "Centaur",
                "HYBRID",
                R.drawable.mythical_monsters_e1,
                'E',
                1,
                false
        );

        e1.addStatistic(0, "STRENGTH", 75, "STR");
        e1.addStatistic(1, "SPEED", 82, "km/h");
        e1.addStatistic(2, "MASS", 72, "kg");
        e1.addStatistic(3, "DURABILITY", 70, "HP");
        e1.addStatistic(4, "INTELLIGENCE", 80, "IQ");
        e1.addStatistic(5, "MAGIC POWER", 35, "MP");

        cards.add(e1);

        // E2
        CardInfo e2 = new CardInfo(
                "E2",
                "Satyr",
                "HYBRID",
                R.drawable.mythical_monsters_e2,
                'E',
                2,
                false
        );

        e2.addStatistic(0, "STRENGTH", 45, "STR");
        e2.addStatistic(1, "SPEED", 78, "km/h");
        e2.addStatistic(2, "MASS", 40, "kg");
        e2.addStatistic(3, "DURABILITY", 50, "HP");
        e2.addStatistic(4, "INTELLIGENCE", 65, "IQ");
        e2.addStatistic(5, "MAGIC POWER", 70, "MP");

        cards.add(e2);

        // E3
        CardInfo e3 = new CardInfo(
                "E3",
                "Siren",
                "ENCHANTRESS",
                R.drawable.mythical_monsters_e3,
                'E',
                3,
                false
        );

        e3.addStatistic(0, "STRENGTH", 40, "STR");
        e3.addStatistic(1, "SPEED", 65, "km/h");
        e3.addStatistic(2, "MASS", 45, "kg");
        e3.addStatistic(3, "DURABILITY", 45, "HP");
        e3.addStatistic(4, "INTELLIGENCE", 85, "IQ");
        e3.addStatistic(5, "MAGIC POWER", 90, "MP");

        cards.add(e3);

        // E4
        CardInfo e4 = new CardInfo(
                "E4",
                "Harpy",
                "FLYING CREATURE",
                R.drawable.mythical_monsters_e4,
                'E',
                4,
                false
        );

        e4.addStatistic(0, "STRENGTH", 55, "STR");
        e4.addStatistic(1, "SPEED", 92, "km/h");
        e4.addStatistic(2, "MASS", 50, "kg");
        e4.addStatistic(3, "DURABILITY", 55, "HP");
        e4.addStatistic(4, "INTELLIGENCE", 60, "IQ");
        e4.addStatistic(5, "MAGIC POWER", 65, "MP");

        cards.add(e4);


        // =========================
        // F
        // =========================

        // F1
        CardInfo f1 = new CardInfo(
                "F1",
                "Scylla",
                "SEA MONSTER",
                R.drawable.mythical_monsters_f1,
                'F',
                1,
                false
        );

        f1.addStatistic(0, "STRENGTH", 90, "STR");
        f1.addStatistic(1, "SPEED", 55, "km/h");
        f1.addStatistic(2, "MASS", 88, "kg");
        f1.addStatistic(3, "DURABILITY", 92, "HP");
        f1.addStatistic(4, "INTELLIGENCE", 60, "IQ");
        f1.addStatistic(5, "MAGIC POWER", 80, "MP");

        cards.add(f1);

        // F2
        CardInfo f2 = new CardInfo(
                "F2",
                "Charybdis",
                "SEA MONSTER",
                R.drawable.mythical_monsters_f2,
                'F',
                2,
                false
        );

        f2.addStatistic(0, "STRENGTH", 85, "STR");
        f2.addStatistic(1, "SPEED", 25, "km/h");
        f2.addStatistic(2, "MASS", 100, "kg");
        f2.addStatistic(3, "DURABILITY", 95, "HP");
        f2.addStatistic(4, "INTELLIGENCE", 55, "IQ");
        f2.addStatistic(5, "MAGIC POWER", 90, "MP");

        cards.add(f2);

        // F3
        CardInfo f3 = new CardInfo(
                "F3",
                "Echidna",
                "HYBRID",
                R.drawable.mythical_monsters_f3,
                'F',
                3,
                false
        );

        f3.addStatistic(0, "STRENGTH", 70, "STR");
        f3.addStatistic(1, "SPEED", 60, "km/h");
        f3.addStatistic(2, "MASS", 75, "kg");
        f3.addStatistic(3, "DURABILITY", 72, "HP");
        f3.addStatistic(4, "INTELLIGENCE", 85, "IQ");
        f3.addStatistic(5, "MAGIC POWER", 88, "MP");

        cards.add(f3);

        // F4
        CardInfo f4 = new CardInfo(
                "F4",
                "Typhon",
                "GIANT",
                R.drawable.mythical_monsters_f4,
                'F',
                4,
                false
        );

        f4.addStatistic(0, "STRENGTH", 100, "STR");
        f4.addStatistic(1, "SPEED", 65, "km/h");
        f4.addStatistic(2, "MASS", 100, "kg");
        f4.addStatistic(3, "DURABILITY", 40, "HP");
        f4.addStatistic(4, "INTELLIGENCE", 65, "IQ");
        f4.addStatistic(5, "MAGIC POWER", 98, "MP");

        cards.add(f4);


        // =========================
        // G
        // =========================

        // G1
        CardInfo g1 = new CardInfo(
                "G1",
                "Anubis",
                "GOD",
                R.drawable.mythical_monsters_g1,
                'G',
                1,
                false
        );

        g1.addStatistic(0, "STRENGTH", 72, "STR");
        g1.addStatistic(1, "SPEED", 75, "km/h");
        g1.addStatistic(2, "MASS", 68, "kg");
        g1.addStatistic(3, "DURABILITY", 78, "HP");
        g1.addStatistic(4, "INTELLIGENCE", 90, "IQ");
        g1.addStatistic(5, "MAGIC POWER", 95, "MP");

        cards.add(g1);

        // G2
        CardInfo g2 = new CardInfo(
                "G2",
                "Ammit",
                "GODDESS",
                R.drawable.mythical_monsters_g2,
                'G',
                2,
                false
        );

        g2.addStatistic(0, "STRENGTH", 88, "STR");
        g2.addStatistic(1, "SPEED", 60, "km/h");
        g2.addStatistic(2, "MASS", 82, "kg");
        g2.addStatistic(3, "DURABILITY", 90, "HP");
        g2.addStatistic(4, "INTELLIGENCE", 65, "IQ");
        g2.addStatistic(5, "MAGIC POWER", 70, "MP");

        cards.add(g2);

        // G3
        CardInfo g3 = new CardInfo(
                "G3",
                "Apep",
                "SERPENT",
                R.drawable.mythical_monsters_g3,
                'G',
                3,
                false
        );

        g3.addStatistic(0, "STRENGTH", 55, "STR");
        g3.addStatistic(1, "SPEED", 50, "km/h");
        g3.addStatistic(2, "MASS", 100, "kg");
        g3.addStatistic(3, "DURABILITY", 98, "HP");
        g3.addStatistic(4, "INTELLIGENCE", 75, "IQ");
        g3.addStatistic(5, "MAGIC POWER", 100, "MP");

        cards.add(g3);

        // G4
        CardInfo g4 = new CardInfo(
                "G4",
                "Lamia",
                "HYBRID",
                R.drawable.mythical_monsters_g4,
                'G',
                4,
                false
        );

        g4.addStatistic(0, "STRENGTH", 55, "STR");
        g4.addStatistic(1, "SPEED", 72, "km/h");
        g4.addStatistic(2, "MASS", 58, "kg");
        g4.addStatistic(3, "DURABILITY", 60, "HP");
        g4.addStatistic(4, "INTELLIGENCE", 88, "IQ");
        g4.addStatistic(5, "MAGIC POWER", 82, "MP");

        cards.add(g4);


        // =========================
        // H
        // =========================

        // H1
        CardInfo h1 = new CardInfo(
                "H1",
                "Jormungandr",
                "MYTHICAL MONSTER",
                R.drawable.mythical_monsters_h1,
                'H',
                1,
                false
        );

        h1.addStatistic(0, "STRENGTH", 99, "STR");
        h1.addStatistic(1, "SPEED", 45, "km/h");
        h1.addStatistic(2, "MASS", 100, "kg");
        h1.addStatistic(3, "DURABILITY", 100, "HP");
        h1.addStatistic(4, "INTELLIGENCE", 30, "IQ");
        h1.addStatistic(5, "MAGIC POWER", 35, "MP");

        cards.add(h1);

        // H2
        CardInfo h2 = new CardInfo(
                "H2",
                "Fenrir",
                "BEAST",
                R.drawable.mythical_monsters_h2,
                'H',
                2,
                false
        );

        h2.addStatistic(0, "STRENGTH", 97, "STR");
        h2.addStatistic(1, "SPEED", 85, "km/h");
        h2.addStatistic(2, "MASS", 90, "kg");
        h2.addStatistic(3, "DURABILITY", 95, "HP");
        h2.addStatistic(4, "INTELLIGENCE", 75, "IQ");
        h2.addStatistic(5, "MAGIC POWER", 65, "MP");

        cards.add(h2);

        // H3
        CardInfo h3 = new CardInfo(
                "H3",
                "Orthrus",
                "BEAST",
                R.drawable.mythical_monsters_h3,
                'H',
                3,
                false
        );

        h3.addStatistic(0, "STRENGTH", 82, "STR");
        h3.addStatistic(1, "SPEED", 78, "km/h");
        h3.addStatistic(2, "MASS", 72, "kg");
        h3.addStatistic(3, "DURABILITY", 85, "HP");
        h3.addStatistic(4, "INTELLIGENCE", 55, "IQ");
        h3.addStatistic(5, "MAGIC POWER", 50, "MP");

        cards.add(h3);

        // H4
        CardInfo h4 = new CardInfo(
                "H4",
                "Yeti",
                "MYTHICAL MONSTER",
                R.drawable.mythical_monsters_h4,
                'H',
                4,
                true
        );

        h4.addStatistic(0, "STRENGTH", 80, "STR");
        h4.addStatistic(1, "SPEED", 50, "km/h");
        h4.addStatistic(2, "MASS", 80, "kg");
        h4.addStatistic(3, "DURABILITY", 88, "HP");
        h4.addStatistic(4, "INTELLIGENCE", 60, "IQ");
        h4.addStatistic(5, "MAGIC POWER", 55, "MP");

        cards.add(h4);
    }

    public List<CardInfo> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}