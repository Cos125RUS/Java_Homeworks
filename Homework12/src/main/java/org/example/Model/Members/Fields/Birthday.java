package org.example.Model.Members.Fields;

/**
 * Класс для хранения информации о дате
 * Реализован принцип единственной ответственности
 */
public class Birthday {
    int day;
    int month;
    int year;

    public Birthday(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Дата рождения: " +
                day +
                "." + month +
                "." + year +
                "г.";
    }
}
