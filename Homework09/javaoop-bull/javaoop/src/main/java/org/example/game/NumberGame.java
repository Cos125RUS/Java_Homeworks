package org.example.game;

import java.util.ArrayList;
import java.util.List;

public class NumberGame extends AbstractGame {
    @Override
    List<String> generateCharList() {
        List<String> charList = new ArrayList<String>();
        for (int i = 0; i < 10; ++i) {
            charList.add(String.valueOf(i));
        }
        return charList;
    }

    @Override
    boolean gameCheck(String value) {
        try {
            int a = Integer.parseInt(value);
            return true;
        }
        catch (Exception e){
            System.out.println("Что ты ввёл-то?! Наугад что ли тыкал? Нормально вводи!");
            return false;
        }
    }
}
