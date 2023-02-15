package Task04;
// Реализуйте простой калькулятор, с консольным интерфейсом.
// К калькулятору добавить логирование.


import Task02.Task02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task04 {
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger(Task02.class.getName());
        FileHandler fhLogger = new FileHandler("Task04\\log.txt");
        logger.addHandler(fhLogger);
        SimpleFormatter txt = new SimpleFormatter();
        fhLogger.setFormatter(txt);

        String line = enter();
        StringBuilder log = new StringBuilder();
//        Map<String, Integer> oper = operation(line);
        double res = operation(line, logger);
        int check = (int)res;
        if (res-check == 0){
            System.out.println("Answer: " + check);
            log.append(line).append(" = ").append(check);
        }
        else{
            System.out.println("Answer: " + res);
            log.append(line).append(" = ").append(res);
        }
        logger.info(log.toString());
    }

    public static String enter() {
        System.out.print("Enter: ");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        return line;
    }

    static double operation(String line, Logger logger) {
        String[] operations = {"+", "-", "*", "/"};
        int op = -1;
        try {
            for (int i = 0; i < operations.length; i++)
                if (line.contains(operations[i]))
                    op = i;
            int position = line.indexOf(operations[op]);
            double a = left(line, position, logger);
            double b = right(line, position, logger);
            double answer = calc(a,b,op, logger);
            return answer;

        }
        catch (Exception e){
            e.printStackTrace();
            logger.warning("Input Error");
            return 0.0;
        }

//        if (op > -1)


//        Map<String, Integer> res = new HashMap<>();
//        Integer index = position;
//        res.put(operations[op], index);
    }

    static double left(String line, int end, Logger logger) {
        char[] l = line.toCharArray();
        char[] left = new char[end];
        for (int i = 0; i < end; i++)
            left[i] = l[i];
        String strLeft = new String(left);
        try {
            double a = Double.parseDouble(strLeft);
            return a;
        }
        catch (Exception e){
            e.printStackTrace();
            logger.warning("Incorrect value a");
            return 0.0;
        }
    }

    static double right(String line, int start, Logger logger) {
        char[] r = line.toCharArray();
        int end = line.length() - start - 1;
        char[] right = new char[end];
        for (int i = 0; i < end; i++)
            right[i] = r[i + start + 1];
        String strRight = new String(right);
        try {
            double b = Double.parseDouble(strRight);
            return b;
        }
        catch (Exception e){
            e.printStackTrace();
            logger.warning("Incorrect value b");
            return 0.0;
        }
    }

    static double calc(double a, double b, int operation, Logger logger) throws Exception{
        switch (operation){
            case 0:
                return a+b;
            case 1:
                return a-b;
            case 2:
                return a*b;
            case 3:
                return a/b;
            default:
                System.out.println("Error");
                logger.warning("Operation not found");
                return 0.0;
        }
    }
}
