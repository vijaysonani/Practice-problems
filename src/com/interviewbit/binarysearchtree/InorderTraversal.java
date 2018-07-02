package com.interviewbit.binarysearchtree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes’ values.
 *
 * Example :
 * Given binary tree
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,3,2].
 *
 * Using recursion is not allowed.
 */

public class InorderTraversal {
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

//        ArrayList<Integer> result = new InorderTraversal().inorderRecursive(node1);
        ArrayList<Integer> result = new InorderTraversal().inorderTraversal(node1);
        System.out.println(result.toString());
    }


    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        if (A == null) { return null; }

        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        TreeNode currentNode = A.left;

        while (!stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                A = stack.pop();
                result.add(A.val);
                if (A.right != null) {
                    A = A.right;
                    stack.push(A);
                    currentNode = A.left;
                }
            }
        }

        return result;
    }

    public ArrayList<Integer> inorderRecursive(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();

        inorderRecursiveTraversal(a, result);
        return result;
    }

    // Recursive approach
    private void inorderRecursiveTraversal(TreeNode a, ArrayList<Integer> result) {
        if (a == null) { return; }

        inorderRecursiveTraversal(a.left, result);
        result.add(a.val);
        inorderRecursiveTraversal(a.right, result);
    }
}
