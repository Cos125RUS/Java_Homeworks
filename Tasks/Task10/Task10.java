import java.util.*;

public class Task10 {
    public static void main(String[] args) {
        String[] items = InOut.enter();
        Map<Deque<Object>, Queue<String>> pier = Converter.degree(items);
        Converter.postfix(pier);
    }
}
