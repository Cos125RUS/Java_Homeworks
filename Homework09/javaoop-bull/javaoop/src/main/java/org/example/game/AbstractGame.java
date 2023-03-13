package org.example.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractGame implements Game {
    Integer sizeWord;
    String word;
    Integer maxTry;
    Log[] log;
    static int countTry;
    GameStatus gameStatus;

    private int getCountTry() {
        return countTry;
    }

    private boolean check(String value){
        return gameCheck(value) && lengthCheck(value);
    }

    private boolean lengthCheck(String value){
        if (sizeWord == value.length())
            return true;
        else {
            System.out.println("Считать совсем не умеешь, да? " +
                    "Длина слова видишь, какой должна быть? " +
                    "Вот столько и вводи.");
            return false;
        }
    }

    @Override
    public String getLog(){
        StringBuilder sb = new StringBuilder();
        sb.append("История ходов:\n");
        for (Log l: log) {
            sb.append(l.getStringLog()).append("\n");
        }
        return sb.toString();
    }

    private void numsTry(){
        System.out.printf("Осталось %d попыток.\n", maxTry - getCountTry());
    }

    private String generateWord() {
        List<String> charList = generateCharList();
        SecureRandom random = new SecureRandom();
        String res = "";
        for (int i = 0; i < sizeWord; i++) {
            int randomeIndex = random.nextInt(charList.size());
            res += charList.get(randomeIndex);
            charList.remove(randomeIndex);
        }
        return res;
    }

    @Override
    public void newGame(Integer sizeWord, Integer maxTry) {
        this.maxTry = maxTry;
        this.sizeWord = sizeWord;
        init();
        word = generateWord();
        log = new Log[maxTry];
        this.gameStatus = GameStatus.START;
        strtGame();
    }

    private void init(){
        this.gameStatus = GameStatus.INIT;
        System.out.printf("Длина слова - %d.\n" +
                "У тебя %d попыток.\n", sizeWord, maxTry);
    }

    private void strtGame(){
        Scanner in = new Scanner(System.in);
        while (getGameStatus().equals(GameStatus.START)) {
            System.out.println("Ну давай, ходи:");
            String answer;
            do {
                answer = in.next();
            } while (!check(answer));
            Answer answerGame = inputAnswer(answer);
            answerGame.getAnswer();
            numsTry();
        }
        System.out.println(getGameStatus());
        System.out.println(getWord());
    }

    private Answer inputAnswer(String value) {
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < value.length(); i++) {
            if (word.contains(Character.toString(value.charAt(i)))) {
                cow++;
            }
            if (word.charAt(i) == value.charAt(i)) {
                bull++;
            }
        }
        Answer answer = new Answer(cow, bull, value);
        log[countTry++] = new Log(countTry, value, answer);
        gameStatus = checkState(value);
        return answer;
    }

    private GameStatus checkState(String value) {
        if (value.equals(word)) {
            return gameStatus = GameStatus.WIN;
        } else {
            if (countTry >= maxTry) {
                return gameStatus = GameStatus.LOSE;
            } else {
                return gameStatus = GameStatus.START;
            }
        }

    }

    abstract List<String> generateCharList();
    abstract boolean gameCheck(String value);
}

