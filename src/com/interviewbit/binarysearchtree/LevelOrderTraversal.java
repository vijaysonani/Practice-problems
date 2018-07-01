package com.interviewbit.binarysearchtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */

public class LevelOrderTraversal {
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

        ArrayList<ArrayList<Integer>> result = new LevelOrderTraversal().levelOrder(node1);

        for (ArrayList<Integer> entry : result){
            System.out.println(entry.toString());
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        populateLevelOrderMap(a, map, 0);

        for (Integer key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }

    private void populateLevelOrderMap(TreeNode a, TreeMap<Integer, ArrayList<Integer>> map, int hd) {
        if (a == null) {
            return;
        }

        ArrayList<Integer> temp;

        if (map.containsKey(hd)) {
            temp = map.get(hd);
        } else {
            temp = new ArrayList<>();
        }

        temp.add(temp.size(), a.val);
        map.put(hd, temp);

        populateLevelOrderMap(a.left, map, hd + 1);
        populateLevelOrderMap(a.right, map, hd + 1);
    }
}
