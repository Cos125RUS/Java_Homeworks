package org.example.AppSystem.WorkingWithFiles.Parsing;

import org.example.Model.Members.Student;

/**
 * Интерфейс для парсинга студентов
 */
public interface ToStudentImpl {
    Student pars(String line);
}
