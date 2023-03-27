package org.example;

import java.util.Scanner;

public class View {
    private static final Scanner scan = new Scanner(System.in);

    static void out(String message) {
        System.out.println(message);
    }

    static String in(String message) {
        out(message);
        return scan.nextLine();
    }
}
