package com.interviewbit.checkpoints;

import com.interviewbit.linkedlists.ListNode;
import com.interviewbit.linkedlists.ReverseLinkedList;

/**
 * Given a singly linked list, modify the value of first half nodes such that :
 *
 * 1st node’s new value = the last node’s value - first node’s current value
 * 2nd node’s new value = the second last node’s value - 2nd node’s current value,
 * and so on …
 *
 *  NOTE :
 * If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes. So, if L = 5, the first half refers to first 2 nodes.
 * If the length L of linked list is even, then the first half implies at first L/2 nodes. So, if L = 4, the first half refers to first 2 nodes.
 * Example :
 *
 * Given linked list 1 -> 2 -> 3 -> 4 -> 5,
 *
 * You should return 4 -> 2 -> 3 -> 4 -> 5
 * as
 *
 * for first node, 5 - 1 = 4
 * for second node, 4 - 2 = 2
 *
 * Try to solve the problem using constant extra space.
 */

public class SubtractLinkedList {
    public static void main (String args[]) {
        ListNode node90 = new ListNode(90);
        ListNode node91 = new ListNode(91);
        ListNode node92 = new ListNode(92);
        ListNode node99 = new ListNode(99);

        node90.next = node91;
        node91.next = node92;
        node92.next = node99;
//
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//
//        node1.next = node2;
//        node2.next = node99;
//
//        ListNode node11 = new ListNode(11);
//        ListNode node12 = new ListNode(12);
//        ListNode node13 = new ListNode(13);
//
//        node11.next = node12;
//        node12.next = node13;
//        node13.next = node99;

        ListNode result = new SubtractLinkedList().subtract(node90);

        System.out.println("Subtract: ");
        ListNode.printList(result);
    }

    public ListNode subtract(ListNode A) {
        ListNode current = A;
        final int length = ListNode.getListLength(A);

        ListNode copy = copyList(A);
        copy = reverseList(copy);
        ListNode start = A;

        for (int i = 0; i < length/2; i++) {
            if (current == null || copy == null) {
                continue;
            }
            current.val = (copy.val - current.val);
            current = current.next;
            copy = copy.next;
        }


        return A;
    }

    private ListNode copyList(ListNode A) {
        ListNode B = null;
        ListNode ANode = A;
        ListNode BNode = null;
        ListNode start = null;

        if (A != null) {
            B = new ListNode(ANode.val);
            start = B;
        }

        while (ANode.next != null) {
            BNode = new ListNode(ANode.next.val);
            ANode = ANode.next;

            B.next = BNode;
            B = B.next;
        }

        return start;
    }

    private ListNode reverseList(ListNode A) {
        ListNode currentNode = A;
        ListNode nextNode = null;
        ListNode prevNode = null;

        while(currentNode != null) {
            if (nextNode == null) {
                nextNode = currentNode.next;
                currentNode.next = null;
                prevNode = currentNode;
            } else {
                nextNode = currentNode.next;
                currentNode.next = prevNode;
                prevNode = currentNode;
            }

            currentNode = nextNode;
        }

        return prevNode;
    }
}
