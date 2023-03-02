import java.util.Scanner;

public class InOut {
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
        return (new Scanner(System.in)).nextLine().replace("(", "( ")
                .replace(")", " )").split(" ");
    }

    public static void printLine(String[] line){
        for (String s: line)
            System.out.print(s + " ");
    }
}
