import java.util.*;

public class Converter {
    public static Map<Deque<Object>, Deque<String>> degree(String[] items) {
        Map<Deque<Object>, Deque<String>> res = new HashMap<>();
        Deque<Object> digits = new ArrayDeque<>();
        Deque<String> operations = new LinkedList<>();

        for (String i : items)
            if (Character.isDigit(i.toCharArray()[0]))
                digits.add((Object)i);
            else
                operations.add(i);

        res.put(digits, operations);
        return res;
    }

    public static void postfix(Map<Deque<Object>, Deque<String>> pier) {
        Deque<Object> digits = null;
        Deque<String> operations = null;
        for (Map.Entry<Deque<Object>, Deque<String>> entry : pier.entrySet()) {
            digits = entry.getKey();
            operations = entry.getValue();
        }

        Sorted.sort(digits,operations);
        InOut.printPost(digits, operations);

        while (operations.size() > 0) {
            Object a = digits.poll();
            Object b = digits.poll();
            String op = operations.poll();
            digits.addFirst(Mathematic.result(a, b, op));
        }
        Object res = digits.poll();
        if (cheсkInt(res))
            System.out.println("Result = " + toInteger(res));
        else System.out.println("Result = " + res);
    }

    public static Double toDouble(Object n){
        if (n instanceof String)
            return (Double.parseDouble(((String) n)));
        else if (n instanceof Integer)
            return ((double)((Integer) n));
        else return ((Double) n);
    }

    public static Integer toInteger(Object n){
        if (n instanceof String)
            return (Integer.parseInt(((String) n)));
        else if (n instanceof Double)
            return ((int)((double) n));
        else return ((Integer) n);
    }

    public static boolean cheсkInt(Object n){
        double numD = toDouble(n);
        int numI = (int) numD;
        if ((numD - numI) == 0)
            return true;
        else return false;
    }

    public static boolean cheсkDouble(Object n){
        if (n instanceof String)
            if (((String)n).contains("."))
                return true;
            else return false;
        else if (n instanceof Double)
            return true;
        else return false;
    }
}
