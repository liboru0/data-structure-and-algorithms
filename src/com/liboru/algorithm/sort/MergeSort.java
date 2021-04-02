package com.liboru.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左递归进行分解
            mergeSort(arr, left, mid, temp);
            // 向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     * @param arr   原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @apiNote merge
     * @author lbr
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left; // 指向左边序列的初始索引
        int j = mid + 1; // 指向右边序列的初始索引
        int t = 0; // 指向 temp 数组的当前索引

        // 如果两边都有元素时,则需要比较按规则填充到temp，直到有任意一边处理完毕
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        // 把有剩余数据的一边依次填充到temp
        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        while (j <= right) {
            temp[t++] = arr[j++];
        }

        // 将 temp 拷贝到 arr 中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }

    }


    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        System.out.println(Arrays.toString(arr));

        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
