package org.example;

/**
 * Написать программу, определяющую правильность расстановки скобок в выражении.
 * Пример 1: a+(d*3) - истина
 * Пример 2: [a+(1*3) - ложь
 * Пример 3: [6+(3*3)] - истина
 * Пример 4: {a}[+]{(d*3)} - истина
 * Пример 5: <{a}+{(d*3)}> - истина
 * Пример 6: {a+]}{(d*3)} - ложь
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(Check.check("(1+2)*(3-4)-[2+9]/{21/7}*<12-35>"));
//        System.out.println(Check.check(View.in("Enter: ")));
    }
}