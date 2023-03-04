import java.util.*;

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

    public static Map<Deque<Object>, Queue<String>> degree(String[] items) {
        Map<Deque<Object>, Queue<String>> res = new HashMap<>();
        Deque<Object> digits = new ArrayDeque<>();
        Queue<String> operations = new LinkedList<>();

        for (String i : items)
            if (Character.isDigit(i.toCharArray()[0]))
                digits.add((Object)i);
            else
                operations.add(i);

        res.put(digits, operations);
        return res;
    }

    public static void postfix(Map<Deque<Object>, Queue<String>> pier) {
        Deque<Object> digits = null;
        Queue<String> operations = null;
        for (Map.Entry<Deque<Object>, Queue<String>> entry : pier.entrySet()) {
            digits = entry.getKey();
            operations = entry.getValue();
        }
        while (operations.size() > 0) {
            Object a = digits.poll();
            Object b = digits.poll();
            String op = operations.poll();
            digits.addFirst(Mathematic.result(a, b, op));
            System.out.println(a + " " + b + " " + op);
        }
        Object res = digits.poll();
        if (chekInt(res))
            System.out.println(toInteger(res));
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

    public static boolean chekInt(Object n){
        double numD = toDouble(n);
        int numI = (int) numD;
        if ((numD - numI) == 0)
            return true;
        else return false;
    }

    public static boolean chekDouble(Object n){
        if (n instanceof String)
            if (((String)n).contains("."))
                return true;
            else return false;
        else if (n instanceof Double)
            return true;
        else return false;
    }
}
