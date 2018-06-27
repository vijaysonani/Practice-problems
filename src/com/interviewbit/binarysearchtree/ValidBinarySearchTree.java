package com.interviewbit.binarysearchtree;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * Both the left and right subtrees must also be binary search trees.
 * Example :
 *
 * Input :
 *    1
 *   / \
 *  2   3
 *
 * Output : 0 or False
 *
 *
 * Input :
 *   2
 *  / \
 * 1   3
 *
 * Output : 1 or True
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */

public class ValidBinarySearchTree {
    public static void main(String args[]) {
        TreeNode node1 = new TreeNode(100);
        TreeNode node2 = new TreeNode(98);
        TreeNode node3 = new TreeNode(102);
        TreeNode node4 = new TreeNode(96);
        TreeNode node5 = new TreeNode(99);
        TreeNode node6 = new TreeNode(97);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.right = node6;

//        11 4 2 5 1 5 -1 -1 -1 -1 -1 -1
//        Expected: 0
//
//        TreeNode node1 = new TreeNode(4);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(1);
//        TreeNode node5 = new TreeNode(5);
//
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;

//        7 4 -1 5 3 -1 -1 -1
//        Expected: 0
//
//        TreeNode node1 = new TreeNode(4);
//        TreeNode node2 = new TreeNode(-1);
//        TreeNode node3 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(3);
//
//
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;

//        49 40 35 41 34 37 -1 46 31 -1 36 38 45 47 29 32 -1 -1 -1 39 43 -1 -1 -1 28 30 -1 33 -1 -1 42 44 25 -1 -1 -1 -1 -1 -1 -1 -1 -1 24 26 -1 -1 -1 27 -1 -1
//        Expected: ?


        int result = new ValidBinarySearchTree().isValidBST(node1);
        System.out.println(result);
    }

    public int isValidBST(TreeNode A) {
        return validateTree(A);
    }

    private int validateTree(TreeNode a) {
        if (a != null) {
            if (a.left !=null) {
                if (a.val > a.left.val) {
                    validateTree(a.left);
                } else {
                    return 0;
                }
            }

            if (a.right != null) {
                if (a.val < a.right.val) {
                    validateTree(a.right);
                } else {
                    return 0;
                }
            }
        }

        return 1;
    }
}

