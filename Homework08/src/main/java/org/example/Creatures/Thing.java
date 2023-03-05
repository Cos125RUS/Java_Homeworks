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

    public boolean run(int distance) {
        if (distance > maxRunDistance) {
            System.out.println(type + " " + name + " не смог одолеть дистанцию.");
            return false;
        }
        else {
            System.out.println(type + " " + name + " пробежал дистанцию!");
            return true;
        }
    }

    public boolean jump(int height) {
            if (height > maxJumpHeight) {
                System.out.println(type + " " + name + " не взял барьер.");
                return false;
            }
            else {
                System.out.println(type + " " + name + " преодолел препятствие!");
                return true;
            }
    }

    public boolean doIt (Obstacles obstacles){
        if (obstacles instanceof Track) {
            if (run(((Track) obstacles).getDistance()))
                return true;
            else return false;
        }
        else {
            if (jump(((Wall) obstacles).getHeight()))
                return true;
            else return false;
        }
    }
}
