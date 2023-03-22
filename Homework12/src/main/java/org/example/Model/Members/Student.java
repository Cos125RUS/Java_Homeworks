package org.example.Model.Members;

import java.time.LocalDate;
import java.util.List;

/**
 * Класс Студентов дополнен информацией об ID группы и оценках учащегося
 * Реализован принцип подстановки Барбары Лисков
 */
public class Student extends User{
    int groupId;
    List<Integer> grades;

    public Student(String fio,String dateBirth) {
        super(fio,dateBirth);
    }

    public Student(int id, String fio, String dateBirth, int groupId) {
        super(fio, dateBirth);
        this.groupId = groupId;
        super.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<Integer> getGroups() {
        return grades;
    }

    @Override
    public String toString() {
        return "(Студент id=" + id +
                ") ФИО:'" + fio + '\'' +
                ", " + dateBirth +
                ", Учебная группа №" + groupId;
    }
}
