package com.example.superultima.decks;

import com.example.superultima.R;
import com.example.superultima.cardgame.CardInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MythicalGods {

    private final List<CardInfo> cards = new ArrayList<>();

    public MythicalGods() {

        // =========================
        // A
        // =========================

        CardInfo a1 = new CardInfo(
                "A1",
                "Zeus",
                "GREEK GOD",
                R.drawable.gods_a1,
                'A',
                1,
                false
        );
        a1.addStatistic(0, "DIVINE POWER", 80, "");
        a1.addStatistic(1, "COMBAT", 79, "");
        a1.addStatistic(2, "SPEED", 52, "");
        a1.addStatistic(3, "WISDOM", 62, "");
        a1.addStatistic(4, "MAGIC", 99, "");
        a1.addStatistic(5, "INFLUENCE", 51, "");
        cards.add(a1);

        CardInfo a2 = new CardInfo(
                "A2",
                "Amaterasu",
                "JAPANESE GODDESS",
                R.drawable.gods_a2,
                'A',
                2,
                false
        );
        a2.addStatistic(0, "DIVINE POWER", 64, "");
        a2.addStatistic(1, "COMBAT", 97, "");
        a2.addStatistic(2, "SPEED", 58, "");
        a2.addStatistic(3, "WISDOM", 65, "");
        a2.addStatistic(4, "MAGIC", 78, "");
        a2.addStatistic(5, "INFLUENCE", 78, "");
        cards.add(a2);

        CardInfo a3 = new CardInfo(
                "A3",
                "Anubis",
                "EGYPTIAN GOD",
                R.drawable.gods_a3,
                'A',
                3,
                false
        );
        a3.addStatistic(0, "DIVINE POWER", 93, "");
        a3.addStatistic(1, "COMBAT", 85, "");
        a3.addStatistic(2, "SPEED", 42, "");
        a3.addStatistic(3, "WISDOM", 73, "");
        a3.addStatistic(4, "MAGIC", 81, "");
        a3.addStatistic(5, "INFLUENCE", 67, "");
        cards.add(a3);

        CardInfo a4 = new CardInfo(
                "A4",
                "Shiva",
                "HINDU GOD",
                R.drawable.gods_a4,
                'A',
                4,
                false
        );
        a4.addStatistic(0, "DIVINE POWER", 76, "");
        a4.addStatistic(1, "COMBAT", 72, "");
        a4.addStatistic(2, "SPEED", 58, "");
        a4.addStatistic(3, "WISDOM", 71, "");
        a4.addStatistic(4, "MAGIC", 69, "");
        a4.addStatistic(5, "INFLUENCE", 79, "");
        cards.add(a4);


        // =========================
        // B
        // =========================

        CardInfo b1 = new CardInfo(
                "B1",
                "Thor",
                "NORSE GOD",
                R.drawable.gods_b1,
                'B',
                1,
                false
        );
        b1.addStatistic(0, "DIVINE POWER", 95, "");
        b1.addStatistic(1, "COMBAT", 57, "");
        b1.addStatistic(2, "SPEED", 87, "");
        b1.addStatistic(3, "WISDOM", 72, "");
        b1.addStatistic(4, "MAGIC", 96, "");
        b1.addStatistic(5, "INFLUENCE", 53, "");
        cards.add(b1);

        CardInfo b2 = new CardInfo(
                "B2",
                "Quetzalcoatl",
                "AZTEC GOD",
                R.drawable.gods_b2,
                'B',
                2,
                false
        );
        b2.addStatistic(0, "DIVINE POWER", 64, "");
        b2.addStatistic(1, "COMBAT", 79, "");
        b2.addStatistic(2, "SPEED", 96, "");
        b2.addStatistic(3, "WISDOM", 65, "");
        b2.addStatistic(4, "MAGIC", 91, "");
        b2.addStatistic(5, "INFLUENCE", 77, "");
        cards.add(b2);

        CardInfo b3 = new CardInfo(
                "B3",
                "Athena",
                "GREEK GODDESS",
                R.drawable.gods_b3,
                'B',
                3,
                false
        );
        b3.addStatistic(0, "DIVINE POWER", 67, "");
        b3.addStatistic(1, "COMBAT", 36, "");
        b3.addStatistic(2, "SPEED", 90, "");
        b3.addStatistic(3, "WISDOM", 75, "");
        b3.addStatistic(4, "MAGIC", 77, "");
        b3.addStatistic(5, "INFLUENCE", 99, "");
        cards.add(b3);

        CardInfo b4 = new CardInfo(
                "B4",
                "Ra",
                "EGYPTIAN GOD",
                R.drawable.gods_b4,
                'B',
                4,
                false
        );
        b4.addStatistic(0, "DIVINE POWER", 80, "");
        b4.addStatistic(1, "COMBAT", 85, "");
        b4.addStatistic(2, "SPEED", 56, "");
        b4.addStatistic(3, "WISDOM", 40, "");
        b4.addStatistic(4, "MAGIC", 62, "");
        b4.addStatistic(5, "INFLUENCE", 73, "");
        cards.add(b4);


        // =========================
        // C
        // =========================

        CardInfo c1 = new CardInfo(
                "C1",
                "Odin",
                "NORSE GOD",
                R.drawable.gods_c1,
                'C',
                1,
                false
        );
        c1.addStatistic(0, "DIVINE POWER", 86, "");
        c1.addStatistic(1, "COMBAT", 53, "");
        c1.addStatistic(2, "SPEED", 92, "");
        c1.addStatistic(3, "WISDOM", 97, "");
        c1.addStatistic(4, "MAGIC", 67, "");
        c1.addStatistic(5, "INFLUENCE", 86, "");
        cards.add(c1);

        CardInfo c2 = new CardInfo(
                "C2",
                "Ganesha",
                "HINDU GOD",
                R.drawable.gods_c2,
                'C',
                2,
                false
        );
        c2.addStatistic(0, "DIVINE POWER", 74, "");
        c2.addStatistic(1, "COMBAT", 77, "");
        c2.addStatistic(2, "SPEED", 77, "");
        c2.addStatistic(3, "WISDOM", 82, "");
        c2.addStatistic(4, "MAGIC", 79, "");
        c2.addStatistic(5, "INFLUENCE", 93, "");
        cards.add(c2);

        CardInfo c3 = new CardInfo(
                "C3",
                "Poseidon",
                "GREEK GOD",
                R.drawable.gods_c3,
                'C',
                3,
                false
        );
        c3.addStatistic(0, "DIVINE POWER", 45, "");
        c3.addStatistic(1, "COMBAT", 90, "");
        c3.addStatistic(2, "SPEED", 84, "");
        c3.addStatistic(3, "WISDOM", 85, "");
        c3.addStatistic(4, "MAGIC", 96, "");
        c3.addStatistic(5, "INFLUENCE", 62, "");
        cards.add(c3);

        CardInfo c4 = new CardInfo(
                "C4",
                "Marduk",
                "MESOPOTAMIAN GOD",
                R.drawable.gods_c4,
                'C',
                4,
                false
        );
        c4.addStatistic(0, "DIVINE POWER", 98, "");
        c4.addStatistic(1, "COMBAT", 49, "");
        c4.addStatistic(2, "SPEED", 38, "");
        c4.addStatistic(3, "WISDOM", 73, "");
        c4.addStatistic(4, "MAGIC", 99, "");
        c4.addStatistic(5, "INFLUENCE", 83, "");
        cards.add(c4);


        // =========================
        // D
        // =========================

        CardInfo d1 = new CardInfo(
                "D1",
                "Freyja",
                "NORSE GODDESS",
                R.drawable.gods_d1,
                'D',
                1,
                false
        );
        d1.addStatistic(0, "DIVINE POWER", 74, "");
        d1.addStatistic(1, "COMBAT", 85, "");
        d1.addStatistic(2, "SPEED", 71, "");
        d1.addStatistic(3, "WISDOM", 60, "");
        d1.addStatistic(4, "MAGIC", 73, "");
        d1.addStatistic(5, "INFLUENCE", 74, "");
        cards.add(d1);

        CardInfo d2 = new CardInfo(
                "D2",
                "Horus",
                "EGYPTIAN GOD",
                R.drawable.gods_d2,
                'D',
                2,
                false
        );
        d2.addStatistic(0, "DIVINE POWER", 71, "");
        d2.addStatistic(1, "COMBAT", 47, "");
        d2.addStatistic(2, "SPEED", 78, "");
        d2.addStatistic(3, "WISDOM", 94, "");
        d2.addStatistic(4, "MAGIC", 93, "");
        d2.addStatistic(5, "INFLUENCE", 79, "");
        cards.add(d2);

        CardInfo d3 = new CardInfo(
                "D3",
                "Krishna",
                "HINDU GOD",
                R.drawable.gods_d3,
                'D',
                3,
                false
        );
        d3.addStatistic(0, "DIVINE POWER", 53, "");
        d3.addStatistic(1, "COMBAT", 97, "");
        d3.addStatistic(2, "SPEED", 70, "");
        d3.addStatistic(3, "WISDOM", 58, "");
        d3.addStatistic(4, "MAGIC", 64, "");
        d3.addStatistic(5, "INFLUENCE", 94, "");
        cards.add(d3);

        CardInfo d4 = new CardInfo(
                "D4",
                "Hades",
                "GREEK GOD",
                R.drawable.gods_d4,
                'D',
                4,
                false
        );
        d4.addStatistic(0, "DIVINE POWER", 69, "");
        d4.addStatistic(1, "COMBAT", 87, "");
        d4.addStatistic(2, "SPEED", 51, "");
        d4.addStatistic(3, "WISDOM", 89, "");
        d4.addStatistic(4, "MAGIC", 73, "");
        d4.addStatistic(5, "INFLUENCE", 95, "");
        cards.add(d4);


        // =========================
        // E
        // =========================

        CardInfo e1 = new CardInfo(
                "E1",
                "Susanoo-no-Mikoto",
                "JAPANESE GOD",
                R.drawable.gods_e1,
                'E',
                1,
                false
        );
        e1.addStatistic(0, "DIVINE POWER", 70, "");
        e1.addStatistic(1, "COMBAT", 81, "");
        e1.addStatistic(2, "SPEED", 92, "");
        e1.addStatistic(3, "WISDOM", 97, "");
        e1.addStatistic(4, "MAGIC", 91, "");
        e1.addStatistic(5, "INFLUENCE", 67, "");
        cards.add(e1);

        CardInfo e2 = new CardInfo(
                "E2",
                "Apollo",
                "GREEK GOD",
                R.drawable.gods_e2,
                'E',
                2,
                false
        );
        e2.addStatistic(0, "DIVINE POWER", 68, "");
        e2.addStatistic(1, "COMBAT", 95, "");
        e2.addStatistic(2, "SPEED", 89, "");
        e2.addStatistic(3, "WISDOM", 91, "");
        e2.addStatistic(4, "MAGIC", 81, "");
        e2.addStatistic(5, "INFLUENCE", 94, "");
        cards.add(e2);

        CardInfo e3 = new CardInfo(
                "E3",
                "Isis",
                "EGYPTIAN GODDESS",
                R.drawable.gods_e3,
                'E',
                3,
                false
        );
        e3.addStatistic(0, "DIVINE POWER", 93, "");
        e3.addStatistic(1, "COMBAT", 59, "");
        e3.addStatistic(2, "SPEED", 88, "");
        e3.addStatistic(3, "WISDOM", 53, "");
        e3.addStatistic(4, "MAGIC", 90, "");
        e3.addStatistic(5, "INFLUENCE", 94, "");
        cards.add(e3);

        CardInfo e4 = new CardInfo(
                "E4",
                "Indra",
                "HINDU GOD",
                R.drawable.gods_e4,
                'E',
                4,
                false
        );
        e4.addStatistic(0, "DIVINE POWER", 69, "");
        e4.addStatistic(1, "COMBAT", 92, "");
        e4.addStatistic(2, "SPEED", 57, "");
        e4.addStatistic(3, "WISDOM", 91, "");
        e4.addStatistic(4, "MAGIC", 93, "");
        e4.addStatistic(5, "INFLUENCE", 81, "");
        cards.add(e4);


        // =========================
        // F
        // =========================

        CardInfo f1 = new CardInfo(
                "F1",
                "Loki",
                "NORSE GOD",
                R.drawable.gods_f1,
                'F',
                1,
                false
        );
        f1.addStatistic(0, "DIVINE POWER", 94, "");
        f1.addStatistic(1, "COMBAT", 59, "");
        f1.addStatistic(2, "SPEED", 100, "");
        f1.addStatistic(3, "WISDOM", 84, "");
        f1.addStatistic(4, "MAGIC", 80, "");
        f1.addStatistic(5, "INFLUENCE", 97, "");
        cards.add(f1);

        CardInfo f2 = new CardInfo(
                "F2",
                "Tezcatlipoca",
                "AZTEC GOD",
                R.drawable.gods_f2,
                'F',
                2,
                false
        );
        f2.addStatistic(0, "DIVINE POWER", 37, "");
        f2.addStatistic(1, "COMBAT", 100, "");
        f2.addStatistic(2, "SPEED", 97, "");
        f2.addStatistic(3, "WISDOM", 76, "");
        f2.addStatistic(4, "MAGIC", 89, "");
        f2.addStatistic(5, "INFLUENCE", 68, "");
        cards.add(f2);

        CardInfo f3 = new CardInfo(
                "F3",
                "Vishnu",
                "HINDU GOD",
                R.drawable.gods_f3,
                'F',
                3,
                false
        );
        f3.addStatistic(0, "DIVINE POWER", 82, "");
        f3.addStatistic(1, "COMBAT", 91, "");
        f3.addStatistic(2, "SPEED", 57, "");
        f3.addStatistic(3, "WISDOM", 89, "");
        f3.addStatistic(4, "MAGIC", 36, "");
        f3.addStatistic(5, "INFLUENCE", 96, "");
        cards.add(f3);

        CardInfo f4 = new CardInfo(
                "F4",
                "Ares",
                "GREEK GOD",
                R.drawable.gods_f4,
                'F',
                4,
                false
        );
        f4.addStatistic(0, "DIVINE POWER", 89, "");
        f4.addStatistic(1, "COMBAT", 89, "");
        f4.addStatistic(2, "SPEED", 77, "");
        f4.addStatistic(3, "WISDOM", 87, "");
        f4.addStatistic(4, "MAGIC", 55, "");
        f4.addStatistic(5, "INFLUENCE", 60, "");
        cards.add(f4);


        // =========================
        // G
        // =========================

        CardInfo g1 = new CardInfo(
                "G1",
                "Hermes",
                "GREEK GOD",
                R.drawable.gods_g1,
                'G',
                1,
                false
        );
        g1.addStatistic(0, "DIVINE POWER", 57, "");
        g1.addStatistic(1, "COMBAT", 85, "");
        g1.addStatistic(2, "SPEED", 51, "");
        g1.addStatistic(3, "WISDOM", 100, "");
        g1.addStatistic(4, "MAGIC", 71, "");
        g1.addStatistic(5, "INFLUENCE", 98, "");
        cards.add(g1);

        CardInfo g2 = new CardInfo(
                "G2",
                "Osiris",
                "EGYPTIAN GOD",
                R.drawable.gods_g2,
                'G',
                2,
                false
        );
        g2.addStatistic(0, "DIVINE POWER", 69, "");
        g2.addStatistic(1, "COMBAT", 80, "");
        g2.addStatistic(2, "SPEED", 81, "");
        g2.addStatistic(3, "WISDOM", 78, "");
        g2.addStatistic(4, "MAGIC", 93, "");
        g2.addStatistic(5, "INFLUENCE", 81, "");
        cards.add(g2);

        CardInfo g3 = new CardInfo(
                "G3",
                "Perun",
                "SLAVIC GOD",
                R.drawable.gods_g3,
                'G',
                3,
                false
        );
        g3.addStatistic(0, "DIVINE POWER", 80, "");
        g3.addStatistic(1, "COMBAT", 100, "");
        g3.addStatistic(2, "SPEED", 50, "");
        g3.addStatistic(3, "WISDOM", 79, "");
        g3.addStatistic(4, "MAGIC", 80, "");
        g3.addStatistic(5, "INFLUENCE", 84, "");
        cards.add(g3);

        CardInfo g4 = new CardInfo(
                "G4",
                "Jade Emperor",
                "CHINESE DEITY",
                R.drawable.gods_g4,
                'G',
                4,
                false
        );
        g4.addStatistic(0, "DIVINE POWER", 80, "");
        g4.addStatistic(1, "COMBAT", 79, "");
        g4.addStatistic(2, "SPEED", 98, "");
        g4.addStatistic(3, "WISDOM", 91, "");
        g4.addStatistic(4, "MAGIC", 46, "");
        g4.addStatistic(5, "INFLUENCE", 88, "");
        cards.add(g4);


        // =========================
        // H
        // =========================

        CardInfo h1 = new CardInfo(
                "H1",
                "Artemis",
                "GREEK GODDESS",
                R.drawable.gods_h1,
                'H',
                1,
                false
        );
        h1.addStatistic(0, "DIVINE POWER", 88, "");
        h1.addStatistic(1, "COMBAT", 68, "");
        h1.addStatistic(2, "SPEED", 98, "");
        h1.addStatistic(3, "WISDOM", 37, "");
        h1.addStatistic(4, "MAGIC", 42, "");
        h1.addStatistic(5, "INFLUENCE", 83, "");
        cards.add(h1);

        CardInfo h2 = new CardInfo(
                "H2",
                "Tyr",
                "NORSE GOD",
                R.drawable.gods_h2,
                'H',
                2,
                false
        );
        h2.addStatistic(0, "DIVINE POWER", 82, "");
        h2.addStatistic(1, "COMBAT", 56, "");
        h2.addStatistic(2, "SPEED", 86, "");
        h2.addStatistic(3, "WISDOM", 97, "");
        h2.addStatistic(4, "MAGIC", 66, "");
        h2.addStatistic(5, "INFLUENCE", 87, "");
        cards.add(h2);

        CardInfo h3 = new CardInfo(
                "H3",
                "Kali",
                "HINDU GODDESS",
                R.drawable.gods_h3,
                'H',
                3,
                false
        );
        h3.addStatistic(0, "DIVINE POWER", 69, "");
        h3.addStatistic(1, "COMBAT", 61, "");
        h3.addStatistic(2, "SPEED", 100, "");
        h3.addStatistic(3, "WISDOM", 92, "");
        h3.addStatistic(4, "MAGIC", 94, "");
        h3.addStatistic(5, "INFLUENCE", 70, "");
        cards.add(h3);

        CardInfo h4 = new CardInfo(
                "H4",
                "Inti",
                "INCA GOD",
                R.drawable.gods_h4,
                'H',
                4,
                true
        );
        h4.addStatistic(0, "DIVINE POWER", 55, "");
        h4.addStatistic(1, "COMBAT", 50, "");
        h4.addStatistic(2, "SPEED", 45, "");
        h4.addStatistic(3, "WISDOM", 50, "");
        h4.addStatistic(4, "MAGIC", 95, "");
        h4.addStatistic(5, "INFLUENCE", 70, "");
        cards.add(h4);
    }

    public List<CardInfo> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}