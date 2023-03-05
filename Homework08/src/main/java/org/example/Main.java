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

        int partySize = 10;
        Thing[] party = new Thing[partySize];
        for (int i = 0; i < partySize; i++)
            party[i] = randThings(i);

        int barriersCount = 10;
        Obstacles[] barriers = new Obstacles[barriersCount];
        for (int i = 0; i < barriersCount; i++)
            barriers[i] = randBarriers(i);

        for (Thing t: party) {
            boolean ckeck = true;
            for (Obstacles o : barriers)
                if (!o.takeBarrier(t)) {
                    ckeck = false;
                    break;
                }
            if (ckeck) t.finish();
            System.out.println();
        }
    }

    public static Thing randThings (int i){
        Random random = new Random();
        int choice = random.nextInt(3);

        if (choice == 0)
            return new Human();
        else if (choice == 1)
            return new Bot();
        else
            return new Cat();
    }

    public static Obstacles randBarriers (int i){
        Random random = new Random();
        String name = String.format("Barriers_№" + i);
        int choice = random.nextInt(2);

        if (choice == 0)
            return new Track(name);
        else
            return new Wall(name);
    }
}