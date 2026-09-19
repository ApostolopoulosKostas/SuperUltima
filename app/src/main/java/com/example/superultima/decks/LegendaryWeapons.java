package com.example.superultima.decks;

import com.example.superultima.R;
import com.example.superultima.cardgame.CardInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LegendaryWeapons {

    private final List<CardInfo> cards = new ArrayList<>();

    public LegendaryWeapons() {

        // A1 - Excalibur
        CardInfo a1 = new CardInfo(
                "A1",
                "Excalibur",
                "KING ARTHUR",
                R.drawable.weapons_a1,
                'A',
                1,
                false
        );
        a1.addStatistic(0, "POWER", 92, "PWR");
        a1.addStatistic(1, "DAMAGE", 91, "DMG");
        a1.addStatistic(2, "RANGE", 72, "m");
        a1.addStatistic(3, "DURABILITY", 94, "HP");
        a1.addStatistic(4, "SPEED", 82, "km/h");
        a1.addStatistic(5, "LEGEND", 98, "LGD");
        cards.add(a1);


        // A2 - Mjölnir
        CardInfo a2 = new CardInfo(
                "A2",
                "Mjölnir",
                "THOR",
                R.drawable.weapons_a2,
                'A',
                2,
                false
        );
        a2.addStatistic(0, "POWER", 96, "PWR");
        a2.addStatistic(1, "DAMAGE", 98, "DMG");
        a2.addStatistic(2, "RANGE", 65, "m");
        a2.addStatistic(3, "DURABILITY", 97, "HP");
        a2.addStatistic(4, "SPEED", 68, "km/h");
        a2.addStatistic(5, "LEGEND", 100, "LGD");
        cards.add(a2);


        // A3 - Gungnir
        CardInfo a3 = new CardInfo(
                "A3",
                "Gungnir",
                "ODIN",
                R.drawable.weapons_a3,
                'A',
                3,
                false
        );
        a3.addStatistic(0, "POWER", 88, "PWR");
        a3.addStatistic(1, "DAMAGE", 90, "DMG");
        a3.addStatistic(2, "RANGE", 95, "m");
        a3.addStatistic(3, "DURABILITY", 91, "HP");
        a3.addStatistic(4, "SPEED", 86, "km/h");
        a3.addStatistic(5, "LEGEND", 99, "LGD");
        cards.add(a3);


        // A4 - Gram
        CardInfo a4 = new CardInfo(
                "A4",
                "Gram",
                "SIGURD",
                R.drawable.weapons_a4,
                'A',
                4,
                false
        );
        a4.addStatistic(0, "POWER", 91, "PWR");
        a4.addStatistic(1, "DAMAGE", 94, "DMG");
        a4.addStatistic(2, "RANGE", 62, "m");
        a4.addStatistic(3, "DURABILITY", 89, "HP");
        a4.addStatistic(4, "SPEED", 91, "km/h");
        a4.addStatistic(5, "LEGEND", 95, "LGD");
        cards.add(a4);


        // B1 - Kusanagi-no-Tsurugi
        CardInfo b1 = new CardInfo(
                "B1",
                "Kusanagi-no-Tsurugi",
                "SUSANOO",
                R.drawable.weapons_b1,
                'B',
                1,
                false
        );
        b1.addStatistic(0, "POWER", 84, "PWR");
        b1.addStatistic(1, "DAMAGE", 87, "DMG");
        b1.addStatistic(2, "RANGE", 60, "m");
        b1.addStatistic(3, "DURABILITY", 88, "HP");
        b1.addStatistic(4, "SPEED", 96, "km/h");
        b1.addStatistic(5, "LEGEND", 97, "LGD");
        cards.add(b1);


        // B2 - Vajra
        CardInfo b2 = new CardInfo(
                "B2",
                "Vajra",
                "INDRA",
                R.drawable.weapons_b2,
                'B',
                2,
                false
        );
        b2.addStatistic(0, "POWER", 94, "PWR");
        b2.addStatistic(1, "DAMAGE", 97, "DMG");
        b2.addStatistic(2, "RANGE", 90, "m");
        b2.addStatistic(3, "DURABILITY", 96, "HP");
        b2.addStatistic(4, "SPEED", 72, "km/h");
        b2.addStatistic(5, "LEGEND", 100, "LGD");
        cards.add(b2);


        // B3 - Trident of Poseidon
        CardInfo b3 = new CardInfo(
                "B3",
                "Trident of Poseidon",
                "POSEIDON",
                R.drawable.weapons_b3,
                'B',
                3,
                false
        );
        b3.addStatistic(0, "POWER", 93, "PWR");
        b3.addStatistic(1, "DAMAGE", 95, "DMG");
        b3.addStatistic(2, "RANGE", 82, "m");
        b3.addStatistic(3, "DURABILITY", 95, "HP");
        b3.addStatistic(4, "SPEED", 65, "km/h");
        b3.addStatistic(5, "LEGEND", 99, "LGD");
        cards.add(b3);


        // B4 - Harpe
        CardInfo b4 = new CardInfo(
                "B4",
                "Harpe",
                "PERSEUS",
                R.drawable.weapons_b4,
                'B',
                4,
                false
        );
        b4.addStatistic(0, "POWER", 76, "PWR");
        b4.addStatistic(1, "DAMAGE", 80, "DMG");
        b4.addStatistic(2, "RANGE", 58, "m");
        b4.addStatistic(3, "DURABILITY", 78, "HP");
        b4.addStatistic(4, "SPEED", 98, "km/h");
        b4.addStatistic(5, "LEGEND", 91, "LGD");
        cards.add(b4);


        // C1 - Gáe Bulg
        CardInfo c1 = new CardInfo(
                "C1",
                "Gáe Bulg",
                "CÚ CHULAINN",
                R.drawable.weapons_c1,
                'C',
                1,
                false
        );
        c1.addStatistic(0, "POWER", 89, "PWR");
        c1.addStatistic(1, "DAMAGE", 96, "DMG");
        c1.addStatistic(2, "RANGE", 70, "m");
        c1.addStatistic(3, "DURABILITY", 83, "HP");
        c1.addStatistic(4, "SPEED", 93, "km/h");
        c1.addStatistic(5, "LEGEND", 97, "LGD");
        cards.add(c1);


        // C2 - Fragarach
        CardInfo c2 = new CardInfo(
                "C2",
                "Fragarach",
                "MANANNÁN MAC LIR",
                R.drawable.weapons_c2,
                'C',
                2,
                false
        );
        c2.addStatistic(0, "POWER", 87, "PWR");
        c2.addStatistic(1, "DAMAGE", 88, "DMG");
        c2.addStatistic(2, "RANGE", 64, "m");
        c2.addStatistic(3, "DURABILITY", 86, "HP");
        c2.addStatistic(4, "SPEED", 95, "km/h");
        c2.addStatistic(5, "LEGEND", 98, "LGD");
        cards.add(c2);


        // C3 - Durendal
        CardInfo c3 = new CardInfo(
                "C3",
                "Durendal",
                "ROLAND",
                R.drawable.weapons_c3,
                'C',
                3,
                false
        );
        c3.addStatistic(0, "POWER", 86, "PWR");
        c3.addStatistic(1, "DAMAGE", 89, "DMG");
        c3.addStatistic(2, "RANGE", 61, "m");
        c3.addStatistic(3, "DURABILITY", 92, "HP");
        c3.addStatistic(4, "SPEED", 84, "km/h");
        c3.addStatistic(5, "LEGEND", 94, "LGD");
        cards.add(c3);


        // C4 - Joyeuse
        CardInfo c4 = new CardInfo(
                "C4",
                "Joyeuse",
                "CHARLEMAGNE",
                R.drawable.weapons_c4,
                'C',
                4,
                false
        );
        c4.addStatistic(0, "POWER", 83, "PWR");
        c4.addStatistic(1, "DAMAGE", 85, "DMG");
        c4.addStatistic(2, "RANGE", 60, "m");
        c4.addStatistic(3, "DURABILITY", 90, "HP");
        c4.addStatistic(4, "SPEED", 87, "km/h");
        c4.addStatistic(5, "LEGEND", 96, "LGD");
        cards.add(c4);


        // D1 - Clarent
        CardInfo d1 = new CardInfo(
                "D1",
                "Clarent",
                "KING ARTHUR",
                R.drawable.weapons_d1,
                'D',
                1,
                false
        );
        d1.addStatistic(0, "POWER", 78, "PWR");
        d1.addStatistic(1, "DAMAGE", 82, "DMG");
        d1.addStatistic(2, "RANGE", 59, "m");
        d1.addStatistic(3, "DURABILITY", 85, "HP");
        d1.addStatistic(4, "SPEED", 90, "km/h");
        d1.addStatistic(5, "LEGEND", 88, "LGD");
        cards.add(d1);


        // D2 - Rhongomyniad
        CardInfo d2 = new CardInfo(
                "D2",
                "Rhongomyniad",
                "KING ARTHUR",
                R.drawable.weapons_d2,
                'D',
                2,
                false
        );
        d2.addStatistic(0, "POWER", 90, "PWR");
        d2.addStatistic(1, "DAMAGE", 92, "DMG");
        d2.addStatistic(2, "RANGE", 94, "m");
        d2.addStatistic(3, "DURABILITY", 91, "HP");
        d2.addStatistic(4, "SPEED", 78, "km/h");
        d2.addStatistic(5, "LEGEND", 96, "LGD");
        cards.add(d2);


        // D3 - Carnwennan
        CardInfo d3 = new CardInfo(
                "D3",
                "Carnwennan",
                "KING ARTHUR",
                R.drawable.weapons_d3,
                'D',
                3,
                false
        );
        d3.addStatistic(0, "POWER", 72, "PWR");
        d3.addStatistic(1, "DAMAGE", 75, "DMG");
        d3.addStatistic(2, "RANGE", 55, "m");
        d3.addStatistic(3, "DURABILITY", 76, "HP");
        d3.addStatistic(4, "SPEED", 100, "km/h");
        d3.addStatistic(5, "LEGEND", 93, "LGD");
        cards.add(d3);


        // D4 - Hrunting
        CardInfo d4 = new CardInfo(
                "D4",
                "Hrunting",
                "BEOWULF",
                R.drawable.weapons_d4,
                'D',
                4,
                false
        );
        d4.addStatistic(0, "POWER", 81, "PWR");
        d4.addStatistic(1, "DAMAGE", 86, "DMG");
        d4.addStatistic(2, "RANGE", 57, "m");
        d4.addStatistic(3, "DURABILITY", 84, "HP");
        d4.addStatistic(4, "SPEED", 89, "km/h");
        d4.addStatistic(5, "LEGEND", 90, "LGD");
        cards.add(d4);


        // E1 - Nægling
        CardInfo e1 = new CardInfo(
                "E1",
                "Nægling",
                "BEOWULF",
                R.drawable.weapons_e1,
                'E',
                1,
                false
        );
        e1.addStatistic(0, "POWER", 85, "PWR");
        e1.addStatistic(1, "DAMAGE", 90, "DMG");
        e1.addStatistic(2, "RANGE", 60, "m");
        e1.addStatistic(3, "DURABILITY", 88, "HP");
        e1.addStatistic(4, "SPEED", 82, "km/h");
        e1.addStatistic(5, "LEGEND", 92, "LGD");
        cards.add(e1);


        // E2 - Tyrfing
        CardInfo e2 = new CardInfo(
                "E2",
                "Tyrfing",
                "SVAFRILAMI",
                R.drawable.weapons_e2,
                'E',
                2,
                false
        );
        e2.addStatistic(0, "POWER", 93, "PWR");
        e2.addStatistic(1, "DAMAGE", 97, "DMG");
        e2.addStatistic(2, "RANGE", 63, "m");
        e2.addStatistic(3, "DURABILITY", 87, "HP");
        e2.addStatistic(4, "SPEED", 86, "km/h");
        e2.addStatistic(5, "LEGEND", 99, "LGD");
        cards.add(e2);


        // E3 - Dáinsleif
        CardInfo e3 = new CardInfo(
                "E3",
                "Dáinsleif",
                "HÖGNI",
                R.drawable.weapons_e3,
                'E',
                3,
                false
        );
        e3.addStatistic(0, "POWER", 95, "PWR");
        e3.addStatistic(1, "DAMAGE", 99, "DMG");
        e3.addStatistic(2, "RANGE", 62, "m");
        e3.addStatistic(3, "DURABILITY", 90, "HP");
        e3.addStatistic(4, "SPEED", 88, "km/h");
        e3.addStatistic(5, "LEGEND", 100, "LGD");
        cards.add(e3);


        // E4 - Lævateinn - SUPER ULTIMA
        CardInfo e4 = new CardInfo(
                "E4",
                "Lævateinn",
                "LOKI",
                R.drawable.weapons_e4,
                'E',
                4,
                true
        );
        e4.addStatistic(0, "POWER", 52, "PWR");
        e4.addStatistic(1, "DAMAGE", 58, "DMG");
        e4.addStatistic(2, "RANGE", 92, "m");
        e4.addStatistic(3, "DURABILITY", 61, "HP");
        e4.addStatistic(4, "SPEED", 74, "km/h");
        e4.addStatistic(5, "LEGEND", 100, "LGD");
        cards.add(e4);


        // F1 - Sharur
        CardInfo f1 = new CardInfo(
                "F1",
                "Sharur",
                "NINURTA",
                R.drawable.weapons_f1,
                'F',
                1,
                false
        );
        f1.addStatistic(0, "POWER", 90, "PWR");
        f1.addStatistic(1, "DAMAGE", 93, "DMG");
        f1.addStatistic(2, "RANGE", 68, "m");
        f1.addStatistic(3, "DURABILITY", 95, "HP");
        f1.addStatistic(4, "SPEED", 64, "km/h");
        f1.addStatistic(5, "LEGEND", 94, "LGD");
        cards.add(f1);


        // F2 - Sudarshana Chakra
        CardInfo f2 = new CardInfo(
                "F2",
                "Sudarshana Chakra",
                "VISHNU",
                R.drawable.weapons_f2,
                'F',
                2,
                false
        );
        f2.addStatistic(0, "POWER", 91, "PWR");
        f2.addStatistic(1, "DAMAGE", 96, "DMG");
        f2.addStatistic(2, "RANGE", 98, "m");
        f2.addStatistic(3, "DURABILITY", 93, "HP");
        f2.addStatistic(4, "SPEED", 99, "km/h");
        f2.addStatistic(5, "LEGEND", 100, "LGD");
        cards.add(f2);


        // F3 - Trishula
        CardInfo f3 = new CardInfo(
                "F3",
                "Trishula",
                "SHIVA",
                R.drawable.weapons_f3,
                'F',
                3,
                false
        );
        f3.addStatistic(0, "POWER", 92, "PWR");
        f3.addStatistic(1, "DAMAGE", 94, "DMG");
        f3.addStatistic(2, "RANGE", 88, "m");
        f3.addStatistic(3, "DURABILITY", 94, "HP");
        f3.addStatistic(4, "SPEED", 70, "km/h");
        f3.addStatistic(5, "LEGEND", 99, "LGD");
        cards.add(f3);


        // F4 - Brahmastra
        CardInfo f4 = new CardInfo(
                "F4",
                "Brahmastra",
                "BRAHMA",
                R.drawable.weapons_f4,
                'F',
                4,
                false
        );
        f4.addStatistic(0, "POWER", 100, "PWR");
        f4.addStatistic(1, "DAMAGE", 100, "DMG");
        f4.addStatistic(2, "RANGE", 100, "m");
        f4.addStatistic(3, "DURABILITY", 85, "HP");
        f4.addStatistic(4, "SPEED", 55, "km/h");
        f4.addStatistic(5, "LEGEND", 100, "LGD");
        cards.add(f4);


        // G1 - Ruyi Jingu Bang
        CardInfo g1 = new CardInfo(
                "G1",
                "Ruyi Jingu Bang",
                "SUN WUKONG",
                R.drawable.weapons_g1,
                'G',
                1,
                false
        );
        g1.addStatistic(0, "POWER", 94, "PWR");
        g1.addStatistic(1, "DAMAGE", 93, "DMG");
        g1.addStatistic(2, "RANGE", 86, "m");
        g1.addStatistic(3, "DURABILITY", 99, "HP");
        g1.addStatistic(4, "SPEED", 76, "km/h");
        g1.addStatistic(5, "LEGEND", 100, "LGD");
        cards.add(g1);


        // G2 - Green Dragon Crescent Blade
        CardInfo g2 = new CardInfo(
                "G2",
                "Green Dragon Crescent Blade",
                "GUAN YU",
                R.drawable.weapons_g2,
                'G',
                2,
                false
        );
        g2.addStatistic(0, "POWER", 89, "PWR");
        g2.addStatistic(1, "DAMAGE", 91, "DMG");
        g2.addStatistic(2, "RANGE", 73, "m");
        g2.addStatistic(3, "DURABILITY", 94, "HP");
        g2.addStatistic(4, "SPEED", 71, "km/h");
        g2.addStatistic(5, "LEGEND", 96, "LGD");
        cards.add(g2);


        // G3 - Ame-no-Nuhoko
        CardInfo g3 = new CardInfo(
                "G3",
                "Ame-no-Nuhoko",
                "Izanagi and Izanami",
                R.drawable.weapons_g3,
                'G',
                3,
                false
        );
        g3.addStatistic(0, "POWER", 82, "PWR");
        g3.addStatistic(1, "DAMAGE", 84, "DMG");
        g3.addStatistic(2, "RANGE", 90, "m");
        g3.addStatistic(3, "DURABILITY", 87, "HP");
        g3.addStatistic(4, "SPEED", 79, "km/h");
        g3.addStatistic(5, "LEGEND", 97, "LGD");
        cards.add(g3);


        // G4 - Tonbogiri
        CardInfo g4 = new CardInfo(
                "G4",
                "Tonbogiri",
                "HONDA TADAKATSU",
                R.drawable.weapons_g4,
                'G',
                4,
                false
        );
        g4.addStatistic(0, "POWER", 79, "PWR");
        g4.addStatistic(1, "DAMAGE", 83, "DMG");
        g4.addStatistic(2, "RANGE", 76, "m");
        g4.addStatistic(3, "DURABILITY", 82, "HP");
        g4.addStatistic(4, "SPEED", 97, "km/h");
        g4.addStatistic(5, "LEGEND", 89, "LGD");
        cards.add(g4);


        // H1 - Zulfiqar
        CardInfo h1 = new CardInfo(
                "H1",
                "Zulfiqar",
                " Ali ibn Abi Talib",
                R.drawable.weapons_h1,
                'H',
                1,
                false
        );
        h1.addStatistic(0, "POWER", 88, "PWR");
        h1.addStatistic(1, "DAMAGE", 92, "DMG");
        h1.addStatistic(2, "RANGE", 61, "m");
        h1.addStatistic(3, "DURABILITY", 86, "HP");
        h1.addStatistic(4, "SPEED", 92, "km/h");
        h1.addStatistic(5, "LEGEND", 98, "LGD");
        cards.add(h1);


        // H2 - Shamshir-e Zomorrodnegar
        CardInfo h2 = new CardInfo(
                "H2",
                "Shamshir-e Zomorrodnegar",
                "King Solomon",
                R.drawable.weapons_h2,
                'H',
                2,
                false
        );
        h2.addStatistic(0, "POWER", 90, "PWR");
        h2.addStatistic(1, "DAMAGE", 94, "DMG");
        h2.addStatistic(2, "RANGE", 60, "m");
        h2.addStatistic(3, "DURABILITY", 93, "HP");
        h2.addStatistic(4, "SPEED", 89, "km/h");
        h2.addStatistic(5, "LEGEND", 99, "LGD");
        cards.add(h2);


        // H3 - Sword of Goujian
        CardInfo h3 = new CardInfo(
                "H3",
                "Sword of Goujian",
                "KING GOUJIAN",
                R.drawable.weapons_h3,
                'H',
                3,
                false
        );
        h3.addStatistic(0, "POWER", 75, "PWR");
        h3.addStatistic(1, "DAMAGE", 78, "DMG");
        h3.addStatistic(2, "RANGE", 58, "m");
        h3.addStatistic(3, "DURABILITY", 98, "HP");
        h3.addStatistic(4, "SPEED", 94, "km/h");
        h3.addStatistic(5, "LEGEND", 86, "LGD");
        cards.add(h3);


        // H4 - Marmiadoise
        CardInfo h4 = new CardInfo(
                "H4",
                "Marmiadoise",
                "Hercules",
                R.drawable.weapons_h4,
                'H',
                4,
                false
        );
        h4.addStatistic(0, "POWER", 84, "PWR");
        h4.addStatistic(1, "DAMAGE", 87, "DMG");
        h4.addStatistic(2, "RANGE", 63, "m");
        h4.addStatistic(3, "DURABILITY", 89, "HP");
        h4.addStatistic(4, "SPEED", 83, "km/h");
        h4.addStatistic(5, "LEGEND", 93, "LGD");
        cards.add(h4);
    }

    public List<CardInfo> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
