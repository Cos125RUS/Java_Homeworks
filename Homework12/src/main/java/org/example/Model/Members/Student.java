package org.example.Model.Members;

import java.time.LocalDate;
import java.util.List;

public class Student extends User{
    int groupId;
    List<Integer> grades;

    public Student(String dateBirth, String fio) {
        super(dateBirth, fio);
    }

    public Student() {
        super(LocalDate.now().toString(), "Ivanov I.O.", 23);
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
        return "Student{" +
                "dateBirth='" + dateBirth + '\'' +
                ", fio='" + fio + '\'' +
                ", id=" + id +
                '}';
    }
}
