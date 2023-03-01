import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        String res;
        boolean userChoce = choice();
        String[] items = enter();
        convert(items);
        printLine(items);

        if (userChoce)
            res = postfix(items);
        else
            res = infix(items);

        System.out.println(" = " + res);
    }

    public static boolean choice(){
        int enter = -1;
        while (enter != 1 && enter != 2){
            System.out.println("Infix to Postfix - 1\nPostfix to Infix - 2");
            System.out.print("Your choice: ");
            enter = (new Scanner(System.in)).nextInt();
        }
        return enter == 1;
    }

    public static String[] enter(){
        System.out.print("Enter the line: ");
        return (new Scanner(System.in)).nextLine().split(" ");
    }

    public static String postfix(String[] items){
        for (int i = 0; i < items.length - 1;){
            double res = result(items[i++], items[i++], items[i]);
            if (res - ((int)res) == 0)
                items[i] = Integer.toString((int)res);
            else
                items[i] = Double.toString(res);
        }

        return items[items.length - 1];
    }

    public static String infix(String[] items) {
        for (int i = 0; i < items.length - 1;){
            double res = result(items[i++], items[i+1], items[i]);
            if (res - ((int)res) == 0)
                items[i++] = Integer.toString((int)res);
            else
                items[i++] = Double.toString(res);
        }

        return items[items.length - 2];
    }

    public static double result(String n1, String n2, String op){
        int a = Integer.parseInt(n1);
        int b = Integer.parseInt(n2);
        double res = 0;
        try {
            if (op.equals("+"))
                res =  a+b;
            else if (op.equals("-"))
                res =  a-b;
            else if (op.equals("*"))
                res =  a*b;
            else if (op.equals("/"))
                res =  ((double)a)/b;
            else if (op.equals("^"))
                res = Math.pow(a,b);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    public static void convert(String[] items){
        String a = null;
        for (int i = 1; i < items.length; i+=2){
            a = items[i];
            items[i] = items[i+1];
            items[i+1] = a;
        }
    }

    public static void printLine(String[] line){
        for (String s: line)
            System.out.print(s + " ");
    }
}
