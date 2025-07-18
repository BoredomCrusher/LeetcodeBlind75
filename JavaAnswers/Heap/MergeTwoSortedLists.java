package Heap;

// LeetCode Problem 21

// This question isn't in blind 75,
// but it's a good warmup to solve MergeKSortedLists.
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;

        // [1, 2, 3, 4]
        ListNode root1 = new ListNode(1);
        root1.next = node1;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(5);

        node4.next = node5;
        node5.next = node6;

        // [1, 1, 3, 5]
        ListNode root2 = new ListNode(1);
        root2.next = node4;

        // [1, 1, 1, 2, 3, 3, 4, 5]
        ListNode mergedNode = solution(root1, root2);
        System.out.println(toString(mergedNode));
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static String toString(ListNode head) {
        String result = "";
        while (head != null) {
            result += head.val;
            if (head.next != null) {
                result += ", ";
            }
            head = head.next;
        }
        return "List: " + result;
    }

    public static ListNode solution(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return null;

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list2 == null && list1 != null) {
            while (list1 != null) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }
        } else if (list1 == null && list2 != null) {
            while (list2 != null) {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        return dummy.next;
    }
}