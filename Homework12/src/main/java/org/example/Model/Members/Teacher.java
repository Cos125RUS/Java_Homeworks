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

    public Teacher(String fio, String dateBirth) {
        super(fio,dateBirth);
    }

    public Teacher(int id, String fio, String dateBirth, int experience) {
        super(id, fio, dateBirth);
        this.experience = experience;
    }


    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "(Преподаватель id=" + id +
                ") ФИО:'" + fio + '\'' +
                ", " + dateBirth +
                ", Стаж - " + experience;
    }
}
