package org.example.Creatures;


public class Human extends Thing{
    private static String[] names = {"Вася", "Петя", "Дима", "Гена", "Женя", "Игорь", "Слава",
                                        "Илья", "Семён", "Игнат"};
    private static int count;
    public Human() {
        super(random.nextInt(500,800),
                random.nextInt(1,4), "Человек", names[count++]);
    }
}
