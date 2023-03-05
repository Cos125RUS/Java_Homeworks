package org.example.Creatures;

public class Cat extends Thing{
    private static String[] names = {"Пушок", "Снежок", "Барсик", "Мурка", "Обормот", "Семён",
                                        "Клубок", "Том", "Котофей", "Пирожок"};
    private static int count;
    public Cat() {
        super(random.nextInt(20,400),
                random.nextInt(2,5), "Кот", names[count++]);
    }
}
