package org.example.AppSystem.WorkingWithFiles.Converter;

import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;

/**
 * Класс для парсинга записи из БД в класс Student
 */
public class Convert implements ToStudentImpl, ToTeacherImpl, ToStudyGroup{


    public Convert() {
    }

    @Override
    public Student toStudent(String line) {
        line = line.replace("(","").split("Студент id=")[1];
        String[] s = line.replace(")","").split(" ФИО:'");
        int id = Integer.parseInt(s[0]);
        String[] ss = s[1].split("', ");
        String fio = ss[0];
        s = ss[1].split(", Учебная группа №");
        String birthday = s[0];
        int groupId = Integer.parseInt(s[1]);
        return new Student(id, fio, birthday, groupId);
    }

    @Override
    public Teacher toTeacher(String line) {
        line = line.replace("(","").split("Преподаватель id=")[1];
        String[] s = line.replace(")","").split(" ФИО:'");
        int id = Integer.parseInt(s[0]);
        String[] ss = s[1].split("', ");
        String fio = ss[0];
        s = ss[1].split(", Стаж - ");
        String birthday = s[0];
        int experience = Integer.parseInt(s[1]);
        return new Teacher(id, fio, birthday, experience);
    }

    @Override
    public StudyGroup toStudyGroup(String line) {
        line = line.replace("(","").split("Группа №")[1];
        String[] s = line.split(", Куратор: ");
        int groupId = Integer.parseInt(s[0]);
        String[] ss = s[1].split(", Количество учащихся:");
        String leader = ss[0];
        int members = Integer.parseInt(ss[1]);

        return null;
    }
}
