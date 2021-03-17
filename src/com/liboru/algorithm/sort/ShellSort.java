package com.liboru.algorithm.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println(Arrays.toString(arr));

        ShellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {

        int n = arr.length;
        int gap = n / 2;
        while (gap >= 1) {
            for (int i = gap; i < arr.length; i++) {
                int insertVal = arr[i];
                int j = 0;
                for (j = i - gap; j >= 0 && insertVal < arr[j]; j = j - gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = insertVal;
            }
            gap = gap / 2;
        }


    }

}
