package Task01;
//+Написать программу вычисления n-ого треугольного числа.
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("n = ");
        int n = scan.nextInt();
        double t = 0.5*n*(n+1);
        System.out.printf("Tn = %.0f", t);
    }
}
