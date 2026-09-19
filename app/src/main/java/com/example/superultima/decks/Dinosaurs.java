package com.example.superultima.decks;

import com.example.superultima.R;
import com.example.superultima.cardgame.CardInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dinosaurs {

    private final List<CardInfo> cards = new ArrayList<>();

    public Dinosaurs() {

        // A1 - Tyrannosaurus
        CardInfo a1 = new CardInfo(
                "A1",
                "Tyrannosaurus",
                "TYRANNOSAURID",
                R.drawable.dino_a1,
                'A',
                1,
                false
        );
        a1.addStatistic(0, "WEIGHT", 8.4, "tn");
        a1.addStatistic(1, "LENGTH", 12.3, "m");
        a1.addStatistic(2, "HEIGHT", 4.0, "m");
        a1.addStatistic(3, "SPEED", 27, "km/h");
        a1.addStatistic(4, "BITE FORCE", 50, "kN");
        a1.addStatistic(5, "INTELLIGENCE", 82, "");
        cards.add(a1);

        // A2 - Triceratops
        CardInfo a2 = new CardInfo(
                "A2",
                "Triceratops",
                "CERATOPSIAN",
                R.drawable.dino_a2,
                'A',
                2,
                false
        );
        a2.addStatistic(0, "WEIGHT", 8.0, "tn");
        a2.addStatistic(1, "LENGTH", 9.0, "m");
        a2.addStatistic(2, "HEIGHT", 3.0, "m");
        a2.addStatistic(3, "SPEED", 25, "km/h");
        a2.addStatistic(4, "BITE FORCE", 22, "kN");
        a2.addStatistic(5, "INTELLIGENCE", 58, "");
        cards.add(a2);

        // A3 - Velociraptor
        CardInfo a3 = new CardInfo(
                "A3",
                "Velociraptor",
                "DROMAEOSAURID",
                R.drawable.dino_a3,
                'A',
                3,
                false
        );
        a3.addStatistic(0, "WEIGHT", 0.015, "tn");
        a3.addStatistic(1, "LENGTH", 2.0, "m");
        a3.addStatistic(2, "HEIGHT", 0.6, "m");
        a3.addStatistic(3, "SPEED", 40, "km/h");
        a3.addStatistic(4, "BITE FORCE", 1.2, "kN");
        a3.addStatistic(5, "INTELLIGENCE", 78, "");
        cards.add(a3);

        // A4 - Spinosaurus
        CardInfo a4 = new CardInfo(
                "A4",
                "Spinosaurus",
                "SPINOSAURID",
                R.drawable.dino_a4,
                'A',
                4,
                false
        );
        a4.addStatistic(0, "WEIGHT", 7.4, "tn");
        a4.addStatistic(1, "LENGTH", 14.0, "m");
        a4.addStatistic(2, "HEIGHT", 4.5, "m");
        a4.addStatistic(3, "SPEED", 24, "km/h");
        a4.addStatistic(4, "BITE FORCE", 15, "kN");
        a4.addStatistic(5, "INTELLIGENCE", 70, "");
        cards.add(a4);

        // B1 - Giganotosaurus
        CardInfo b1 = new CardInfo(
                "B1",
                "Giganotosaurus",
                "CARCHARODONTOSAURID",
                R.drawable.dino_b1,
                'B',
                1,
                false
        );
        b1.addStatistic(0, "WEIGHT", 7.0, "tn");
        b1.addStatistic(1, "LENGTH", 13.2, "m");
        b1.addStatistic(2, "HEIGHT", 4.0, "m");
        b1.addStatistic(3, "SPEED", 32, "km/h");
        b1.addStatistic(4, "BITE FORCE", 35, "kN");
        b1.addStatistic(5, "INTELLIGENCE", 65, "");
        cards.add(b1);

        // B2 - Ankylosaurus
        CardInfo b2 = new CardInfo(
                "B2",
                "Ankylosaurus",
                "ANKYLOSAUR",
                R.drawable.dino_b2,
                'B',
                2,
                false
        );
        b2.addStatistic(0, "WEIGHT", 6.0, "tn");
        b2.addStatistic(1, "LENGTH", 8.0, "m");
        b2.addStatistic(2, "HEIGHT", 2.0, "m");
        b2.addStatistic(3, "SPEED", 10, "km/h");
        b2.addStatistic(4, "BITE FORCE", 7, "kN");
        b2.addStatistic(5, "INTELLIGENCE", 45, "");
        cards.add(b2);

        // B3 - Stegosaurus
        CardInfo b3 = new CardInfo(
                "B3",
                "Stegosaurus",
                "STEGOSAUR",
                R.drawable.dino_b3,
                'B',
                3,
                false
        );
        b3.addStatistic(0, "WEIGHT", 3.5, "tn");
        b3.addStatistic(1, "LENGTH", 9.0, "m");
        b3.addStatistic(2, "HEIGHT", 4.0, "m");
        b3.addStatistic(3, "SPEED", 7, "km/h");
        b3.addStatistic(4, "BITE FORCE", 5, "kN");
        b3.addStatistic(5, "INTELLIGENCE", 48, "");
        cards.add(b3);

        // B4 - Allosaurus
        CardInfo b4 = new CardInfo(
                "B4",
                "Allosaurus",
                "ALLOSAURID",
                R.drawable.dino_b4,
                'B',
                4,
                false
        );
        b4.addStatistic(0, "WEIGHT", 2.0, "tn");
        b4.addStatistic(1, "LENGTH", 9.5, "m");
        b4.addStatistic(2, "HEIGHT", 3.0, "m");
        b4.addStatistic(3, "SPEED", 34, "km/h");
        b4.addStatistic(4, "BITE FORCE", 15, "kN");
        b4.addStatistic(5, "INTELLIGENCE", 72, "");
        cards.add(b4);

        // C1 - Carnotaurus
        CardInfo c1 = new CardInfo(
                "C1",
                "Carnotaurus",
                "ABELISAURID",
                R.drawable.dino_c1,
                'C',
                1,
                false
        );
        c1.addStatistic(0, "WEIGHT", 1.5, "tn");
        c1.addStatistic(1, "LENGTH", 8.0, "m");
        c1.addStatistic(2, "HEIGHT", 3.0, "m");
        c1.addStatistic(3, "SPEED", 48, "km/h");
        c1.addStatistic(4, "BITE FORCE", 8, "kN");
        c1.addStatistic(5, "INTELLIGENCE", 68, "");
        cards.add(c1);

        // C2 - Brachiosaurus
        CardInfo c2 = new CardInfo(
                "C2",
                "Brachiosaurus",
                "SAUROPOD",
                R.drawable.dino_c2,
                'C',
                2,
                false
        );
        c2.addStatistic(0, "WEIGHT", 56.0, "tn");
        c2.addStatistic(1, "LENGTH", 22.0, "m");
        c2.addStatistic(2, "HEIGHT", 9.0, "m");
        c2.addStatistic(3, "SPEED", 20, "km/h");
        c2.addStatistic(4, "BITE FORCE", 4, "kN");
        c2.addStatistic(5, "INTELLIGENCE", 52, "");
        cards.add(c2);

        // C3 - Diplodocus
        CardInfo c3 = new CardInfo(
                "C3",
                "Diplodocus",
                "SAUROPOD",
                R.drawable.dino_c3,
                'C',
                3,
                false
        );
        c3.addStatistic(0, "WEIGHT", 15.0, "tn");
        c3.addStatistic(1, "LENGTH", 24.0, "m");
        c3.addStatistic(2, "HEIGHT", 5.0, "m");
        c3.addStatistic(3, "SPEED", 15, "km/h");
        c3.addStatistic(4, "BITE FORCE", 3, "kN");
        c3.addStatistic(5, "INTELLIGENCE", 55, "");
        cards.add(c3);

        // C4 - Parasaurolophus
        CardInfo c4 = new CardInfo(
                "C4",
                "Parasaurolophus",
                "HADROSAURID",
                R.drawable.dino_c4,
                'C',
                4,
                false
        );
        c4.addStatistic(0, "WEIGHT", 2.5, "tn");
        c4.addStatistic(1, "LENGTH", 10.0, "m");
        c4.addStatistic(2, "HEIGHT", 4.0, "m");
        c4.addStatistic(3, "SPEED", 25, "km/h");
        c4.addStatistic(4, "BITE FORCE", 4, "kN");
        c4.addStatistic(5, "INTELLIGENCE", 72, "");
        cards.add(c4);

        // D1 - Iguanodon
        CardInfo d1 = new CardInfo(
                "D1",
                "Iguanodon",
                "IGUANODONT",
                R.drawable.dino_d1,
                'D',
                1,
                false
        );
        d1.addStatistic(0, "WEIGHT", 3.5, "tn");
        d1.addStatistic(1, "LENGTH", 10.0, "m");
        d1.addStatistic(2, "HEIGHT", 4.0, "m");
        d1.addStatistic(3, "SPEED", 24, "km/h");
        d1.addStatistic(4, "BITE FORCE", 5, "kN");
        d1.addStatistic(5, "INTELLIGENCE", 63, "");
        cards.add(d1);

        // D2 - Utahraptor
        CardInfo d2 = new CardInfo(
                "D2",
                "Utahraptor",
                "DROMAEOSAURID",
                R.drawable.dino_d2,
                'D',
                2,
                false
        );
        d2.addStatistic(0, "WEIGHT", 0.5, "tn");
        d2.addStatistic(1, "LENGTH", 5.5, "m");
        d2.addStatistic(2, "HEIGHT", 2.0, "m");
        d2.addStatistic(3, "SPEED", 35, "km/h");
        d2.addStatistic(4, "BITE FORCE", 4, "kN");
        d2.addStatistic(5, "INTELLIGENCE", 76, "");
        cards.add(d2);

        // D3 - Pachycephalosaurus
        CardInfo d3 = new CardInfo(
                "D3",
                "Pachycephalosaurus",
                "PACHYCEPHALOSAUR",
                R.drawable.dino_d3,
                'D',
                3,
                false
        );
        d3.addStatistic(0, "WEIGHT", 0.45, "tn");
        d3.addStatistic(1, "LENGTH", 4.5, "m");
        d3.addStatistic(2, "HEIGHT", 2.0, "m");
        d3.addStatistic(3, "SPEED", 25, "km/h");
        d3.addStatistic(4, "BITE FORCE", 3, "kN");
        d3.addStatistic(5, "INTELLIGENCE", 60, "");
        cards.add(d3);

        // D4 - Therizinosaurus
        CardInfo d4 = new CardInfo(
                "D4",
                "Therizinosaurus",
                "THERIZINOSAURID",
                R.drawable.dino_d4,
                'D',
                4,
                false
        );
        d4.addStatistic(0, "WEIGHT", 5.0, "tn");
        d4.addStatistic(1, "LENGTH", 9.0, "m");
        d4.addStatistic(2, "HEIGHT", 5.0, "m");
        d4.addStatistic(3, "SPEED", 20, "km/h");
        d4.addStatistic(4, "BITE FORCE", 6, "kN");
        d4.addStatistic(5, "INTELLIGENCE", 74, "");
        cards.add(d4);

        // E1 - Deinocheirus
        CardInfo e1 = new CardInfo(
                "E1",
                "Deinocheirus",
                "ORNITHOMIMOSAUR",
                R.drawable.dino_e1,
                'E',
                1,
                false
        );
        e1.addStatistic(0, "WEIGHT", 6.4, "tn");
        e1.addStatistic(1, "LENGTH", 11.0, "m");
        e1.addStatistic(2, "HEIGHT", 4.5, "m");
        e1.addStatistic(3, "SPEED", 25, "km/h");
        e1.addStatistic(4, "BITE FORCE", 5, "kN");
        e1.addStatistic(5, "INTELLIGENCE", 80, "");
        cards.add(e1);

        // E2 - Argentinosaurus
        CardInfo e2 = new CardInfo(
                "E2",
                "Argentinosaurus",
                "SAUROPOD",
                R.drawable.dino_e2,
                'E',
                2,
                false
        );
        e2.addStatistic(0, "WEIGHT", 70.0, "tn");
        e2.addStatistic(1, "LENGTH", 30.0, "m");
        e2.addStatistic(2, "HEIGHT", 7.0, "m");
        e2.addStatistic(3, "SPEED", 12, "km/h");
        e2.addStatistic(4, "BITE FORCE", 4, "kN");
        e2.addStatistic(5, "INTELLIGENCE", 50, "");
        cards.add(e2);

        // E3 - Suchomimus
        CardInfo e3 = new CardInfo(
                "E3",
                "Suchomimus",
                "SPINOSAURID",
                R.drawable.dino_e3,
                'E',
                3,
                false
        );
        e3.addStatistic(0, "WEIGHT", 5.0, "tn");
        e3.addStatistic(1, "LENGTH", 11.0, "m");
        e3.addStatistic(2, "HEIGHT", 3.5, "m");
        e3.addStatistic(3, "SPEED", 30, "km/h");
        e3.addStatistic(4, "BITE FORCE", 10, "kN");
        e3.addStatistic(5, "INTELLIGENCE", 73, "");
        cards.add(e3);

        // E4 - Ceratosaurus
        CardInfo e4 = new CardInfo(
                "E4",
                "Ceratosaurus",
                "CERATOSAUR",
                R.drawable.dino_e4,
                'E',
                4,
                false
        );
        e4.addStatistic(0, "WEIGHT", 0.9, "tn");
        e4.addStatistic(1, "LENGTH", 7.0, "m");
        e4.addStatistic(2, "HEIGHT", 2.5, "m");
        e4.addStatistic(3, "SPEED", 30, "km/h");
        e4.addStatistic(4, "BITE FORCE", 7, "kN");
        e4.addStatistic(5, "INTELLIGENCE", 66, "");
        cards.add(e4);

        // F1 - Dilophosaurus
        CardInfo f1 = new CardInfo(
                "F1",
                "Dilophosaurus",
                "DILOPHOSAURID",
                R.drawable.dino_f1,
                'F',
                1,
                false
        );
        f1.addStatistic(0, "WEIGHT", 0.4, "tn");
        f1.addStatistic(1, "LENGTH", 7.0, "m");
        f1.addStatistic(2, "HEIGHT", 2.5, "m");
        f1.addStatistic(3, "SPEED", 30, "km/h");
        f1.addStatistic(4, "BITE FORCE", 5, "kN");
        f1.addStatistic(5, "INTELLIGENCE", 69, "");
        cards.add(f1);

        // F2 - Apatosaurus
        CardInfo f2 = new CardInfo(
                "F2",
                "Apatosaurus",
                "SAUROPOD",
                R.drawable.dino_f2,
                'F',
                2,
                false
        );
        f2.addStatistic(0, "WEIGHT", 16.4, "tn");
        f2.addStatistic(1, "LENGTH", 21.0, "m");
        f2.addStatistic(2, "HEIGHT", 5.5, "m");
        f2.addStatistic(3, "SPEED", 13, "km/h");
        f2.addStatistic(4, "BITE FORCE", 4, "kN");
        f2.addStatistic(5, "INTELLIGENCE", 47, "");
        cards.add(f2);

        // F3 - Maiasaura
        CardInfo f3 = new CardInfo(
                "F3",
                "Maiasaura",
                "HADROSAURID",
                R.drawable.dino_f3,
                'F',
                3,
                false
        );
        f3.addStatistic(0, "WEIGHT", 2.5, "tn");
        f3.addStatistic(1, "LENGTH", 9.0, "m");
        f3.addStatistic(2, "HEIGHT", 3.0, "m");
        f3.addStatistic(3, "SPEED", 30, "km/h");
        f3.addStatistic(4, "BITE FORCE", 3, "kN");
        f3.addStatistic(5, "INTELLIGENCE", 82, "");
        cards.add(f3);

        // F4 - Styracosaurus
        CardInfo f4 = new CardInfo(
                "F4",
                "Styracosaurus",
                "CERATOPSIAN",
                R.drawable.dino_f4,
                'F',
                4,
                false
        );
        f4.addStatistic(0, "WEIGHT", 3.0, "tn");
        f4.addStatistic(1, "LENGTH", 5.5, "m");
        f4.addStatistic(2, "HEIGHT", 2.0, "m");
        f4.addStatistic(3, "SPEED", 25, "km/h");
        f4.addStatistic(4, "BITE FORCE", 12, "kN");
        f4.addStatistic(5, "INTELLIGENCE", 57, "");
        cards.add(f4);

        // G1 - Megalosaurus
        CardInfo g1 = new CardInfo(
                "G1",
                "Megalosaurus",
                "MEGALOSAURID",
                R.drawable.dino_g1,
                'G',
                1,
                false
        );
        g1.addStatistic(0, "WEIGHT", 1.0, "tn");
        g1.addStatistic(1, "LENGTH", 6.0, "m");
        g1.addStatistic(2, "HEIGHT", 2.5, "m");
        g1.addStatistic(3, "SPEED", 28, "km/h");
        g1.addStatistic(4, "BITE FORCE", 9, "kN");
        g1.addStatistic(5, "INTELLIGENCE", 64, "");
        cards.add(g1);

        // G2 - Compsognathus
        CardInfo g2 = new CardInfo(
                "G2",
                "Compsognathus",
                "COMPSOGNATHID",
                R.drawable.dino_g2,
                'G',
                2,
                false
        );
        g2.addStatistic(0, "WEIGHT", 0.003, "tn");
        g2.addStatistic(1, "LENGTH", 1.0, "m");
        g2.addStatistic(2, "HEIGHT", 0.4, "m");
        g2.addStatistic(3, "SPEED", 35, "km/h");
        g2.addStatistic(4, "BITE FORCE", 0.3, "kN");
        g2.addStatistic(5, "INTELLIGENCE", 75, "");
        cards.add(g2);

        // G3 - Edmontosaurus
        CardInfo g3 = new CardInfo(
                "G3",
                "Edmontosaurus",
                "HADROSAURID",
                R.drawable.dino_g3,
                'G',
                3,
                false
        );
        g3.addStatistic(0, "WEIGHT", 4.0, "tn");
        g3.addStatistic(1, "LENGTH", 12.0, "m");
        g3.addStatistic(2, "HEIGHT", 4.0, "m");
        g3.addStatistic(3, "SPEED", 40, "km/h");
        g3.addStatistic(4, "BITE FORCE", 4, "kN");
        g3.addStatistic(5, "INTELLIGENCE", 80, "");
        cards.add(g3);

        // G4 - Corythosaurus
        CardInfo g4 = new CardInfo(
                "G4",
                "Corythosaurus",
                "HADROSAURID",
                R.drawable.dino_g4,
                'G',
                4,
                false
        );
        g4.addStatistic(0, "WEIGHT", 4.0, "tn");
        g4.addStatistic(1, "LENGTH", 9.0, "m");
        g4.addStatistic(2, "HEIGHT", 4.0, "m");
        g4.addStatistic(3, "SPEED", 30, "km/h");
        g4.addStatistic(4, "BITE FORCE", 4, "kN");
        g4.addStatistic(5, "INTELLIGENCE", 77, "");
        cards.add(g4);

        // H1 - Albertosaurus
        CardInfo h1 = new CardInfo(
                "H1",
                "Albertosaurus",
                "TYRANNOSAURID",
                R.drawable.dino_h1,
                'H',
                1,
                false
        );
        h1.addStatistic(0, "WEIGHT", 2.5, "tn");
        h1.addStatistic(1, "LENGTH", 9.0, "m");
        h1.addStatistic(2, "HEIGHT", 3.0, "m");
        h1.addStatistic(3, "SPEED", 35, "km/h");
        h1.addStatistic(4, "BITE FORCE", 30, "kN");
        h1.addStatistic(5, "INTELLIGENCE", 79, "");
        cards.add(h1);

        // H2 - Baryonyx
        CardInfo h2 = new CardInfo(
                "H2",
                "Baryonyx",
                "SPINOSAURID",
                R.drawable.dino_h2,
                'H',
                2,
                false
        );
        h2.addStatistic(0, "WEIGHT", 1.2, "tn");
        h2.addStatistic(1, "LENGTH", 9.5, "m");
        h2.addStatistic(2, "HEIGHT", 3.0, "m");
        h2.addStatistic(3, "SPEED", 28, "km/h");
        h2.addStatistic(4, "BITE FORCE", 12, "kN");
        h2.addStatistic(5, "INTELLIGENCE", 74, "");
        cards.add(h2);

        // H3 - Oviraptor
        CardInfo h3 = new CardInfo(
                "H3",
                "Oviraptor",
                "OVIRAPTOROSAUR",
                R.drawable.dino_h3,
                'H',
                3,
                false
        );
        h3.addStatistic(0, "WEIGHT", 0.035, "tn");
        h3.addStatistic(1, "LENGTH", 2.0, "m");
        h3.addStatistic(2, "HEIGHT", 1.5, "m");
        h3.addStatistic(3, "SPEED", 40, "km/h");
        h3.addStatistic(4, "BITE FORCE", 1.0, "kN");
        h3.addStatistic(5, "INTELLIGENCE", 85, "");
        cards.add(h3);

        // H4 - Plateosaurus - SUPER ULTIMA
        CardInfo h4 = new CardInfo(
                "H4",
                "Plateosaurus",
                "PLATEOSAUR",
                R.drawable.dino_h4,
                'H',
                4,
                true
        );
        h4.addStatistic(0, "WEIGHT", 0.7, "tn");
        h4.addStatistic(1, "LENGTH", 7.0, "m");
        h4.addStatistic(2, "HEIGHT", 3.0, "m");
        h4.addStatistic(3, "SPEED", 25, "km/h");
        h4.addStatistic(4, "BITE FORCE", 2, "kN");
        h4.addStatistic(5, "INTELLIGENCE", 68, "");
        cards.add(h4);
    }

    public List<CardInfo> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}