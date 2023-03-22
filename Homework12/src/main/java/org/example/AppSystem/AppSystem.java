package org.example.AppSystem;

import org.example.AppSystem.WorkingWithFiles.LoadEngine;
import org.example.AppSystem.WorkingWithFiles.SaveEngine;
import org.example.AppSystem.WorkingWithFiles.SearchEngine;

import java.io.BufferedReader;
import java.io.FileReader;

public class AppSystem implements SystemImpl {
    String pathConfig;
    String pathDir;
    SearchEngine searchEngine;
    LoadEngine loadEngine;
    SaveEngine saveEngine;

    public AppSystem() {
        this.pathConfig = "C:\\repo\\Java\\Homeworks\\Homework12\\src\\main\\java\\org\\example\\AppSystem\\Config.txt";
        this.pathDir = readPathDir(pathConfig);
        this.searchEngine = new SearchEngine(pathDir);
        this.loadEngine = new LoadEngine(pathDir);
        this.saveEngine = new SaveEngine(pathDir);
    }


    private String readPathDir(String pathConfig) {
        try {
            return new BufferedReader(new FileReader(pathConfig)).readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void startSystem() {

    }
}
