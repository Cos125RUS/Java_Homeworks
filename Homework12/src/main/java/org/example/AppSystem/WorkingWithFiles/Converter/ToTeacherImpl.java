package org.example.AppSystem.WorkingWithFiles.Converter;

import org.example.Model.Members.Teacher;

/**
 * Интерфейс конвертации String to Teacher
 */
public interface ToTeacherImpl {
    Teacher toTeacher (String line);

}
