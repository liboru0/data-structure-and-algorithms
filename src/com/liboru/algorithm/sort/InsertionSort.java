package com.liboru.algorithm.sort;

import java.util.Arrays;

public class InsertionSort {

    /**
     * @param arr 要排序的数组
     * @apiNote 插入排序
     * @author lbr
     */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 待插入的数据
            int insertVal = arr[i];
            int j = 0;

            for (j = i - 1; j >= 0 && insertVal < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = insertVal;
        }
    }

    public static void main(String[] args) {

        int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));

        InsertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

}
