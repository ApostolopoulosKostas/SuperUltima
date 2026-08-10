package com.example.superultima;

public class Airplane {

    String code;
    String name;
    String type;
    int image;

    double speed;
    double autonomy;
    double wings;
    double length;
    double weight;
    double maxHeight;

    char letter;
    int number;
    boolean superUltima;

    public Airplane(
            String code,
            String name,
            String type,
            int image,
            double speed,
            double autonomy,
            double wings,
            double length,
            double weight,
            double maxHeight,
            char letter,
            int number,
            boolean superUltima) {

        this.code = code;
        this.name = name;
        this.type = type;
        this.image = image;

        this.speed = speed;
        this.autonomy = autonomy;
        this.wings = wings;
        this.length = length;
        this.weight = weight;
        this.maxHeight = maxHeight;

        this.letter = letter;
        this.number = number;
        this.superUltima = superUltima;
    }
}




