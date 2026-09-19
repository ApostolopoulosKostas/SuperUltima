package com.example.superultima;



import java.io.Serializable;

/**
 * The data sent from the host to guests when a nearby multiplayer game
 * begins. Notably, this does NOT include any card data - just enough for
 * each device to build the identical deck locally (see Game's seeded
 * constructor and DecksRepository.getDeckCardsByName). This way, no
 * player's hand (including cards they haven't drawn yet) is ever
 * transmitted over the network or visible to another device.
 */
public class GameStartData implements Serializable {

    private static final long serialVersionUID = 1L;

    public final String deckName;
    public final int playerCount;
    public final long shuffleSeed;

    public GameStartData(
            String deckName,
            int playerCount,
            long shuffleSeed) {

        this.deckName = deckName;
        this.playerCount = playerCount;
        this.shuffleSeed = shuffleSeed;
    }
}