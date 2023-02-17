
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task01 {
    public static void main(String[] args) throws Exception{
        Logger logger = Logger.getLogger(Task01.class.getName());
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter txt = new SimpleFormatter();
        fh.setFormatter(txt);



        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            int a = arg(br);
            System.out.println(a);
            int b = arg(br);
            System.out.println(b);
            int res = math(a,b);
            FileWriter fr = new FileWriter("output.txt", false);
            fr.write("res = " + res);
            fr.flush();
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

    static int arg(BufferedReader br) throws Exception{
        String st = br.readLine();
        String[] arr = st.split(" ");
        return Integer.parseInt(arr[1]);
    }

}
