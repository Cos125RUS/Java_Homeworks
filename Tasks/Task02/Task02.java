import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task02 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getLogger(Task02.class.getName());
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        try {
            System.out.print("a = ");
            int a = scanner.nextInt();
            System.out.print("b = ");
            int b = scanner.nextInt();
            String result = res(a,b);
            System.out.println(result);
            logger.info(result);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warning("Error");
        }
    }

    static String res (int a, int b){
        StringBuilder sb = new StringBuilder();
        while (a != b){
            if (k1(a) <= b){
                a = k1(a);
                sb.append("k1 ");
            }
            else {
                a = k2(a);
                sb.append("k2 ");
            }
        }
        return sb.toString();
    }


    static int k1(int value) {
        return value * 2;
    }

    static int k2(int value) {
        return value + 1;
    }
}
