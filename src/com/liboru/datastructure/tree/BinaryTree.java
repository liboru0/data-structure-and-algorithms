package com.liboru.datastructure.tree;

public class BinaryTree<E> {

    private TreeNode<E> root;

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrder() {
        if (this.root == null) {
            System.out.println("二叉树为空");
        }
        this.preOrder(this.root);
    }

    private void preOrder(TreeNode<E> node){
        System.out.println(node.item);
        if(node.left!=null){
            this.preOrder(node.left);
        }
        if(node.right!=null){
            this.preOrder(node.right);
        }
    }

    // 中序遍历
    public void infixOrder(){
        if (this.root == null) {
            System.out.println("二叉树为空");
        }
        this.infixOrder(this.root);
    }

    private void infixOrder(TreeNode<E> node){
        if(node.left!=null){
            this.infixOrder(node.left);
        }
        System.out.println(node.item);
        if(node.right!=null){
            this.infixOrder(node.right);
        }
    }

    // 后序遍历
    public void postOrder(){
        if (this.root == null) {
            System.out.println("二叉树为空");
        }
        this.postOrder(this.root);
    }

    private void postOrder(TreeNode<E> node){
        if(node.left!=null){
            this.postOrder(node.left);
        }
        if(node.right!=null){
            this.postOrder(node.right);
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
