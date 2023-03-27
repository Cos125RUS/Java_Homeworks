package org.example.ComplexCalc.View;

import java.util.Scanner;

public class ViewCalculator implements IViewCalculator {
    Scanner in;

    public ViewCalculator() {
        this.in = new Scanner(System.in);
    }

    @Override
    public int promptInt(String message) {
        int n = 0;
        while (n == 0) {
            show(message);
            try {
                n = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                show("Not a number!\n");
            }
        }
        return n;
    }

    @Override
    public String prompt(String message) {
        String operation = "";
        while (operation.length() != 1 && !(operation.equals("+") && operation.equals("*") &&
                operation.equals("-") && operation.equals("/") && operation.equals("="))) {
            show(message);
            operation = in.nextLine().trim();
        }
        return operation;
    }

    @Override
    public void show(String message) {
        System.out.print(message);
    }
}
