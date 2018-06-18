package com.interviewbit.linkedlists;

public class Intersection extends ListNode {
    public static void main (String args[]) {
//        ListNode node90 = new ListNode(90);
//        ListNode node91 = new ListNode(91);
//        ListNode node92 = new ListNode(92);
//        ListNode node99 = new ListNode(99);
//
//        node90.next = node91;
//        node91.next = node92;
//        node99.next = node90;
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

//        ListNode result = new Intersection().getIntersectionNode(node1, node11);

        ListNode result = new Intersection().getIntersectionNode(null, null);

        if (result != null) {
            System.out.println("Intersection node: " + result.val);
        } else {
            System.out.println("No intersection found");
        }
    }

    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        ListNode bigNode;
        ListNode smallNode;

        final int aLength = getListLength(a);
        final int bLength = getListLength(b);
        int diff;

        if (aLength > bLength) {
            bigNode = a;
            smallNode = b;
            diff = aLength - bLength;
        } else {
            bigNode = b;
            smallNode = a;
            diff = bLength - aLength;
        }

        for(int i = 0; i < diff; i++) {
            bigNode = bigNode.next;
        }

        while(bigNode != null || smallNode != null) {
            if (bigNode.val == smallNode.val && bigNode.equals(smallNode)) {
                return bigNode;
            }
            bigNode = bigNode.next;
            smallNode = smallNode.next;
        }

//        System.out.println(bigNode.val + ", " + smallNode.val);
        return null;
    }
}
