import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task05 {
    public static void main(String[] args) throws Exception{
        Logger logger = Logger.getLogger(Task05.class.getName());
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);

        String ex = expression();
//        System.out.println(ex);
        logger.info(ex);
        String result = solution(ex);
//        System.out.println(result);
        logger.info(result);
    }

    static String expression(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        int sum = rand.nextInt(100);
        sb.append(num()).append(" + ").append(num()).append(" = ").append(sum);
        return sb.toString();
    }

    static String num(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        int question = rand.nextInt(2);
        int digit = rand.nextInt(10);

        if (question == 0)
            sb.append("?").append(digit);
        else
            sb.append(digit).append("?");

        return sb.toString();
    }

    static String solution(String expression){
        StringBuilder sb = new StringBuilder();
        String[] composite = expression.split(" = ");
        String[] nums = composite[0].replace('+',' ').split("   ");
        int indexNum1 = nums[0].indexOf("?");
        int indexNum2 = nums[1].indexOf("?");
        int dijit1 = Integer.parseInt(nums[0].replace("?",""));
        int dijit2 = Integer.parseInt(nums[1].replace("?",""));
        int result = Integer.parseInt(composite[1]);

        if ((dijit1 + dijit2) > result)
            return "Решений нет";
        else {
            int num1, num2;
            for(int i = 0; i < 10; i++){
                num1 = newNum(dijit1, indexNum1, i);
                for (int j = 0; j < 10; j++){
                    num2 = newNum(dijit2, indexNum2, j);
                    if ((num1 + num2) == result){
                        sb.append(num1).append(" + ").append(num2).append(" = ").append(result);
                        return sb.toString();
                    }
                }
            }
        }

        return "Решений нет";
    }

    static int newNum(int num, int index, int i){
        if (index == 1)
            return num*10 + i;
        else
            if (i > 0)
                return i*10 + num;
            else return num;
    }

}
