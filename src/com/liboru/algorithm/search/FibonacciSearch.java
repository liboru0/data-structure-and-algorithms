package com.liboru.algorithm.search;

import java.util.Arrays;

public class FibonacciSearch {

    public static int search(int[] arr, int value) {

        int low = 0;
        int high = arr.length - 1;

        // 表示斐波那契分割数值的下标
        int k = 0;

        int mid = 0;
        int[] f = fib();

        // 获取到斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }

        // 因为 f[k] 的值可能大于 a 的长度，因此我们需要一个新的数组，并指向temp[]
        // 不足的部分会使用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        // 实际上需要使用 arr 最后的数值填充 temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (value > temp[mid]) {
                low = mid + 1;
                // 全部元素 = 前面的元素 + 后边的元素
                // f[k] = f[k-1] + f[k-2]
                // f[k-2] = f[k-3] + f[k-4]
                k -= 2;
            } else if (value < temp[mid]) {
                high = mid - 1;
                // 全部元素 = 前面的元素 + 后边的元素
                // f[k] = f[k-1] + f[k-2]
                // f[k-1] = f[k-2] + f[k-3]
                k--;
            } else {
                // 需要确定，返回的是哪个下标
                return mid <= high ? mid : high;
            }
        }

        return -1;
    }

    public static int maxSize = 20;

    public static int[] fib() {
        int[] f = new int[maxSize];

        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f;
    }

    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1234};

        System.out.println(FibonacciSearch.search(arr, 1234));

    }

}
