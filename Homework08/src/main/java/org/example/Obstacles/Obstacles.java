package org.example.Obstacles;

import java.util.Random;

public class Obstacles {
    protected static Random random = new Random();
    protected String type;
    protected String name;

    public Obstacles(String type, String name) {
        this.type = type;
        this.name = name;
    }
}
