package org.example.AppSystem.WorkingWithFiles;

import org.example.AppSystem.WorkingWithFiles.Parsing.ToStudent;
import org.example.Model.Members.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс загрузки БД
 */
public class LoadEngine implements LoadImpl{
    String pathDir;
    ToStudent toStudent;

    public LoadEngine(String pathDir) {
        this.pathDir = pathDir;
    }

    @Override
    public List<Student> loadStudents() {
        List<String> files = loadFiles(pathDir + "Students.txt");
        List<Student> students = new ArrayList<>();
        for (String line:files) {
            students.add(toStudent.pars(line));
        }
        return students;
    }

    @Override
    public List<String> loadTeachers() {
        return null;
    }

    @Override
    public List<String> loadStudyGroups() {
        return null;
    }

    private List<String> loadFiles(String pathFile) {
        List<String> files = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathFile));
            String line;
            while ((line = reader.readLine()) != null){
                files.add(line);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return files;
    }

}
