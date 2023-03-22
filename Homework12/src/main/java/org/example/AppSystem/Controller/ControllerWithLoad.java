package org.example.AppSystem.Controller;

import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;

import java.util.List;

/**
 * Наследник класса Controller, поддерживающий загрузку/сохранение БД
 * Реализован принцип открытости/закрытости
 */
public class ControllerWithLoad extends Controller{

    public ControllerWithLoad(List<Student> students, List<Teacher> teachers,
                              List<StudyGroup> studyGroups) {
        super.students = students;
        super.teachers = teachers;
        super.studyGroups = studyGroups;
    }
}
