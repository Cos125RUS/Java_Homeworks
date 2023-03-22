package org.example.Model.Members.Fields;

/**
 * Класс для добавления даты
 * Реализован принцип единственной ответственности
 */
public class AdderDate implements AdderDateImpl {
    String value;
    int d;
    int m;
    int y;

    public AdderDate(String value) {
        this.value = value;
        String[] values = value.replace(".", ". ").split(". ");
        this.d = Integer.parseInt(values[0]);
        this.m = Integer.parseInt(values[1]);
        this.y = Integer.parseInt(values[2]);
    }

    @Override
    public Birthday addDate() {
        return new Birthday(d, m, y);
    }
}
