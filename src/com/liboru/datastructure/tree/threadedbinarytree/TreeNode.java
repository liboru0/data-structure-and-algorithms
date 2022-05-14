package com.liboru.datastructure.tree.threadedbinarytree;

public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    // 0-左子树/右子树 1-前驱节点/后继节点
    // 默认为 0
    public int leftType = 0;
    public int rightType = 0;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
