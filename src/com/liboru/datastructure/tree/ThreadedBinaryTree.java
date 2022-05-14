package com.liboru.datastructure.tree;

public class ThreadedBinaryTree<E> {

    private TreeNode<E> root;

    // 为了实现线索化，需要指向当前节点的前驱节点
    private TreeNode<E> pre = null;

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }

    /**
     * 中序线索化
     * @param node 当前需要线索化的节点
     */
    public void infixOrderThreadedNodes(TreeNode<E> node){
        if(node==null){
            return;
        }

        // 线索化左子树
        infixOrderThreadedNodes(node.left);
        // 线索化当前节点

        // 线索化右子树
        infixOrderThreadedNodes(node.right);
    }

    // 中序遍历
    public void infixOrderList() {
        if (this.root == null) {
            System.out.println("二叉树为空");
            return;
        }
        this.infixOrderList(this.root);
    }

    private void infixOrderList(TreeNode<E> node) {
        if (node.left != null) {
            this.infixOrderList(node.left);
        }
        System.out.println(node.item);
        if (node.right != null) {
            this.infixOrderList(node.right);
        }
    }

    public static class TreeNode<E> {
        E item;
        TreeNode<E> left;
        TreeNode<E> right;

        // 0-左子树;1-前驱节点
        int leftType;
        // 0-右子树;1-后继节点
        int rightType;

        public TreeNode(E item) {
            this.item = item;
        }

        public TreeNode(E item, TreeNode<E> left, TreeNode<E> right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

}
