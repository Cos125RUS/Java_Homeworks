package org.example.Creatures;

public class Bot extends Thing {
    private static String[] names = {"Т1000", "Электроник", "r2d2", "c3po", "Пылесос", "Фёдор",
            "Xiaomi", "Valli", "Полотёр", "Ведро с болтами"};
    private static int count;
    public Bot() {
        super(random.nextInt(100,10000),
                random.nextInt(0,10), "Робот", names[count++]);
    }
}
