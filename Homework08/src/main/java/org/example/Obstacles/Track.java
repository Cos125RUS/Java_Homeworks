package org.example.Obstacles;

import org.example.Creatures.Thing;

import java.util.Random;

public class Track extends Obstacles implements Barrier{
    private final int distance;

    public Track(String name) {
        super("Дорожка", name);
        this.distance = random.nextInt(10,1000);
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean takeBarrier(Thing thing) {
        if (thing.getMaxRunDistance() > distance) {
            thing.run(true);
            System.out.println(getDistance() + "м.");
            return true;
        }
        else {
            thing.run(false);
            System.out.println(getDistance() + "м.");
            return false;
        }
    }
}
