import java.util.Deque;
import java.util.Scanner;

public class InOut {
    public static String[] enter(){
        System.out.print("Enter the line: ");
        return (new Scanner(System.in)).nextLine().replace("(", "( ")
                .replace(")", " )").split(" ");
    }

    public static void printPost(Deque<Object> digits, Deque<String> operations){
        Object start = digits.poll();
        System.out.print(start);
        digits.add(start);
        for (String op: operations){
            Object b = digits.poll();
            System.out.print(" " + b + " " + op);
            digits.add(b);
        }
        System.out.println();
    }
}
