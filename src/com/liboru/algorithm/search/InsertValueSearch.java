package com.liboru.algorithm.search;

public class InsertValueSearch {

    public static int search(int[] arr, int value) {
        return search(arr, 0, arr.length - 1, value);
    }

    private static int search(int[] arr, int left, int right, int value) {

        // 后边两个或条件时防止mid非法
        if (left > right || value < arr[0] || value > arr[right]) {
            return -1;
        }

        // 自适应mid 与二分查找只有这一处逻辑不同
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        if (value > arr[mid]) {
            return search(arr, mid + 1, right, value);
        } else if (value < arr[mid]) {
            return search(arr, left, mid - 1, value);
        } else {
            return mid;
        }

    }

    public static void main(String[] args) {

        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        System.out.println(InsertValueSearch.search(arr, 1));
        System.out.println(InsertValueSearch.search(arr, 50));
        System.out.println(InsertValueSearch.search(arr, 100));
        System.out.println(InsertValueSearch.search(arr, 22));

    }

}
