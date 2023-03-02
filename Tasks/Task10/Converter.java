import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;

public class Converter {
    public static void convert(String[] items) {
        String a = null;
        for (int i = 1; i < items.length; i += 2) {
            a = items[i];
            items[i] = items[i + 1];
            items[i + 1] = a;
        }
    }

//    public static void convertToPostfix(String[] items) {
//        for (int i = 0; i < items.length; i++) {
//            if (items[i].equals("(")) {
//                int len = 0;
//                int j = i + 1;
//                while (!items[j++].equals(")"))
//                    len++;
//                String[] newStr = new String[len];
//                System.arraycopy(items, i + 1, newStr, 0, len);
//                convertToPostfix(newStr);
//                System.arraycopy(newStr, 0, items, i + 1, len);
//                i += (len + 1);
//            }
//            else{
//
//            }
//        }
//    }

    public static StringBuilder toSB(String[] items) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            sb.append(items[i]);
        }
        return sb;
    }

    public static LinkedList<String> toList(String[] items) {
        LinkedList<String> list = new LinkedList<>();
        for (String i : items)
            list.add(i);
        return list;
    }

    public static Map<Queue<Double>, Queue<String>> degree(String[] items) {
        Map<Queue<Double>, Queue<String>> res = new HashMap<>();
        Queue<Double> digits = new LinkedList<>();
        Queue<String> operations = new LinkedList<>();

        for (String i : items)
            if (Character.isDigit(i.toCharArray()[0]))
                digits.add(Double.parseDouble(i));
            else
                operations.add(i);

        res.put(digits, operations);
        return res;
    }

    public static void postfix(Map<Queue<Double>, Queue<String>> pier) {
        Queue<Double> digits = null;
        Queue<String> operations = null;
        for (Map.Entry<Queue<Double>, Queue<String>> entry : pier.entrySet()) {
            digits = entry.getKey();
            operations = entry.getValue();
        }
        while (operations.size() > 0) {
            double a = digits.poll();
            double b = digits.poll();
            String op = operations.poll();
            digits.add(Mathematic.result(a, b, op));
            System.out.println((((a - (int)a) == 0.0) ? (int)a : a) + " " +
                    (((b - (int)b) == 0.0) ? (int)b : b) + " " + op);
        }
        System.out.println(digits.poll());
    }
}
