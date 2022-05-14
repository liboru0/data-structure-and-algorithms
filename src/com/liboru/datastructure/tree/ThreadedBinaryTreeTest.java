package com.liboru.datastructure.tree;

public class ThreadedBinaryTreeTest {

    public static void main(String[] args) {
        ThreadedBinaryTree<Integer> tree = new ThreadedBinaryTree<>();
        ThreadedBinaryTree.TreeNode<Integer> root = new ThreadedBinaryTree.TreeNode<>(1);
        ThreadedBinaryTree.TreeNode<Integer> node2 = new ThreadedBinaryTree.TreeNode<>(3);
        ThreadedBinaryTree.TreeNode<Integer> node3 = new ThreadedBinaryTree.TreeNode<>(6);
        ThreadedBinaryTree.TreeNode<Integer> node4 = new ThreadedBinaryTree.TreeNode<>(8);
        ThreadedBinaryTree.TreeNode<Integer> node5 = new ThreadedBinaryTree.TreeNode<>(10);
        ThreadedBinaryTree.TreeNode<Integer> node6 = new ThreadedBinaryTree.TreeNode<>(14);
        tree.setRoot(root);
        root.left = node2;
        root.right = node3;
        root.left.left = node4;
        root.left.right = node5;
        root.right.left = node6;
        /**
         *       1
         *   3        6
         * 8   10  14
         */
        tree.infixOrderList();



    }

}
