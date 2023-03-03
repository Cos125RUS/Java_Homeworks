import java.util.Map;
import java.util.Queue;

public class Mathematic {
//    public static String postfix(String[] items){
//        for (int i = 0; i < items.length - 1;){
//            double res = result(items[i++], items[i++], items[i]);
//            if (res - ((int)res) == 0)
//                items[i] = Integer.toString((int)res);
//            else
//                items[i] = Double.toString(res);
//        }
//
//        return items[items.length - 1];
//    }

//    public static String infix(String[] items) {
//        for (int i = 0; i < items.length - 1;){
//            double res = result(items[i++], items[i+1], items[i]);
//            if (res - ((int)res) == 0)
//                items[i++] = Integer.toString((int)res);
//            else
//                items[i++] = Double.toString(res);
//        }
//
//        return items[items.length - 2];
//    }

    public static Object result(Object a, Object b, String op){
        boolean isDouble;
        if (((String)a).contains(".") || ((String)b).contains("."))
            isDouble = true;
        else isDouble = false;

        if (op.equals("+")) {
            if (isDouble)
                return ((Object)(Double.parseDouble(((String) a)) + (Double.parseDouble(((String) b)))));
            else return ((Object)(Integer.parseInt((String) a) + (Integer.parseInt((String) b))));
        }
        else if (op.equals("-")) {
            if (isDouble)
                return ((Object)(Double.parseDouble(((String) a)) - (Double.parseDouble(((String) b)))));
            else return ((Object)(Integer.parseInt((String) a) - (Integer.parseInt((String) b))));
        }
        else if (op.equals("*")){
            if (isDouble)
                return ((Object)(Double.parseDouble(((String) a)) * (Double.parseDouble(((String) b)))));
            else return ((Object)(Integer.parseInt((String) a) * (Integer.parseInt((String) b))));
        }
        else if (op.equals("/")){
            if ((!isDouble) && ((Integer.parseInt((String) a) % (Integer.parseInt((String) b))) == 0))
                return ((Object)(Integer.parseInt((String) a) / (Integer.parseInt((String) b))));
            else return ((Object)(Double.parseDouble(((String) a)) / (Double.parseDouble(((String) b)))));
        }
        else if (op.equals("^")){
            if (isDouble)
                return ((Object) Math.pow((Double.parseDouble((String) a)),(Double.parseDouble((String) b))));
            else return ((Object) Math.pow((Integer.parseInt((String) a)), (Integer.parseInt((String) b))));
        }
        else return ((Object)0);
    }

    public static double degree(){

        return 0;
    }
}
