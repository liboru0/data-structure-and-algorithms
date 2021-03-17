package com.liboru.algorithm.sort;

import java.util.Arrays;

public class SelectSort {

    /**
     * @apiNote 选择排序
     * @param arr 要排序的数组
     * @author lbr
     */
    private static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            // 假定本次循环的第一个位置是最小
            int min = arr[i]; // 最小值
            int minIndex = i; // 最小值下标

            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            // 当最小值发生变化，再进行交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }

    }

    /**
     * @apiNote 优化后的选择排序
     * @param arr 要排序的数组
     * @author lbr
     */
    private static void sortOptimizing(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            // 假定本次循环的第一个位置是最小
            int min = arr[i]; // 最小值
            int minIndex = i; // 最小值下标
            boolean flag = false; // 是否发生了最小值变更

            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                    flag = true;
                }
            }

            if(!flag){
                return;
            }
            flag = false;

            // 当最小值发生变化，再进行交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }

    }


    public static void main(String[] args) {
        int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));

        SelectSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
