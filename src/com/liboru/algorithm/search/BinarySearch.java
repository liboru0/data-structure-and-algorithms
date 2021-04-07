package com.liboru.algorithm.search;

public class BinarySearch {

    public static int search(int[] arr, int value) {
        return search(arr, 0, arr.length - 1, value);
    }

    private static int search(int[] arr, int left, int right, int value) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (value > arr[mid]) {
            return search(arr, mid + 1, right, value);
        } else if (value < arr[mid]) {
            return search(arr, left, mid - 1, value);
        } else {
            return mid;
        }

    }

    public static void main(String[] args) {

        int[] arr = {-100, -25, -13, 0, 1, 23, 45, 57, 88, 96};

        System.out.println(BinarySearch.search(arr, -100));
        System.out.println(BinarySearch.search(arr, 23));
        System.out.println(BinarySearch.search(arr, 100));
        System.out.println(BinarySearch.search(arr, 96));

    }


}
