package org.example.game;

import java.util.ArrayList;
import java.util.List;

public class WordRussianGame extends AbstractGame{
    @Override
    List<String> generateCharList() {
        List<String> charList = new ArrayList<String>();
        for (int i = 1072; i < 1104; ++i) {
            charList.add(String.valueOf(Character.toChars(i)));
        }
        return charList;
    }

    @Override
    boolean gameCheck(String value) {
        for (int i = 0; i < value.length(); i++) {
            int hash = ((Character)value.charAt(i)).hashCode();
            if (hash < 1072 || hash > 1103) {
                System.out.println("Что ты ввёл-то?! Русский язык совсем забыл, да?");
                return false;
            }
        }
        return true;
    }
}
