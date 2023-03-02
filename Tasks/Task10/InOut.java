import java.util.Scanner;

public class InOut {
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
