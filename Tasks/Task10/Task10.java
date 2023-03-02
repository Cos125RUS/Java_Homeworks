import java.util.*;

public class Task10 {
    public static void main(String[] args) {
        String[] items = InOut.enter();
        Map<Queue<Double>, Queue<String>> pier = Converter.degree(items);
        Converter.postfix(pier);
    }
}
