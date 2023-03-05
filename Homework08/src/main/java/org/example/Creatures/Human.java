package org.example.Creatures;

import java.util.Random;

public class Human extends Thing{
    public Human(String name) {
        super(random.nextInt(500,800),
                random.nextInt(1,4), "Человек", name);
    }
}
