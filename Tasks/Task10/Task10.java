import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        String res;
        boolean userChoce = InOut.choice();
        String[] items = InOut.enter();
//        LinkedList<String> list = Converter.toList(items);
        Converter.convert(items);
        InOut.printLine(items);

        if (userChoce)
            res = Mathematic.postfix(items);
        else
            res = Mathematic.infix(items);

        System.out.println(" = " + res);
    }
}
