package org.example.game;

import java.util.ArrayList;
import java.util.List;

public class WordEnglishGame extends AbstractGame{

    @Override
    List<String> generateCharList() {
        List<String> charList = new ArrayList<String>();
        for (int i = 97; i < 123; ++i) {
            charList.add(String.valueOf(Character.toChars(i)));
        }
        return charList;
    }

    @Override
    boolean gameCheck(String value) {
        for (int i = 0; i < value.length(); i++) {
            int hash = ((Character)value.charAt(i)).hashCode();
            if (hash < 97 || hash > 122) {
                System.out.println("Что ты ввёл-то? Английские букавки тыкай!");
                return false;
            }
        }
        return true;
    }
}
