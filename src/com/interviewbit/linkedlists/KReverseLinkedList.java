package com.interviewbit.linkedlists;

/**
 * Given a singly linked list and an integer K, reverses the nodes of the
 * list K at a time and returns modified linked list.
 *
 * NOTE : The length of the list is divisible by K
 *
 * Example :
 * Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,
 * You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5
 * Try to solve the problem using constant extra space.
 */

public class KReverseLinkedList extends ListNode {
    public static void main(String args[]) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;

//        A : [ 8 -> 11 -> 4 -> 12 -> 0 ]
//        B : 1
//        Expected: 8 -> 11 -> 4 -> 12 -> 0
        ListNode node1 = new ListNode(8);
        ListNode node2 = new ListNode(11);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(12);
        ListNode node5 = new ListNode(0);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = new KReverseLinkedList().kReverseList(node1, 1);
        System.out.println(" kReversed list:");
        printList(result);
    }

    public ListNode kReverseList(ListNode A, int B) {
        ListNode currentNode = A;
        ListNode nextNode = null;
        ListNode prevNode = null;
        ListNode pre1 = null;
        ListNode pre2 = null;
        ListNode start = A;

        int cnt = 1;

        while (currentNode != null && B > 1) {
            if (cnt == B) {
                cnt = 1;
                if (pre2 != null) {
                    pre2.next = currentNode;
                } else {
                    start = currentNode;
                }
            } else if (cnt == 1) {
                pre2 = pre1;
                pre1 = currentNode;
                prevNode = null;
            }

            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;

            cnt++;
        }

//        System.out.println(prevNode.val);
        return start;
    }
}
