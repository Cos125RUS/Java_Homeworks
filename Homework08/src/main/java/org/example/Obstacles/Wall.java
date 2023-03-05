package org.example.Obstacles;

import org.example.Creatures.Thing;

public class Wall extends Obstacles implements Barrier{
    private final int height;

    public Wall(String name) {
        super("Стена", name);
        this.height = random.nextInt(1,5);
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean takeBarrier(Thing thing) {
        if (thing.getMaxJumpHeight() > height) {
            thing.jump(true);
            System.out.println(getHeight() + "м.");
            return true;
        }
        else {
            thing.jump(false);
            System.out.println(getHeight() + "м.");
            return false;
        }
    }
}
