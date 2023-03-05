package org.example.Obstacles;

public class Wall extends Obstacles{
    private final int height;

    public Wall(String name) {
        super("Стена", name);
        this.height = random.nextInt(10,2000);
    }

    public int getHeight() {
        return height;
    }
}
