package com.interviewbit.binarysearchtree;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Given a binary tree, print a vertical order traversal of it.
 *
 * Example :
 * Given binary tree:
 *
 *       6
 *     /   \
 *    3     7
 *   / \     \
 *  2   5     9
 *
 * returns
 *
 * [
 *     [2],
 *     [3],
 *     [6 5],
 *     [7],
 *     [9]
 * ]
 *
 * Note : If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
 */

public class VerticalTraversal {
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

//        43 460 3871 4698 8399 504 4421 7515 -1 4167 5727 -1 -1 3096 434 7389 2667 5661 1969 7815 4292 3006 9750 6693 -1 6906 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
//        Expected: [8399 2667 1969 ] [3871 4167 5727 ] [460 504 4421 5661 7815 4292 9750 ] [4698 3096 434 ] [7515 3006 6693 ] [7389 ] [6906 ]
//        Got:      [8399 2667 1969 ] [3871 4167 5727 ] [460 5661 504 7815 4421 4292 9750 ] [4698 3096 434 ] [3006 7515 6693 ] [7389 ] [6906 ]

        ArrayList<ArrayList<Integer>> result = new VerticalTraversal().verticalOrderTraversal(node1);

        for (ArrayList<Integer> entry : result){
            System.out.println(entry.toString());
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        populateVerticalOrderMap(A, map, 0);

        for (Integer key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }

    private void populateVerticalOrderMap(TreeNode a, TreeMap<Integer, ArrayList<Integer>> map, int hd) {
        if (a == null) { return; }

        ArrayList<Integer> nodeList;

        if (map.containsKey(hd)) {
            nodeList = map.get(hd);
        } else {
            nodeList = new ArrayList<>();
        }

        nodeList.add(a.val);
        map.put(hd, nodeList);

        populateVerticalOrderMap(a.left, map, hd - 1);
        populateVerticalOrderMap(a.right, map, hd + 1);
    }
}
