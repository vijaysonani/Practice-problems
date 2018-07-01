package com.interviewbit.binarysearchtree;

import java.util.*;

/**
 * Given a binary tree, return the preorder traversal of its nodes’ values.
 *
 * Example :
 * Given binary tree
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,2,3].
 *
 * Using recursion is not allowed.
 */

public class PreorderTraversal {
    public static void main(String args[]) {
        TreeNode node1 = new TreeNode(100);
        TreeNode node2 = new TreeNode(98);
        TreeNode node3 = new TreeNode(102);
        TreeNode node4 = new TreeNode(96);
        TreeNode node5 = new TreeNode(99);
        TreeNode node6 = new TreeNode(97);
        TreeNode node7 = new TreeNode(101);
        TreeNode node8 = new TreeNode(103);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.right = node6;
        node3.left = node7;
        node3.right = node8;

//        ArrayList<Integer> result = new PreorderTraversal().preorderRecursive(node1);
        ArrayList<Integer> result = new PreorderTraversal().preorderTraversal(node1);
        System.out.println(result.toString());
    }


    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        if (A == null) { return null; }

        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);

        while (!stack.isEmpty()) {
            A = stack.pop();
            result.add(A.val);

            if (A.right != null) {
                stack.push(A.right);
            }

            if (A.left != null) {
                stack.push(A.left);
            }
        }

        return result;
    }

    public ArrayList<Integer> preorderRecursive(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();

        preorderRecursiveTraversal(a, result);
        return result;
    }

    // Recursive approach
    private void preorderRecursiveTraversal(TreeNode a, ArrayList<Integer> result) {
        if (a == null) { return; }

        result.add(a.val);
        preorderRecursiveTraversal(a.left, result);
        preorderRecursiveTraversal(a.right, result);
    }
}
