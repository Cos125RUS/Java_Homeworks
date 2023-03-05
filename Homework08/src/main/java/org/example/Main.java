package org.example;

import org.example.Creatures.Bot;
import org.example.Creatures.Cat;
import org.example.Creatures.Human;
import org.example.Creatures.Thing;
import org.example.Obstacles.Obstacles;
import org.example.Obstacles.Track;
import org.example.Obstacles.Wall;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int partySize = 5;
        Thing[] paty = new Thing[partySize];
        for (int i = 0; i < partySize; i++)
            paty[i] = randThings(i);

        int barriersCount = 10;
        Obstacles[] barriers = new Obstacles[barriersCount];
        for (int i = 0; i < barriersCount; i++)
            barriers[i] = randBarriers(i);

        for (Thing t: paty)
            for (Obstacles o: barriers)
                if (!t.doIt(o)) break;
    }

    public static Thing randThings (int i){
        Random random = new Random();
        String name = String.format("Participant_" + i);
        int choce = random.nextInt(3);

        if (choce == 0)
            return new Human(name);
        else if (choce == 1)
            return new Bot(name);
        else
            return new Cat(name);
    }

    public static Obstacles randBarriers (int i){
        Random random = new Random();
        String name = String.format("Barriers_" + i);
        int choce = random.nextInt(2);

        if (choce == 0)
            return new Track(name);
        else
            return new Wall(name);
    }
}