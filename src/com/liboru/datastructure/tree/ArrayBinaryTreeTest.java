package com.liboru.datastructure.tree;

public class ArrayBinaryTreeTest {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);
        System.out.println("前序");
        tree.preOrderList();    // 1 2 4 5 3 6 7
        System.out.println("中序");
        tree.inFixOrderList();  // 4 2 5 1 6 3 7
        System.out.println("后序");
        tree.postOrderList();   // 4 5 2 6 7 3 1
    }


}
