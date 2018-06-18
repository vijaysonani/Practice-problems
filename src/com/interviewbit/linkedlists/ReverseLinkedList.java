package com.interviewbit.linkedlists;

public class ReverseLinkedList extends ListNode {
    public static void main(String args[]) {
        ListNode node11 = new ListNode(11);
        ListNode node12 = new ListNode(12);
        ListNode node13 = new ListNode(13);

        node11.next = node12;
        node12.next = node13;

        ListNode result = new ReverseLinkedList().reverseList(node11);
        System.out.println("Reversed list:");
        printList(result);
    }

    public ListNode reverseList(ListNode A) {
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
