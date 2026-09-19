package com.example.superultima.decks;

import com.example.superultima.R;
import com.example.superultima.cardgame.CardInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MythicalHeroes {

    private final List<CardInfo> cards = new ArrayList<>();

    public MythicalHeroes() {

        // =========================
        // A
        // =========================

        // A1
        CardInfo a1 = new CardInfo(
                "A1",
                "Achilles",
                "GREEK HERO",
                R.drawable.mythicalheroes_a1,
                'A',
                1,
                false
        );

        a1.addStatistic(0, "STRENGTH", 92, "STR");
        a1.addStatistic(1, "SPEED", 85, "km/h");
        a1.addStatistic(2, "DURABILITY", 98, "HP");
        a1.addStatistic(3, "INTELLIGENCE", 76, "IQ");
        a1.addStatistic(4, "COMBAT SKILL", 100, "CS");
        a1.addStatistic(5, "SPECIAL POWER", 95, "SP");

        cards.add(a1);

        // A2
        CardInfo a2 = new CardInfo(
                "A2",
                "Hercules",
                "GREEK HERO",
                R.drawable.mythicalheroes_a2,
                'A',
                2,
                false
        );

        a2.addStatistic(0, "STRENGTH", 99, "STR");
        a2.addStatistic(1, "SPEED", 75, "km/h");
        a2.addStatistic(2, "DURABILITY", 98, "HP");
        a2.addStatistic(3, "INTELLIGENCE", 78, "IQ");
        a2.addStatistic(4, "COMBAT SKILL", 97, "CS");
        a2.addStatistic(5, "SPECIAL POWER", 97, "SP");

        cards.add(a2);

        // A3
        CardInfo a3 = new CardInfo(
                "A3",
                "Perseus",
                "GREEK HERO",
                R.drawable.mythicalheroes_a3,
                'A',
                3,
                false
        );

        a3.addStatistic(0, "STRENGTH", 82, "STR");
        a3.addStatistic(1, "SPEED", 81, "km/h");
        a3.addStatistic(2, "DURABILITY", 88, "HP");
        a3.addStatistic(3, "INTELLIGENCE", 89, "IQ");
        a3.addStatistic(4, "COMBAT SKILL", 94, "CS");
        a3.addStatistic(5, "SPECIAL POWER", 96, "SP");

        cards.add(a3);

        // A4
        CardInfo a4 = new CardInfo(
                "A4",
                "Odysseus",
                "GREEK HERO",
                R.drawable.mythicalheroes_a4,
                'A',
                4,
                false
        );

        a4.addStatistic(0, "STRENGTH", 70, "STR");
        a4.addStatistic(1, "SPEED", 72, "km/h");
        a4.addStatistic(2, "DURABILITY", 78, "HP");
        a4.addStatistic(3, "INTELLIGENCE", 100, "IQ");
        a4.addStatistic(4, "COMBAT SKILL", 89, "CS");
        a4.addStatistic(5, "SPECIAL POWER", 81, "SP");

        cards.add(a4);


        // =========================
        // B
        // =========================

        // B1
        CardInfo b1 = new CardInfo(
                "B1",
                "Theseus",
                "GREEK HERO",
                R.drawable.mythicalheroes_b1,
                'B',
                1,
                false
        );

        b1.addStatistic(0, "STRENGTH", 95, "STR");
        b1.addStatistic(1, "SPEED", 80, "km/h");
        b1.addStatistic(2, "DURABILITY", 87, "HP");
        b1.addStatistic(3, "INTELLIGENCE", 82, "IQ");
        b1.addStatistic(4, "COMBAT SKILL", 95, "CS");
        b1.addStatistic(5, "SPECIAL POWER", 75, "SP");

        cards.add(b1);

        // B2
        CardInfo b2 = new CardInfo(
                "B2",
                "Jason",
                "GREEK HERO",
                R.drawable.mythicalheroes_b2,
                'B',
                2,
                false
        );

        b2.addStatistic(0, "STRENGTH", 78, "STR");
        b2.addStatistic(1, "SPEED", 76, "km/h");
        b2.addStatistic(2, "DURABILITY", 83, "HP");
        b2.addStatistic(3, "INTELLIGENCE", 92, "IQ");
        b2.addStatistic(4, "COMBAT SKILL", 92, "CS");
        b2.addStatistic(5, "SPECIAL POWER", 84, "SP");

        cards.add(b2);

        // B3
        CardInfo b3 = new CardInfo(
                "B3",
                "Hippolyta",
                "GREEK HERO",
                R.drawable.mythicalheroes_b3,
                'B',
                3,
                false
        );

        b3.addStatistic(0, "STRENGTH", 87, "STR");
        b3.addStatistic(1, "SPEED", 85, "km/h");
        b3.addStatistic(2, "DURABILITY", 90, "HP");
        b3.addStatistic(3, "INTELLIGENCE", 82, "IQ");
        b3.addStatistic(4, "COMBAT SKILL", 97, "CS");
        b3.addStatistic(5, "SPECIAL POWER", 85, "SP");

        cards.add(b3);

        // B4
        CardInfo b4 = new CardInfo(
                "B4",
                "Atalanta",
                "GREEK HERO",
                R.drawable.mythicalheroes_b4,
                'B',
                4,
                false
        );

        b4.addStatistic(0, "STRENGTH", 68, "STR");
        b4.addStatistic(1, "SPEED", 100, "km/h");
        b4.addStatistic(2, "DURABILITY", 74, "HP");
        b4.addStatistic(3, "INTELLIGENCE", 84, "IQ");
        b4.addStatistic(4, "COMBAT SKILL", 91, "CS");
        b4.addStatistic(5, "SPECIAL POWER", 78, "SP");

        cards.add(b4);


        // =========================
        // C
        // =========================

        // C1
        CardInfo c1 = new CardInfo(
                "C1",
                "Bellerophon",
                "GREEK HERO",
                R.drawable.mythicalheroes_c1,
                'C',
                1,
                false
        );

        c1.addStatistic(0, "STRENGTH", 87, "STR");
        c1.addStatistic(1, "SPEED", 97, "km/h");
        c1.addStatistic(2, "DURABILITY", 83, "HP");
        c1.addStatistic(3, "INTELLIGENCE", 86, "IQ");
        c1.addStatistic(4, "COMBAT SKILL", 95, "CS");
        c1.addStatistic(5, "SPECIAL POWER", 94, "SP");

        cards.add(c1);

        // C2
        CardInfo c2 = new CardInfo(
                "C2",
                "Orpheus",
                "GREEK HERO",
                R.drawable.mythicalheroes_c2,
                'C',
                2,
                false
        );

        c2.addStatistic(0, "STRENGTH", 45, "STR");
        c2.addStatistic(1, "SPEED", 55, "km/h");
        c2.addStatistic(2, "DURABILITY", 56, "HP");
        c2.addStatistic(3, "INTELLIGENCE", 92, "IQ");
        c2.addStatistic(4, "COMBAT SKILL", 45, "CS");
        c2.addStatistic(5, "SPECIAL POWER", 100, "SP");

        cards.add(c2);

        // C3
        CardInfo c3 = new CardInfo(
                "C3",
                "Cadmus",
                "GREEK HERO",
                R.drawable.mythicalheroes_c3,
                'C',
                3,
                false
        );

        c3.addStatistic(0, "STRENGTH", 80, "STR");
        c3.addStatistic(1, "SPEED", 72, "km/h");
        c3.addStatistic(2, "DURABILITY", 81, "HP");
        c3.addStatistic(3, "INTELLIGENCE", 92, "IQ");
        c3.addStatistic(4, "COMBAT SKILL", 92, "CS");
        c3.addStatistic(5, "SPECIAL POWER", 89, "SP");

        cards.add(c3);

        // C4
        CardInfo c4 = new CardInfo(
                "C4",
                "Gilgamesh",
                "MESOPOTAMIAN HERO",
                R.drawable.mythicalheroes_c4,
                'C',
                4,
                false
        );

        c4.addStatistic(0, "STRENGTH", 98, "STR");
        c4.addStatistic(1, "SPEED", 69, "km/h");
        c4.addStatistic(2, "DURABILITY", 96, "HP");
        c4.addStatistic(3, "INTELLIGENCE", 88, "IQ");
        c4.addStatistic(4, "COMBAT SKILL", 97, "CS");
        c4.addStatistic(5, "SPECIAL POWER", 90, "SP");

        cards.add(c4);


        // =========================
        // D
        // =========================

        // D1
        CardInfo d1 = new CardInfo(
                "D1",
                "Rama",
                "HINDU HERO",
                R.drawable.mythicalheroes_d1,
                'D',
                1,
                false
        );

        d1.addStatistic(0, "STRENGTH", 90, "STR");
        d1.addStatistic(1, "SPEED", 83, "km/h");
        d1.addStatistic(2, "DURABILITY", 92, "HP");
        d1.addStatistic(3, "INTELLIGENCE", 91, "IQ");
        d1.addStatistic(4, "COMBAT SKILL", 98, "CS");
        d1.addStatistic(5, "SPECIAL POWER", 95, "SP");

        cards.add(d1);

        // D2
        CardInfo d2 = new CardInfo(
                "D2",
                "Sigurd",
                "NORSE HERO",
                R.drawable.mythicalheroes_d2,
                'D',
                2,
                false
        );

        d2.addStatistic(0, "STRENGTH", 95, "STR");
        d2.addStatistic(1, "SPEED", 79, "km/h");
        d2.addStatistic(2, "DURABILITY", 95, "HP");
        d2.addStatistic(3, "INTELLIGENCE", 84, "IQ");
        d2.addStatistic(4, "COMBAT SKILL", 97, "CS");
        d2.addStatistic(5, "SPECIAL POWER", 92, "SP");

        cards.add(d2);

        // D3
        CardInfo d3 = new CardInfo(
                "D3",
                "Beowulf",
                "ANGLO-SAXON HERO",
                R.drawable.mythicalheroes_d3,
                'D',
                3,
                false
        );

        d3.addStatistic(0, "STRENGTH", 98, "STR");
        d3.addStatistic(1, "SPEED", 72, "km/h");
        d3.addStatistic(2, "DURABILITY", 95, "HP");
        d3.addStatistic(3, "INTELLIGENCE", 76, "IQ");
        d3.addStatistic(4, "COMBAT SKILL", 98, "CS");
        d3.addStatistic(5, "SPECIAL POWER", 86, "SP");

        cards.add(d3);

        // D4
        CardInfo d4 = new CardInfo(
                "D4",
                "King Arthur",
                "BRITISH HERO",
                R.drawable.mythicalheroes_d4,
                'D',
                4,
                false
        );

        d4.addStatistic(0, "STRENGTH", 88, "STR");
        d4.addStatistic(1, "SPEED", 78, "km/h");
        d4.addStatistic(2, "DURABILITY", 88, "HP");
        d4.addStatistic(3, "INTELLIGENCE", 91, "IQ");
        d4.addStatistic(4, "COMBAT SKILL", 98, "CS");
        d4.addStatistic(5, "SPECIAL POWER", 96, "SP");

        cards.add(d4);


        // =========================
        // E
        // =========================

        // E1
        CardInfo e1 = new CardInfo(
                "E1",
                "Lancelot",
                "BRITISH HERO",
                R.drawable.mythicalheroes_e1,
                'E',
                1,
                false
        );

        e1.addStatistic(0, "STRENGTH", 91, "STR");
        e1.addStatistic(1, "SPEED", 84, "km/h");
        e1.addStatistic(2, "DURABILITY", 90, "HP");
        e1.addStatistic(3, "INTELLIGENCE", 82, "IQ");
        e1.addStatistic(4, "COMBAT SKILL", 100, "CS");
        e1.addStatistic(5, "SPECIAL POWER", 80, "SP");

        cards.add(e1);

        // E2
        CardInfo e2 = new CardInfo(
                "E2",
                "Cú Chulainn",
                "IRISH HERO",
                R.drawable.mythicalheroes_e2,
                'E',
                2,
                false
        );

        e2.addStatistic(0, "STRENGTH", 97, "STR");
        e2.addStatistic(1, "SPEED", 89, "km/h");
        e2.addStatistic(2, "DURABILITY", 96, "HP");
        e2.addStatistic(3, "INTELLIGENCE", 77, "IQ");
        e2.addStatistic(4, "COMBAT SKILL", 100, "CS");
        e2.addStatistic(5, "SPECIAL POWER", 98, "SP");

        cards.add(e2);

        // E3
        CardInfo e3 = new CardInfo(
                "E3",
                "Fionn mac Cumhaill",
                "IRISH HERO",
                R.drawable.mythicalheroes_e3,
                'E',
                3,
                false
        );

        e3.addStatistic(0, "STRENGTH", 90, "STR");
        e3.addStatistic(1, "SPEED", 78, "km/h");
        e3.addStatistic(2, "DURABILITY", 92, "HP");
        e3.addStatistic(3, "INTELLIGENCE", 95, "IQ");
        e3.addStatistic(4, "COMBAT SKILL", 91, "CS");
        e3.addStatistic(5, "SPECIAL POWER", 94, "SP");

        cards.add(e3);

        // E4
        CardInfo e4 = new CardInfo(
                "E4",
                "Mulan",
                "CHINESE HERO",
                R.drawable.mythicalheroes_e4,
                'E',
                4,
                false
        );

        e4.addStatistic(0, "STRENGTH", 70, "STR");
        e4.addStatistic(1, "SPEED", 81, "km/h");
        e4.addStatistic(2, "DURABILITY", 78, "HP");
        e4.addStatistic(3, "INTELLIGENCE", 92, "IQ");
        e4.addStatistic(4, "COMBAT SKILL", 92, "CS");
        e4.addStatistic(5, "SPECIAL POWER", 55, "SP");

        cards.add(e4);


        // =========================
        // F
        // =========================

        // F1
        CardInfo f1 = new CardInfo(
                "F1",
                "Sun Wukong",
                "CHINESE HERO",
                R.drawable.mythicalheroes_f1,
                'F',
                1,
                false
        );

        f1.addStatistic(0, "STRENGTH", 80, "STR");
        f1.addStatistic(1, "SPEED", 70, "km/h");
        f1.addStatistic(2, "DURABILITY", 90, "HP");
        f1.addStatistic(3, "INTELLIGENCE", 91, "IQ");
        f1.addStatistic(4, "COMBAT SKILL", 97, "CS");
        f1.addStatistic(5, "SPECIAL POWER", 100, "SP");

        cards.add(f1);

        // F2
        CardInfo f2 = new CardInfo(
                "F2",
                "Rustam",
                "PERSIAN HERO",
                R.drawable.mythicalheroes_f2,
                'F',
                2,
                false
        );

        f2.addStatistic(0, "STRENGTH", 97, "STR");
        f2.addStatistic(1, "SPEED", 74, "km/h");
        f2.addStatistic(2, "DURABILITY", 96, "HP");
        f2.addStatistic(3, "INTELLIGENCE", 82, "IQ");
        f2.addStatistic(4, "COMBAT SKILL", 100, "CS");
        f2.addStatistic(5, "SPECIAL POWER", 88, "SP");

        cards.add(f2);

        // F3
        CardInfo f3 = new CardInfo(
                "F3",
                "Arjuna",
                "HINDU HERO",
                R.drawable.mythicalheroes_f3,
                'F',
                3,
                false
        );

        f3.addStatistic(0, "STRENGTH", 88, "STR");
        f3.addStatistic(1, "SPEED", 82, "km/h");
        f3.addStatistic(2, "DURABILITY", 88, "HP");
        f3.addStatistic(3, "INTELLIGENCE", 91, "IQ");
        f3.addStatistic(4, "COMBAT SKILL", 100, "CS");
        f3.addStatistic(5, "SPECIAL POWER", 94, "SP");

        cards.add(f3);

        // F4
        CardInfo f4 = new CardInfo(
                "F4",
                "Yi the Archer",
                "CHINESE HERO",
                R.drawable.mythicalheroes_f4,
                'F',
                4,
                false
        );

        f4.addStatistic(0, "STRENGTH", 65, "STR");
        f4.addStatistic(1, "SPEED", 75, "km/h");
        f4.addStatistic(2, "DURABILITY", 72, "HP");
        f4.addStatistic(3, "INTELLIGENCE", 87, "IQ");
        f4.addStatistic(4, "COMBAT SKILL", 99, "CS");
        f4.addStatistic(5, "SPECIAL POWER", 95, "SP");

        cards.add(f4);


        // =========================
        // G
        // =========================

        // G1
        CardInfo g1 = new CardInfo(
                "G1",
                "Ragnar Lothbrok",
                "NORSE HERO",
                R.drawable.mythicalheroes_g1,
                'G',
                1,
                false
        );

        g1.addStatistic(0, "STRENGTH", 86, "STR");
        g1.addStatistic(1, "SPEED", 74, "km/h");
        g1.addStatistic(2, "DURABILITY", 84, "HP");
        g1.addStatistic(3, "INTELLIGENCE", 92, "IQ");
        g1.addStatistic(4, "COMBAT SKILL", 93, "CS");
        g1.addStatistic(5, "SPECIAL POWER", 59, "SP");

        cards.add(g1);

        // G2
        CardInfo g2 = new CardInfo(
                "G2",
                "Starkad",
                "NORSE HERO",
                R.drawable.mythicalheroes_g2,
                'G',
                2,
                false
        );

        g2.addStatistic(0, "STRENGTH", 95, "STR");
        g2.addStatistic(1, "SPEED", 75, "km/h");
        g2.addStatistic(2, "DURABILITY", 96, "HP");
        g2.addStatistic(3, "INTELLIGENCE", 78, "IQ");
        g2.addStatistic(4, "COMBAT SKILL", 98, "CS");
        g2.addStatistic(5, "SPECIAL POWER", 81, "SP");

        cards.add(g2);

        // G3
        CardInfo g3 = new CardInfo(
                "G3",
                "Amleth",
                "DANISH HERO",
                R.drawable.mythicalheroes_g3,
                'G',
                3,
                false
        );

        g3.addStatistic(0, "STRENGTH", 80, "STR");
        g3.addStatistic(1, "SPEED", 75, "km/h");
        g3.addStatistic(2, "DURABILITY", 82, "HP");
        g3.addStatistic(3, "INTELLIGENCE", 92, "IQ");
        g3.addStatistic(4, "COMBAT SKILL", 93, "CS");
        g3.addStatistic(5, "SPECIAL POWER", 61, "SP");

        cards.add(g3);

        // G4
        CardInfo g4 = new CardInfo(
                "G4",
                "Maui",
                "POLYNESIAN HERO",
                R.drawable.mythicalheroes_g4,
                'G',
                4,
                false
        );

        g4.addStatistic(0, "STRENGTH", 99, "STR");
        g4.addStatistic(1, "SPEED", 82, "km/h");
        g4.addStatistic(2, "DURABILITY", 97, "HP");
        g4.addStatistic(3, "INTELLIGENCE", 88, "IQ");
        g4.addStatistic(4, "COMBAT SKILL", 94, "CS");
        g4.addStatistic(5, "SPECIAL POWER", 100, "SP");

        cards.add(g4);


        // =========================
        // H
        // =========================

        // H1
        CardInfo h1 = new CardInfo(
                "H1",
                "Enkidu",
                "MESOPOTAMIAN HERO",
                R.drawable.mythicalheroes_h1,
                'H',
                1,
                false
        );

        h1.addStatistic(0, "STRENGTH", 99, "STR");
        h1.addStatistic(1, "SPEED", 77, "km/h");
        h1.addStatistic(2, "DURABILITY", 95, "HP");
        h1.addStatistic(3, "INTELLIGENCE", 78, "IQ");
        h1.addStatistic(4, "COMBAT SKILL", 98, "CS");
        h1.addStatistic(5, "SPECIAL POWER", 83, "SP");

        cards.add(h1);

        // H2
        CardInfo h2 = new CardInfo(
                "H2",
                "Meleager",
                "GREEK HERO",
                R.drawable.mythicalheroes_h2,
                'H',
                2,
                false
        );

        h2.addStatistic(0, "STRENGTH", 89, "STR");
        h2.addStatistic(1, "SPEED", 79, "km/h");
        h2.addStatistic(2, "DURABILITY", 89, "HP");
        h2.addStatistic(3, "INTELLIGENCE", 78, "IQ");
        h2.addStatistic(4, "COMBAT SKILL", 99, "CS");
        h2.addStatistic(5, "SPECIAL POWER", 81, "SP");

        cards.add(h2);

        // H3
        CardInfo h3 = new CardInfo(
                "H3",
                "Diomedes",
                "GREEK HERO",
                R.drawable.mythicalheroes_h3,
                'H',
                3,
                false
        );

        h3.addStatistic(0, "STRENGTH", 94, "STR");
        h3.addStatistic(1, "SPEED", 79, "km/h");
        h3.addStatistic(2, "DURABILITY", 96, "HP");
        h3.addStatistic(3, "INTELLIGENCE", 88, "IQ");
        h3.addStatistic(4, "COMBAT SKILL", 98, "CS");
        h3.addStatistic(5, "SPECIAL POWER", 91, "SP");

        cards.add(h3);

        // H4 - SUPER ULTIMA
        CardInfo h4 = new CardInfo(
                "H4",
                "Aeneas",
                "GREEK HERO",
                R.drawable.mythicalheroes_h4,
                'H',
                4,
                true
        );

        h4.addStatistic(0, "STRENGTH", 94, "STR");
        h4.addStatistic(1, "SPEED", 84, "km/h");
        h4.addStatistic(2, "DURABILITY", 95, "HP");
        h4.addStatistic(3, "INTELLIGENCE", 91, "IQ");
        h4.addStatistic(4, "COMBAT SKILL", 98, "CS");
        h4.addStatistic(5, "SPECIAL POWER", 94, "SP");

        cards.add(h4);
    }

    public List<CardInfo> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}