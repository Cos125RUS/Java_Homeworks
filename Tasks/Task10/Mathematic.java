import java.util.Map;
import java.util.Queue;

public class Mathematic {
    public static Object result(Object a, Object b, String op){
        boolean isDouble = cheсk(a , b);

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

    public static Object pow (Object a, Object b){
        if (cheсk(a , b))
            return ((Object) Math.pow(Converter.toDouble(a),Converter.toDouble(b)));
        else return ((Object) Math.pow(Converter.toInteger(a), Converter.toInteger(b)));
    }

    public static boolean cheсk(Object a, Object b){
        if (Converter.cheсkDouble(a) || Converter.cheсkDouble(b))
            return true;
        else return false;
    }
}
