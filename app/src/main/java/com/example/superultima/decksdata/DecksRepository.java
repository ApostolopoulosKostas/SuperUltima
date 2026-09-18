package com.example.superultima.decksdata;

import com.example.superultima.R;
import com.example.superultima.decks.AirplanesDeck;
import com.example.superultima.decks.CinemaCars;
import java.util.ArrayList;
import java.util.List;
import com.example.superultima.decks.MythicalMonsters;
import com.example.superultima.decks.TanksDeck;
import com.example.superultima.decks.WarShips;
public class DecksRepository {
    public static List<DeckInfo> getDecks() {

        List<DeckInfo> decks = new ArrayList<>();

        decks.add(new DeckInfo(
                "AIRPLANES",
                R.drawable.airplane1frontimage,
                new AirplanesDeck().getCards()
        ));

        decks.add(new DeckInfo(
                "CINEMA CARS",
                R.drawable.moviecars_b3,
                new CinemaCars().getCards()
        ));



        decks.add(new DeckInfo(
                "MYTHICAL BEASTS",
                R.drawable.mythical_monsters_a1,
                new MythicalMonsters().getCards()
        ));

        decks.add(new DeckInfo(
                "Tanks",
                R.drawable.tanks_a1,
                new TanksDeck().getCards()
        ));

        decks.add(new DeckInfo(
                "Warships",
                R.drawable.warships_a1,
                new WarShips().getCards()
        ));



        return decks;
    }

}
