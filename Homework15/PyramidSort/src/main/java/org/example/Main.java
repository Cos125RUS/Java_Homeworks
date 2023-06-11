package org.example;

public class Main {
    public static void main(String[] args) {
        int size = 10;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        sort(arr);
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void sort(int[] arr) {
        int size = arr.length;

        for(int i = size/2-1; i >= 0; i--)
            heap(arr,size,i);

        for (int i = size-1; i >= 0; i--){
            int change = arr[0];
            arr[0] = arr[i];
            arr[i] = change;
            heap(arr,i,0);
        }
    }

    static void heap(int[] arr, int size, int index) {
        int max = index;
        int first = 2 * index + 1;
        int second = 2 * index + 2;

        if (first < size && arr[first] > arr[max])
            max = first;

        if (second < size && arr[second] > arr[max])
            max = second;

        if (max != index) {
            int change = arr[index];
            arr[index] = arr[max];
            arr[max] = change;
            heap(arr, size, max);
        }
    }
}