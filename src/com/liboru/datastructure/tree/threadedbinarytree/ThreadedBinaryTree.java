package com.liboru.datastructure.tree.threadedbinarytree;

public class ThreadedBinaryTree {

    private TreeNode root;

    private TreeNode pre = null;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void threadedNodes() {
        this.threadedNodes(root);
    }

    // 编写对二叉树进行中序线索化的方法
    private void threadedNodes(TreeNode node) {

        if (node == null) {
            return;
        }

        // 线索化左子树
        threadedNodes(node.left);

        // 线索化当前节点

        // 处理当前节点的前驱节点
        if (node.left == null) {
            node.left = pre;
            node.leftType = 1;
        }

        // 处理后继节点
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightType = 1;
        }

        // 每处理一个节点后，改变 pre 的值
        pre = node;

        // 线索化右子树
        threadedNodes(node.right);

    }

    // 遍历线索化二叉树
    public void threadList() {
        TreeNode node = root;

        while (node != null) {

            // 循环好到 leftType = 1 的节点
            while (node.leftType == 0) {
                node = node.left;
            }

            System.out.println(node.val);

            while (node.rightType == 1) {
                node = node.right;
                System.out.println(node.val);
            }

            node = node.right;

        }
    }

}



