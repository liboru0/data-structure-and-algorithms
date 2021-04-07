package com.liboru.algorithm.search;

import java.util.ArrayList;

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

    public static ArrayList<Integer> searchAll(int[] arr, int value) {
        return searchAll(arr, 0, arr.length - 1, value);
    }

    private static ArrayList<Integer> searchAll(int[] arr, int left, int right, int value) {

        if (left > right) {
            return new ArrayList<>(0);
        }

        int mid = (left + right) / 2;
        if (value > arr[mid]) {
            return searchAll(arr, mid + 1, right, value);
        } else if (value < arr[mid]) {
            return searchAll(arr, left, mid - 1, value);
        } else {
            ArrayList<Integer> arrayList = new ArrayList<>();

            int temp = mid - 1;
            while (temp > 0 && arr[temp] == value) {
                arrayList.add(temp--);
            }
            arrayList.add(mid);
            temp = mid + 1;
            while (temp < arr.length - 1 && arr[temp] == value) {
                arrayList.add(temp++);
            }

            return arrayList;
        }

    }

    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        System.out.println(BinarySearch.search(arr, 1000));
        System.out.println(BinarySearch.searchAll(arr, 1000));
        System.out.println(BinarySearch.search(arr, -1));
        System.out.println(BinarySearch.searchAll(arr, -1));

    }


}
