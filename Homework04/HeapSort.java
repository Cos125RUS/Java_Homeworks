import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 8, 4, 6, 2, 9, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
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
