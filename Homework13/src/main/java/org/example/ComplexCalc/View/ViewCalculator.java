package org.example.ComplexCalc.View;

import java.util.Scanner;

public class ViewCalculator implements IViewCalculator{
    Scanner in;

    public ViewCalculator() {
        this.in = new Scanner(System.in);
    }

    public int promptInt(String message) {
        show(message);
        return Integer.parseInt(in.nextLine());
    }

    public String prompt(String message) {
        show(message);
        return in.nextLine();
    }

    public void show(String message) {
        System.out.print(message);
    }
}
