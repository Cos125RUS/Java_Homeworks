package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) { // O(n)*O(n) + O(1)*6 = O(n^2)
        Random random = new Random(); // O(1)
        int size = random.nextInt(1, 1000); // O(1)
        int[] arr = new int[size]; // O(1)
        int[] divs = new int[size]; // O(1)
        for (int i = 0; i < size; i++) { // O(n)
            arr[i] = random.nextInt(1, 100000); // O(1)
            divs[i] = findDivided(arr[i]); // O(n)
            System.out.println(arr[i] + ":\t" + divs[i]); // O(1)
        }
    }

    public static int findDivided(int num){ // O(n/2 - 2) + O(1)*4 = O(n)
        int counter = 2; // O(1)
        for (int i = 2; i <= num/2; i++)  // O(n/2 - 2)
            if(num%i == 0)  // O(1)
                counter++; // O(1)

        return counter; // O(1)
    }
}