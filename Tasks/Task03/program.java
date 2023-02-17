//+Написать программу вычисления n-ого треугольного числа.
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("n = ");
        int n = scan.nextInt();
        System.out.printf("Tn = %.0f", triangleNum(n));
    }

    public static double triangleNum(int n){
        return 0.5*n*(n+1);
    }
}
