package com.liboru.datastructure.tree;

public class BinaryTreeTest {

    public static void main(String[] args) {

        /*testOrder();*/
        /*testSearch();*/
        testDel();

    }

    public static void testDel(){
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
        binaryTree.delNode(4);
        binaryTree.preOrderList();
    }

    /**
     * @apiNote 测试查找
     * @author lbr
     */
    public static void testSearch(){
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

        System.out.println("前序查找");
        System.out.println(binaryTree.preOrderSearch(1));
        System.out.println(binaryTree.preOrderSearch(2));
        System.out.println(binaryTree.preOrderSearch(3));
        System.out.println(binaryTree.preOrderSearch(4));
        System.out.println(binaryTree.preOrderSearch(5));
        System.out.println(binaryTree.preOrderSearch(6));

        System.out.println("中序查找");
        System.out.println(binaryTree.infixOrderSearch(1));
        System.out.println(binaryTree.infixOrderSearch(2));
        System.out.println(binaryTree.infixOrderSearch(3));
        System.out.println(binaryTree.infixOrderSearch(4));
        System.out.println(binaryTree.infixOrderSearch(5));
        System.out.println(binaryTree.infixOrderSearch(6));

        System.out.println("后序查找");
        System.out.println(binaryTree.postOrderSearch(1));
        System.out.println(binaryTree.postOrderSearch(2));
        System.out.println(binaryTree.postOrderSearch(3));
        System.out.println(binaryTree.postOrderSearch(4));
        System.out.println(binaryTree.postOrderSearch(5));
        System.out.println(binaryTree.postOrderSearch(6));
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
