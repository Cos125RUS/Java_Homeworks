package org.example;

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        System.out.println("Your line: " + stringEnter());
    }

    public static String stringEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String line = scanner.nextLine();
        if (line.length() == 0)
            throw new RuntimeException("А-та-та! Нельзя вводить пустую строку!");
        return line;
    }
}
