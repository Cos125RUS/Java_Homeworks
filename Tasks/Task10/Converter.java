import java.util.LinkedList;

public class Converter {
    public static void convert(String[] items) {
        String a = null;
        for (int i = 1; i < items.length; i += 2) {
            a = items[i];
            items[i] = items[i + 1];
            items[i + 1] = a;
        }
    }

    public static void convertToPostfix(String[] items) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals("(")) {
                int len = 0;
                int j = i + 1;
                while (!items[j++].equals(")"))
                    len++;
                String[] newStr = new String[len];
                System.arraycopy(items, i + 1, newStr, 0, len);
                convertToPostfix(newStr);
                System.arraycopy(newStr, 0, items, i + 1, len);
                i += (len + 1);
            }
            else{

            }
        }
    }

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
}
