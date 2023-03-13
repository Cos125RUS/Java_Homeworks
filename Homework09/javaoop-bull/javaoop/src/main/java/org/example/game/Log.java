package org.example.game;

public class Log {
    int moveNumber;
    String moveValue;
    Answer moveAnswer;

    public Log(int moveNumber, String moveValue, Answer moveAnswer) {
        this.moveNumber = moveNumber;
        this.moveValue = moveValue;
        this.moveAnswer = moveAnswer;
    }

    public String getStringLog(){
        return String.format("На %d ходу (%s) %s", moveNumber, moveValue, moveAnswer.getAnswer());
    }
}
