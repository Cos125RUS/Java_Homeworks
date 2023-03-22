package org.example.Model.Members;

import org.example.Model.Groups.StudyGroup;

import java.time.LocalDate;
import java.util.List;

/**
 * Класс Учитель дополнен опытом и сипском групп, у которых преподаватель преподаёт
 * Реализован принцип подстановки Барбары Лисков
 */
public class Teacher extends User{
    int experience;
    List<Integer> groupsId;

    public Teacher(String fio,LocalDate dateBirth, int id) {
        super("Petrov I.O.",LocalDate.now().toString(), 29);
    }

    public Teacher() {
        super("Petrov I.O.",LocalDate.now().toString(), 29);
    }

    public Teacher(String dateBirth, String fio) {
        super(fio,dateBirth);
    }


    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                ", fio='" + fio + '\'' +
                "dateBirth='" + dateBirth + '\'' +
                ", id=" + id +
                '}';
    }
}
