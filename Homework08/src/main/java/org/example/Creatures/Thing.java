package org.example.Creatures;

import org.example.Obstacles.Obstacles;
import org.example.Obstacles.Track;
import org.example.Obstacles.Wall;

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

    public void run(int distance) {
        if (distance > maxRunDistance)
            System.out.println(type + " " + name + " не смог одолеть дистанцию.");
        else System.out.println(type + " " + name + " пробежал дистанцию!");
    }

    public void jump(int height) {
            if (height > maxJumpHeight)
                System.out.println(type + " " +name + " не взял барьер.");
            else System.out.println(type + " " +name  + " преодолел препятствие!");
    }

    public boolean doIt (Obstacles obstacles){
        if (obstacles instanceof Track) {
            run(((Track) obstacles).getDistance());
            if (((Track) obstacles).getDistance() > maxRunDistance)
                return false;
            else return true;
        }
        else {
            jump(((Wall) obstacles).getHeight());
            if (((Wall) obstacles).getHeight() > maxJumpHeight)
                return false;
            else return true;
        }
    }
}
