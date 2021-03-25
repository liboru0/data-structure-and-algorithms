package com.liboru.algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归
     */
    private static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int key = arr[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && arr[j] > key) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    // src[j] = key;
                    i++;
                }
                while (i < j && arr[i] < key) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    // src[i] = key;
                    j--;
                }
            }
            arr[i] = key;
            quickSort(arr, begin, i - 1);
            quickSort(arr, i + 1, end);
        }
    }

    public static void main(String[] args) {

        int[] arr = {-9, 70, 23, 0, -567, 78};
        System.out.println(Arrays.toString(arr));

        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));


    }

}
