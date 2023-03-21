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

    public Teacher(LocalDate dateBirth, String fio, int id) {
        super(LocalDate.now().toString(), "Petrov I.O.", 29);
    }

    public Teacher() {
        super(LocalDate.now().toString(), "Petrov I.O.", 29);
    }

    public Teacher(String dateBirth, String fio) {
        super(dateBirth, fio);
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
                "dateBirth='" + dateBirth + '\'' +
                ", fio='" + fio + '\'' +
                ", id=" + id +
                '}';
    }
}
