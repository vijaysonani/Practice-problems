package com.interviewbit.linkedlists;

/**
 * Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.
 *
 * Notes:
 *
 * Expected solution is linear in time and constant in space.
 * For example,
 *
 * List 1-->2-->1 is a palindrome.
 * List 1-->2-->3 is not a palindrome.
 */

public class PalindromeLinkedList extends ListNode {
    public static void main(String args[]) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        int result = new PalindromeLinkedList().lPalin(node1);
        System.out.println("Palindrome list: " + result);
    }

    public int lPalin(ListNode A) {
        ListNode B = copyList(A);
        B = reverseList(B);

        while (A != null && B != null) {
            if (A.val == B.val) {
                A = A.next;
                B = B.next;
            } else {
                return 0;
            }
        }

        return (A == null && B == null) ? 1 : 0;
    }

    private ListNode reverseList(ListNode A) {
        ListNode currentNode = A;
        ListNode nextNode = null;
        ListNode prevNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        return prevNode;
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
}
