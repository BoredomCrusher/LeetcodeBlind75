package LinkedList;

import java.util.HashSet;

// LeetCode Problem 141
public class DetectLinkedListCycle {
    public static void main(String[] args) {
        DetectLinkedListCycle detectCycle = new DetectLinkedListCycle();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("no cycle, return false: " + detectCycle.hasCycleMovingPointers(node1));

        node3.next = node1;

        System.out.println("there is a cycle, return true: " + detectCycle.hasCycleMovingPointers(node1));
    }

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycleSlow(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head)) {
                set.add(head);
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleMovingPointers(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
           
            if (slow == fast)
                return true;
        }

        return false;
    }
}