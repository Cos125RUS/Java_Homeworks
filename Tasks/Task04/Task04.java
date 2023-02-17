import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task04 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getLogger(Task04.class.getName());
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        FileWriter file = new FileWriter("MoveTower.txt");

        System.out.print("n = ");
        int n = scanner.nextInt();
        hanoi(n,1,3,2);
        file.write(sb.toString());
        file.flush();
    }

    static void hanoi(int n, int departure, int target, int buffer) {
        if (n == 1){
            sb.append(departure).append(" -> ").append(target).append("\n");
            System.out.println(departure + " -> " + target);
        }
        else {
            hanoi(n-1, departure, buffer, target);
            hanoi(1, departure, target, buffer);
            hanoi(n-1, buffer, target, departure);
        }
    }
}
