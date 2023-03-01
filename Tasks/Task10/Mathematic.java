public class Mathematic {
    public static String postfix(String[] items){
        for (int i = 0; i < items.length - 1;){
            double res = result(items[i++], items[i++], items[i]);
            if (res - ((int)res) == 0)
                items[i] = Integer.toString((int)res);
            else
                items[i] = Double.toString(res);
        }

        return items[items.length - 1];
    }

    public static String infix(String[] items) {
        for (int i = 0; i < items.length - 1;){
            double res = result(items[i++], items[i+1], items[i]);
            if (res - ((int)res) == 0)
                items[i++] = Integer.toString((int)res);
            else
                items[i++] = Double.toString(res);
        }

        return items[items.length - 2];
    }

    public static double result(String n1, String n2, String op){
        int a = Integer.parseInt(n1);
        int b = Integer.parseInt(n2);
        double res = 0;
        try {
            if (op.equals("+"))
                res =  a+b;
            else if (op.equals("-"))
                res =  a-b;
            else if (op.equals("*"))
                res =  a*b;
            else if (op.equals("/"))
                res =  ((double)a)/b;
            else if (op.equals("^"))
                res = Math.pow(a,b);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }
}
