package com.interviewbit.binarysearchtree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes’ values.
 *
 * Example :
 *
 * Given binary tree
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [3,2,1].
 *
 * Using recursion is not allowed.
 */

public class PostorderTraversal {
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

//        ArrayList<Integer> result1 = new PostorderTraversal().postorderRecursive(node1);
//        System.out.println(result1.toString());

        ArrayList<Integer> result = new PostorderTraversal().postorderTraversal(node1);
        System.out.println(result.toString());
    }


    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();

        if (A == null) { return result; }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        TreeNode topNode;

        while (!stack.isEmpty()) {
            topNode = stack.peek();

            if (topNode.left == null && topNode.right == null) {
                result.add(stack.pop().val);
            } else {
                if (topNode.right != null) {
                    stack.push(topNode.right);
                    topNode.right = null;
                }
                if (topNode.left != null) {
                    stack.push(topNode.left);
                    topNode.left = null;
                }
            }
        }

        return result;
    }

    public ArrayList<Integer> postorderRecursive(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();

        postorderRecursiveTraversal(a, result);
        return result;
    }

    // Recursive approach
    private void postorderRecursiveTraversal(TreeNode a, ArrayList<Integer> result) {
        if (a == null) { return; }

        postorderRecursiveTraversal(a.left, result);
        postorderRecursiveTraversal(a.right, result);
        result.add(a.val);
    }
}
