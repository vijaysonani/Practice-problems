package com.interviewbit.linkedlists;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() { val = 0; next = null; }

    public ListNode(int x) { val = x; next = null; }

    public static int getListLength(ListNode a) {
        int length = 0;
        ListNode currentNode = a;
        System.out.println(currentNode == null);

        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }

        return length;
    }

    public static void printList(ListNode A) {
        while (A != null) {
            System.out.println(A.val);
            A = A.next;
        }
    }
}
