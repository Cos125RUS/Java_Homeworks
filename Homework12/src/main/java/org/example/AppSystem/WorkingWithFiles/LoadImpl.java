package org.example.AppSystem.WorkingWithFiles;

import org.example.Model.Members.Student;

import java.util.List;

/**
 * Интерфейс для загрузки БД
 */
public interface LoadImpl {
    List<Student> loadStudents();
    List<String> loadTeachers();
    List<String> loadStudyGroups();
}
