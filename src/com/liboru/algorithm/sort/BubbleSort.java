package com.liboru.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * @param arr 要排序的数组
     * @apiNote 冒泡排序
     * @author lbr
     */
    public static void sort(int[] arr) {
        int temp = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }

    /**
     * @param arr 要排序的数组
     * @apiNote 优化后的冒泡排序
     * @author lbr
     */
    public static void sortOptimizing(int[] arr) {
        int temp = 0;

        boolean swapFlag = false; // 是否发生了交换


        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapFlag = true;
                }
            }
            // 如果没有发生交换，则已经有序
            if (!swapFlag) {
                return;
            }
            swapFlag = false; // 重置
        }

    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};

        BubbleSort.print(arr);
        BubbleSort.sort(arr);
        BubbleSort.print(arr);

    }

}