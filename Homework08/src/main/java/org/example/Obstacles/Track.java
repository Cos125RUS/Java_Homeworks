package org.example.Obstacles;

import java.util.Random;

public class Track extends Obstacles{
    private final int distance;

    public Track(String name) {
        super("Дорожка", name);
        this.distance = random.nextInt(10,2000);
    }

    public int getDistance() {
        return distance;
    }
}
