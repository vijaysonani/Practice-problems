package com.interviewbit.binarysearchtree;

/**
 * Given a BST node, return the node which has value just greater than the given node.
 *
 * Example:
 *
 * Given the tree
 *
 *                100
 *               /   \
 *             98    102
 *            /  \
 *          96    99
 *           \
 *            97
 * Given 97, you should return the node corresponding to 98 as thats the value just greater than 97 in the tree.
 * If there are no successor in the tree ( the value is the largest in the tree, return NULL).
 *
 * Using recursion is not allowed.
 *
 * Assume that the value is always present in the tree.
 */

public class NextGreaterNumber {
    public static void main(String args[]){
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
        TreeNode.printTree(node1);

        TreeNode result = new NextGreaterNumber().getSuccessor(node1, 97);
        System.out.println(result.val);
    }

    public TreeNode getSuccessor(TreeNode a, int b) {
        TreeNode result = null;
        TreeNode currentNode = a;

        while(currentNode != null && currentNode.val != b) {
            if (currentNode.val < b) {
                currentNode = currentNode.right;
            } else if (currentNode.val > b) {
                result = currentNode;
                currentNode = currentNode.left;
            }
        }

        if (currentNode == null) {
            return null;
        }

        if (currentNode.right == null) {
            return result;
        }

//        TreeNode minResult = findMin(result.right);
//        if (result != null && minResult != null) {
//            result = (result.val < minResult.val) ? result : minResult;
//        }

        return findMin(result.right);
    }

    private TreeNode findMin(TreeNode T) {
        TreeNode current = T;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }
}


















