package Tasks;

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task01 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getLogger(Task01.class.getName());
        FileHandler fh = new FileHandler("src/main/java/Tasks/log.txt");
        logger.addHandler(fh);
        SimpleFormatter txt = new SimpleFormatter();
        fh.setFormatter(txt);

        try {
            System.out.print("a = ");
            int a = scanner.nextInt();
            System.out.print("b = ");
            int b = scanner.nextInt();
            int res = math(a,b);
            System.out.println("res = " + res);
            logger.info(a+"^"+b+" = "+res);
        }
        catch (Exception e){
            logger.warning("Fail");
        }
    }

    static int math(int a, int b){
        int res = 1;
        while (b > 0) {
            res *= a;
            b--;
        }
        return res;
    }


}
