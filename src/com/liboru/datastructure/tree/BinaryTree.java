package com.liboru.datastructure.tree;

public class BinaryTree<E> {

    private TreeNode<E> root;

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }

    // 前序遍历
    public void preList() {
        if (this.root == null) {
            System.out.println("二叉树为空");
        }
        this.preList(this.root);
    }

    private void preList(TreeNode<E> node){
        System.out.println(node.item);
        if(node.left!=null){
            this.preList(node.left);
        }
        if(node.right!=null){
            this.preList(node.right);
        }
    }

    // 中序遍历
    public void infixList(){
        if (this.root == null) {
            System.out.println("二叉树为空");
        }
        this.infixList(this.root);
    }

    private void infixList(TreeNode<E> node){
        if(node.left!=null){
            this.infixList(node.left);
        }
        System.out.println(node.item);
        if(node.right!=null){
            this.infixList(node.right);
        }
    }

    // 后序遍历
    public void postList(){
        if (this.root == null) {
            System.out.println("二叉树为空");
        }
        this.postList(this.root);
    }

    private void postList(TreeNode<E> node){
        if(node.left!=null){
            this.postList(node.left);
        }
        if(node.right!=null){
            this.postList(node.right);
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
