package org.example.View.In;

import java.util.Scanner;

/**
 * Класс реализует ввод данных
 */
public class In implements ImplIn{
    Scanner scanner;

    public In() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String enterString(){
        return scanner.nextLine();
    }
}
