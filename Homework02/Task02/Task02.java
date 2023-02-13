package Task02;
//Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task02 {
    public static void main(String[] args) throws Exception {
        System.out.print("Enter size of array: ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] array = fillArray(size);
//        printArray(array);
        System.out.println(Arrays.toString(array));
        array = sortArray(array);
        System.out.println(Arrays.toString(array));

    }

    static int[] fillArray(int size){
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0 ; i < size; i++)
            arr[i] = rand.nextInt(100);
        return arr;
    }

    static void printArray(int[] arr){
        int size = arr.length;
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    static int[] sortArray(int[] arr) throws Exception{
        Logger logger = Logger.getLogger(Task02.class.getName());
        FileHandler fhLogger = new FileHandler("log.txt");
        logger.addHandler(fhLogger);
        SimpleFormatter txt = new SimpleFormatter();
        fhLogger.setFormatter(txt);

        int size = arr.length;
        int a;
        for (int i = 0; i < size - 1; i++){
            for (int j = 0; j< size-i - 1;j++){
                if (arr[j] > arr[j+1]){
                    a = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = a;
                }
            }
            logger.log(Level.INFO, Arrays.toString(arr));
        }
        return arr;
    }
}
