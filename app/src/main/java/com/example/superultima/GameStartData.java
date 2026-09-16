package com.example.superultima;



import com.example.superultima.cardgame.Game;

import java.io.Serializable;

public class GameStartData implements Serializable {

    private static final long serialVersionUID = 1L;

    public final String deckName;
    public final Game game;

    public GameStartData(
            String deckName,
            Game game) {

        this.deckName = deckName;
        this.game = game;
    }
}