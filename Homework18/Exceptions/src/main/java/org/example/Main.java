package org.example;

public class Main {
    public static void main(String[] args) {
        Metods metods = new Metods();
        Integer[] arr1 = {1, 2, 3, 5, 11};
        Integer[] arr2 = {5, 6, 1, 8, 10};
//        try {
//            Integer[] res = arrDif(arr1, arr2);
////            Integer[] res = arrPriv(arr1, arr2);
//            System.out.println("+");
//
//        } catch (Exception e) {
//            System.out.println(e);
//
//        }
        Integer[] res = metods.arrDif(arr1, arr2);
    }

}

class Metods {
    public static Integer[] arrDif(Integer[] arr1, Integer[] arr2) throws RuntimeException, IndexOutOfBoundsException {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Разная длина массивов");
        }


        Integer[] res = new Integer[arr2.length];
        for (int i = 0; i <= arr2.length; i++) {
            if (i > arr2.length - 1){
                throw new IndexOutOfBoundsException("Выход за границы массива");
            }
            res[i] = arr1[i] - arr2[i];
            System.out.println(res[i]);
        }

        return res;
    }

    public static Integer[] arrPriv(Integer[] arr1, Integer[] arr2) {
        Ex(arr1);
        Ex(arr2);

        if (arr1.length != arr2.length) {
            throw new RuntimeException("Разная длина массивов");
        }


        Integer[] res = new Integer[arr2.length];
        for (int i = 0; i < arr2.length; i++) {
            res[i] = arr1[i] / arr2[i];
            System.out.println(res[i]);
        }
        return res;
    }

    private static void Ex(Integer[] arr) {
        for (Integer i : arr) {
            if (i.equals(0)) {
                throw new ArithmeticException("Деление на ноль");
            }

        }
    }
}