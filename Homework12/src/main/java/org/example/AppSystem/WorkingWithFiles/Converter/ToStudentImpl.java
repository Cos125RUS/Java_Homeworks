package org.example.AppSystem.WorkingWithFiles.Converter;

import org.example.Model.Members.Student;

/**
 * Интерфейс для парсинга студентов
 */
public interface ToStudentImpl {
    Student toStudent(String line);
}
