package com.liboru.algorithm.sort;

import java.util.Arrays;

public class RadixSort {

    public static void sort(int[] arr) {

        // 得到数组中最大位数
        int maxDigit = (arr[0] + "").length();
        for (int i = 1; i < arr.length; i++) {
            int digitTemp = (arr[i] + "").length();
            if (maxDigit < digitTemp) {
                maxDigit = digitTemp;
            }
        }

        int bucketNum = 10;

        // 定义一个二维数组，表示 10 个桶，每个桶就是一个一维数组
        int[][] bucket = new int[bucketNum][arr.length];

        // 记录每个桶中实际存放了多少个数据
        int[] bucketElementCounts = new int[bucketNum];

        for (int i = 0, n = 1; i < maxDigit; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                // 取出该位的数
                int digitOfElement = arr[j] / n % 10;
                // 放入桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            // 从桶中依次取出元素，重新放入arr中
            int index = 0;
            for (int k = 0; k < bucketNum; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                // 重置桶中的数据计数
                bucketElementCounts[k] = 0;
            }

        }


    }

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        System.out.println(Arrays.toString(arr));

        RadixSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
