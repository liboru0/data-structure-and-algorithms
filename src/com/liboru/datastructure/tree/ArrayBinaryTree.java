package com.liboru.datastructure.tree;

public class ArrayBinaryTree {

    private int arr[];

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrderList() {
        if (arr == null || arr.length == 0) {
            System.out.println("树为空");
        }
        this.preOrderList(0);
    }

    private void preOrderList(int index) {
        System.out.println(arr[index]);
        if ((2 * index + 1) < arr.length) {
            this.preOrderList(2*index+1);
        }
        if ((2 * index + 2) < arr.length) {
            this.preOrderList(2*index+2);
        }
    }

    public void inFixOrderList() {
        if (arr == null || arr.length == 0) {
            System.out.println("树为空");
        }
        this.inFixOrderList(0);
    }

    private void inFixOrderList(int index) {
        if ((2 * index + 1) < arr.length) {
            this.inFixOrderList(2*index+1);
        }
        System.out.println(arr[index]);
        if ((2 * index + 2) < arr.length) {
            this.inFixOrderList(2*index+2);
        }
    }

    public void postOrderList() {
        if (arr == null || arr.length == 0) {
            System.out.println("树为空");
        }
        this.postOrderList(0);
    }

    private void postOrderList(int index) {
        if ((2 * index + 1) < arr.length) {
            this.postOrderList(2*index+1);
        }
        if ((2 * index + 2) < arr.length) {
            this.postOrderList(2*index+2);
        }
        System.out.println(arr[index]);
    }

}
