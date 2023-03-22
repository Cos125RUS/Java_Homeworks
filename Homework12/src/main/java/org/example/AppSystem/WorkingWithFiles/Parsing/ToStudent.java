package org.example.AppSystem.WorkingWithFiles.Parsing;

import org.example.Model.Members.Fields.AdderDate;
import org.example.Model.Members.Fields.Birthday;
import org.example.Model.Members.Student;

/**
 * Класс для парсинга записи из БД в класс Student
 */
public class ToStudent implements ToStudentImpl{

    public ToStudent() {
    }

    @Override
    public Student pars(String line) {
        line = line.split("Студент id=")[1];
        String[] s = line.replace(")","").split(" ФИО:'");
        int id = Integer.parseInt(s[0]);
        String[] ss = s[1].split("', ");
        String fio = ss[0];
        s = ss[1].split(", Учебная группа №");
        String birthday = s[0];
        int groupId = Integer.parseInt(s[1]);
        return new Student(id, fio, birthday, groupId);
    }
}
