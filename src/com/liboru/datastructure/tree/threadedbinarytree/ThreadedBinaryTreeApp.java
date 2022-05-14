package com.liboru.datastructure.tree.threadedbinarytree;

public class ThreadedBinaryTreeApp {

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(13);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right= node5;
        node3.left = node6;

        // 线索化
        ThreadedBinaryTree tbt = new ThreadedBinaryTree();
        tbt.setRoot(node1);
        tbt.threadedNodes();

        // 验证
        System.out.println(node5.left.val);
        System.out.println(node5.leftType);
        System.out.println(node5.right.val);
        System.out.println(node5.rightType);

    }

}
