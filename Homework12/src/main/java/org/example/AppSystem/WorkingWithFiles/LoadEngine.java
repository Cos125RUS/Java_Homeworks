package org.example.AppSystem.WorkingWithFiles;

import org.example.AppSystem.WorkingWithFiles.Converter.Convert;
import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс загрузки БД
 */
public class LoadEngine implements LoadImpl {
    String pathDir;
    Convert convert;

    public LoadEngine(String pathDir) {
        this.pathDir = pathDir;
    }

    @Override
    public List<Student> loadStudents() {
        List<String> files = loadFiles(pathDir + "Students.txt");
        List<Student> students = new ArrayList<>();
        for (String line : files) {
            students.add(convert.toStudent(line));
        }
        return students;
    }

    @Override
    public List<Teacher> loadTeachers() {
        List<String> files = loadFiles(pathDir + "Teachers.txt");
        List<Teacher> teachers = new ArrayList<>();
        for (String line : files) {
            teachers.add(convert.toTeacher(line));
        }
        return teachers;
    }

    @Override
    public List<StudyGroup> loadStudyGroups() {
        List<String> files = loadFiles(pathDir + "StudyGroups.txt");
        List<StudyGroup> studyGroups = new ArrayList<>();
        for (String line : files) {
            studyGroups.add(convert.toStudyGroup(line));
        }
        return studyGroups;
    }

    private List<String> loadFiles(String pathFile) {
        List<String> files = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathFile));
            String line;
            while ((line = reader.readLine()) != null) {
                files.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return files;
    }

}
