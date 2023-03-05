package org.example.Creatures;

public class Cat extends Thing{
    public Cat(String name) {
        super(random.nextInt(20,400),
                random.nextInt(2,5), "Кот", name);
    }
}
