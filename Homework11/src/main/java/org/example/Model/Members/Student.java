package org.example.Model.Members;

import java.time.LocalDate;
import java.util.List;

public class Student extends User{
    int groupId;
    List<Integer> groups;

    public Student(LocalDate dateBirth, String fio, int id) {
        super(LocalDate.now(), "Ivanov I.O.", 23);
    }

    public Student() {
        super(LocalDate.now(), "Ivanov I.O.", 23);
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
