package org.example;

import org.example.AppSystem.AppSystem;
import org.example.AppSystem.Controller.Controller;

public class App {
    public static void main(String[] args) {
        new AppSystem().startSystem();
        new Controller().start();
    }
}
