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

        ListNode result = new PalindromeLinkedList().palindromeList(node1);
        System.out.println(" kReversed list:");
        printList(result);
    }

    public ListNode palindromeList(ListNode A) {

        return null;
    }
}
