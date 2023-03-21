package org.example.View;

import java.time.LocalDate;
import java.util.Scanner;

public class In implements ImplIn{
    Scanner scanner = new Scanner(System.in);

    @Override
    public String enterInt(){
        return scanner.nextLine();
    }

    @Override
    public String enterString(){
        return scanner.nextLine();
    }
}
