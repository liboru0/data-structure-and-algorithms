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

    private void preOrderList(TreeNode<E> node) {
        System.out.println(node.item);
        if (node.left != null) {
            this.preOrderList(node.left);
        }
        if (node.right != null) {
            this.preOrderList(node.right);
        }
    }

    // 中序遍历
    public void infixOrderList() {
        if (this.root == null) {
            System.out.println("二叉树为空");
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

    // 后序遍历
    public void postOrderList() {
        if (this.root == null) {
            System.out.println("二叉树为空");
        }
        this.postOrderList(this.root);
    }

    private void postOrderList(TreeNode<E> node) {
        if (node.left != null) {
            this.postOrderList(node.left);
        }
        if (node.right != null) {
            this.postOrderList(node.right);
        }
        System.out.println(node.item);
    }

    // 前序查找
    public E preOrderSearch(E e) {
        if (this.root == null) {
            return null;
        }
        return this.preOrderSearch(e, this.root);
    }

    private E preOrderSearch(E e, TreeNode<E> node) {
        System.out.println("前序查找比较");
        if (node.item.equals(e)) {
            return e;
        }
        if (node.left != null) {
            E resultLeft = this.preOrderSearch(e, node.left);
            if (resultLeft != null) {
                return resultLeft;
            }
        }
        if (node.right != null) {
            return this.preOrderSearch(e, node.right);
        }
        return null;
    }

    // 中序查找
    public E infixOrderSearch(E e) {
        if (this.root == null) {
            return null;
        }
        return this.infixOrderSearch(e, this.root);
    }

    private E infixOrderSearch(E e, TreeNode<E> node) {
        if (node.left != null) {
            E resultLeft = this.infixOrderSearch(e, node.left);
            if (resultLeft != null) {
                return resultLeft;
            }
        }
        System.out.println("中序查找比较");
        if (node.item.equals(e)) {
            return e;
        }
        if (node.right != null) {
            return this.infixOrderSearch(e, node.right);
        }
        return null;
    }

    // 后序查找
    public E postOrderSearch(E e) {
        if (this.root == null) {
            return null;
        }
        return this.postOrderSearch(e, this.root);
    }

    private E postOrderSearch(E e, TreeNode<E> node) {
        if (node.left != null) {
            E resultLeft = this.postOrderSearch(e, node.left);
            if (resultLeft != null) {
                return resultLeft;
            }
        }
        if (node.right != null) {
            E resultRight = this.postOrderSearch(e, node.right);
            if (resultRight != null) {
                return resultRight;
            }
        }
        System.out.println("后序查找比较");
        if (node.item.equals(e)) {
            return e;
        }
        return null;
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
