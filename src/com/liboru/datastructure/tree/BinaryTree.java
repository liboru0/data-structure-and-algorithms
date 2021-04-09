package com.liboru.datastructure.tree;

public class BinaryTree<E> {

    private TreeNode<E> root;

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrderList() {
        if (this.root == null) {
            System.out.println("二叉树为空");
        }
        this.preOrderList(this.root);
    }

    private void preOrderList(TreeNode<E> node){
        System.out.println(node.item);
        if(node.left!=null){
            this.preOrderList(node.left);
        }
        if(node.right!=null){
            this.preOrderList(node.right);
        }
    }

    // 中序遍历
    public void infixOrderList(){
        if (this.root == null) {
            System.out.println("二叉树为空");
        }
        this.infixOrderList(this.root);
    }

    private void infixOrderList(TreeNode<E> node){
        if(node.left!=null){
            this.infixOrderList(node.left);
        }
        System.out.println(node.item);
        if(node.right!=null){
            this.infixOrderList(node.right);
        }
    }

    // 后序遍历
    public void postOrderList(){
        if (this.root == null) {
            System.out.println("二叉树为空");
        }
        this.postOrderList(this.root);
    }

    private void postOrderList(TreeNode<E> node){
        if(node.left!=null){
            this.postOrderList(node.left);
        }
        if(node.right!=null){
            this.postOrderList(node.right);
        }
        System.out.println(node.item);
    }

    public static class TreeNode<E> {
        E item;
        TreeNode<E> left;
        TreeNode<E> right;

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
