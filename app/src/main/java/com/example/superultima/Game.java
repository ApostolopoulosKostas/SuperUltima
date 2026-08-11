package com.example.superultima;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player>players = new ArrayList<>();
            public Game(int numberOfPlayers){
        for (int i=0;i<numberOfPlayers;i++){
            players.add(new Player());
        }
            }




}






