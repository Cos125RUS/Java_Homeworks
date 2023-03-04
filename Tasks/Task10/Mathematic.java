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
        if (Converter.chekDouble(a) || Converter.chekDouble(b))
            isDouble = true;
        else isDouble = false;

        if (op.equals("+")) {
            if (isDouble)
                return ((Object)(Converter.toDouble(a) + Converter.toDouble(b)));
            else return ((Object)((Converter.toInteger(a) + Converter.toInteger(b))));
        }
        else if (op.equals("-")) {
            if (isDouble)
                return ((Object)(Converter.toDouble(a) - Converter.toDouble(b)));
            else return ((Object)((Converter.toInteger(a) - Converter.toInteger(b))));
        }
        else if (op.equals("*")){
            if (isDouble)
                return ((Object)(Converter.toDouble(a) * Converter.toDouble(b)));
            else return ((Object)((Converter.toInteger(a) * Converter.toInteger(b))));
        }
        else if (op.equals("/")){
            if ((!isDouble) && ((Converter.toInteger(a) % Converter.toInteger(b)) == 0))
                return ((Object)(Converter.toInteger(a) / Converter.toInteger(b)));
            else return ((Object)(Converter.toDouble(a) / Converter.toDouble(b)));
        }
        else if (op.equals("^")){
            if (isDouble)
                return ((Object) Math.pow(Converter.toDouble(a),Converter.toDouble(b)));
            else return ((Object) Math.pow(Converter.toInteger(a), Converter.toInteger(b)));
        }
        else return ((Object)0);
    }



    public static double degree(){

        return 0;
    }
}
