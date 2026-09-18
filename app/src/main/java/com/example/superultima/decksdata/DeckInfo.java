package com.example.superultima.decksdata;

import com.example.superultima.cardgame.CardInfo;

import java.util.List;

public class DeckInfo {

    public String name;
    public int image;
    public List<CardInfo> cards;

    public DeckInfo(String name, int image, List<CardInfo> cards) {
        this.name = name;
        this.image = image;
        this.cards = cards;
    }
}