package org.example.AppSystem.WorkingWithFiles;

import java.io.File;

/**
 * Класс проверки БД на конпьютере
 */
public class SearchEngine implements SearchImpl{
    String pathDir;
    boolean[] flags;

    public SearchEngine(String pathDir) {
        this.pathDir = pathDir;
        flags = new boolean[3];
    }

    @Override
    public boolean[] searchFiles(String pathDir) {
        for (String s: new File(pathDir).list()) {
            if (s.equals("students.txt"))
                flags[0] = true;
            else if (s.equals("teachers.txt")) {
                flags[1] = true;
            } else if (s.equals("StudyGroups.txt")) {
                flags[2] = true;
            }
        }
        return flags;
    }
}
