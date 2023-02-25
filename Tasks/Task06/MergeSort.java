import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 2, 4, 9, 7, 3, 8};
        sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int size) {
        int middle = size / 2;
        if (middle > 0) {
            int[] left = new int[middle];
            for (int i = 0; i < middle; i++)
                left[i] = arr[i];
            int[] right = new int[size - middle];
            for (int i = middle; i < size; i++)
                right[i - middle] = arr[i];
            sort(left, middle);
            sort(right, size - middle);
            merge(arr, left, right, middle, size - middle);
        }
    }

    static void merge(int[] arr, int[] left, int[] right, int middle, int size) {
        int i = 0, j = 0, k = 0;
        for (; i < middle && j < size; )
            arr[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        for (; i < middle; k++, i++) arr[k] = left[i];
        for (; j < size; k++, j++) arr[k] = right[j];
    }
}
