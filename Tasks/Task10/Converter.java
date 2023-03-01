public class Converter {
    public static void convert(String[] items){
        String a = null;
        for (int i = 1; i < items.length; i+=2){
            a = items[i];
            items[i] = items[i+1];
            items[i+1] = a;
        }
    }

    public static StringBuilder toSB(String[] items){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.length; i++){
            sb.append(items[i]);
        }
        return sb;
    }
}
