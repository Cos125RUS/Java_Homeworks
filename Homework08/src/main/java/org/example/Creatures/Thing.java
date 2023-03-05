package org.example.Creatures;

import java.util.Random;

public class Thing {
    protected static Random random = new Random();
    protected int maxRunDistance;
    protected int maxJumpHeight;
    protected String type;
    protected String name;

    public Thing(int maxRunDistance, int maxJumpHeight, String type, String name) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.type = type;
        this.name = name;
    }

    public void run(boolean check) {
        if (check)
            System.out.print(type + " " + name + " пробежал дистанцию ");
        else
            System.out.print(type + " " + name + " не смог одолеть дистанцию ");
    }

    public void jump(boolean check) {
            if (check)
                System.out.print(type + " " + name + " преодолел препятствие ");
            else
                System.out.print(type + " " + name + " не взял барьер ");
    }

    public void finish (){
        System.out.println(type + " " + name + " добрался до финиша!!!");
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }
}
