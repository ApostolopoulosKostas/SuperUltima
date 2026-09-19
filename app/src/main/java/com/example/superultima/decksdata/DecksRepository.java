package com.example.superultima.decksdata;

import com.example.superultima.R;
import com.example.superultima.decks.AirplanesDeck;
import com.example.superultima.decks.CinemaCars;
import java.util.ArrayList;
import java.util.List;

import com.example.superultima.decks.MythicalGods;
import com.example.superultima.decks.MythicalHeroes;
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
                "TANKS",
                R.drawable.tanks_a1,
                new TanksDeck().getCards()
        ));

        decks.add(new DeckInfo(
                "WARSHIPS",
                R.drawable.warships_a1,
                new WarShips().getCards()
        ));

        decks.add(new DeckInfo(
                "Mythical Heroes",
                R.drawable.mythicalheroes_a1,
                new MythicalHeroes().getCards()
        ));

        decks.add(new DeckInfo(
                "Mythical Gods",
                R.drawable.gods_a1,
                new MythicalGods().getCards()
        ));





        return decks;
    }

    /**
     * Finds a deck's card list by its display name (as sent over the network
     * at multiplayer game start). Used so a guest device can rebuild the
     * SAME deck locally, instead of the host sending the actual card data.
     * @param name The deck's display name (e.g. "AIRPLANES").
     * @return The matching deck's cards, or an empty list if no deck matches.
     */
    public static List<com.example.superultima.cardgame.CardInfo> getDeckCardsByName(String name) {
        for (DeckInfo deck : getDecks()) {
            if (deck.name.equals(name)) {
                return deck.cards;
            }
        }
        return new ArrayList<>();
    }

}