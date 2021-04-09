package com.liboru.datastructure.tree;

public class BinaryTreeTest {

    public static void main(String[] args) {

        testOrder();


    }

    /**
     * @apiNote 测试遍历
     * @author lbr
     */
    public static void testOrder(){
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        BinaryTree.TreeNode<Integer> root = new BinaryTree.TreeNode<Integer>(1);
        BinaryTree.TreeNode<Integer> node2 = new BinaryTree.TreeNode<Integer>(2);
        BinaryTree.TreeNode<Integer> node3 = new BinaryTree.TreeNode<Integer>(3);
        BinaryTree.TreeNode<Integer> node4 = new BinaryTree.TreeNode<Integer>(4);
        BinaryTree.TreeNode<Integer> node5 = new BinaryTree.TreeNode<Integer>(5);

        // 先手动创建二叉树
        binaryTree.setRoot(root);
        root.left = node2;
        root.right = node3;
        root.right.left = node4;
        root.right.right = node5;
        /**
         *       1
         *    2     3
         *        4    5
         */

        System.out.println("前序遍历");
        binaryTree.preOrderList(); // 1 2 3 4 5

        System.out.println("中序遍历");
        binaryTree.infixOrderList(); // 2 1 4 3 5

        System.out.println("后序遍历");
        binaryTree.postOrderList(); // 2 4 5 3 1
    }

}
