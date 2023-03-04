import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Sorted {
    public static void sort(Deque<Object> digits, Deque<String> operations){
        checking(digits, operations, "*", "/");
        checking(digits, operations, "^", "^");
    }

    public static void checking(Deque<Object> digits, Deque<String> operations, String check1, String check2){
        int count = 0;
        Queue<Object> nums = new LinkedList<>();
        Queue<String> operat = new LinkedList<>();

        for (int i = 0; i < operations.size(); i++){
            Object a = digits.poll();
            Object b = digits.poll();
            String op = operations.poll();
            if (op.equals(check1) || op.equals(check2)) {
                count++;
                nums.add(b);
                nums.add(a);
                operat.add(op);
            }
            else {
                digits.add(a);
                digits.addFirst(b);
                operations.add(op);
            }
        }
        Object first = digits.poll();
        digits.add(first);

        for (int i = 0; i < count; i++){
            digits.addFirst(nums.poll());
            digits.addFirst(nums.poll());
            operations.addFirst(operat.poll());
        }
    }

}
