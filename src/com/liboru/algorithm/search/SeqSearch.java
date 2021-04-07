package com.liboru.algorithm.search;

public class SeqSearch {

    public static int seqSearch(int[] arr, int value) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 9, 11, -1, 34, 23, 434};

        System.out.println(SeqSearch.seqSearch(arr,-1));
        System.out.println(SeqSearch.seqSearch(arr,23));
        System.out.println(SeqSearch.seqSearch(arr,100));

    }

}
