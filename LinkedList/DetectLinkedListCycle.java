package LinkedList;

import java.util.HashMap;

// LeetCode problem 141
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

        System.out.println("no cycle, return false: " + detectCycle.hasCycle(node1));

        node3.next = node1;

        System.out.println("there is a cycle, return true: " + detectCycle.hasCycle(node1));
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

    public static boolean hasCycle(ListNode head) {
        // Hashmap stores a node's value and the node's next node's value.
        HashMap<ListNode, ListNode> map = new HashMap<>();
        while (head != null && head.next != null) {
            // if the node and its next node have already been iterated through,
            // a cycle has been detected
            if (map.get(head) != null && map.get(head) == head.next) {
                return true;
            }
            map.put(head, head.next);
            head = head.next;
        }
        return false;
    }

}