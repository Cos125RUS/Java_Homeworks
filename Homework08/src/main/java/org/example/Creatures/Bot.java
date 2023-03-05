package org.example.Creatures;

public class Bot extends Thing {
    public Bot(String name) {
        super(random.nextInt(100,10000),
                random.nextInt(0,10), "Робот", name);
    }
}
