package org.example.View;

/**
 * Модуль с функцией вывода информации в консоль
 * Реализован принцип открытости/закрытости:
 * Класс View не переписывался, но расширился за счёт наследника ConsoleView
 */
public class ConsoleView extends View{
    public ConsoleView() {
    }

    public void show(String data){
        System.out.println(data);
    }
}
