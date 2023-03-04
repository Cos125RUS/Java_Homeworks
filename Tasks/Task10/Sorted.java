import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Sorted {
    public static void sort(Deque<Object> digits, Deque<String> operations){
        Deque<Object> sortedDigits = new ArrayDeque<>();
        Deque<String> sortedOperations = new ArrayDeque<>();
        checking(digits, operations, sortedDigits, sortedOperations, "^", "^");
        checking(digits, operations, sortedDigits, sortedOperations, "*", "/");
        checking(digits, operations, sortedDigits, sortedOperations, "+", "-");
        change(digits, operations, sortedDigits, sortedOperations);
    }

    public static void checking(Deque<Object> digits, Deque<String> operations,
                                Deque<Object> sortedDigits, Deque<String> sortedOperations,
                                String check1, String check2){

        for (int i = 0; i < operations.size(); i++){
            Object a = digits.poll();
            String op = operations.poll();
            if (op.equals(check1) || op.equals(check2)) {
                if (sortedDigits.size() == 0) {
                    sortedDigits.add(a);
                    a = digits.poll();
                }
                sortedDigits.add(a);
                sortedOperations.add(op);
            }
            else {
                digits.add(a);
                operations.add(op);
            }
        }
        if (sortedDigits.size() == 0) {
            Object first = digits.poll();
            digits.add(first);
        }
    }

    public static void change(Deque<Object> digits, Deque<String> operations,
                              Deque<Object> sortedDigits, Deque<String> sortedOperations){
        while (sortedOperations.size() > 0){
            digits.add(sortedDigits.poll());
            operations.add(sortedOperations.poll());
        }
        digits.add(sortedDigits.poll());
    }
}
