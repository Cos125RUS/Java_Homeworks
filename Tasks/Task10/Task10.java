import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        String res;
        boolean userChoce = InOut.choice();
        String[] items = InOut.enter();
        Converter.convert(items);
        InOut.printLine(items);

        if (userChoce)
            res = Mathematic.postfix(items);
        else
            res = Mathematic.infix(items);

        System.out.println(" = " + res);
    }
}
