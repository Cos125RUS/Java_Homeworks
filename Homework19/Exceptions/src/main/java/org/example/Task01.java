package org.example;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        float num = enterFloat();
        System.out.println("number = " + num);
    }

    public static float enterFloat() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        System.out.print("Enter float number: ");
        try {
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Введены недопустимые символы");
            return enterFloat();
        }
    }
}