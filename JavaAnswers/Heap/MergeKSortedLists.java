package Heap;

// LeetCode Problem 23
public class MergeKSortedLists {
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

        ListNode node7 = new ListNode(3);

        // [3, 5]
        ListNode root3 = new ListNode(3);
        root3.next = node7;

        ListNode[] nodes = { root1, root2, root3 };

        // ListNode mergedList = mergeKListsBruteForce(nodes);
        ListNode mergedList = mergeKLists(nodes);

        // should be [1, 1, 1, 2, 3, 3, 4, 5, 5]
        System.out.println(toString(mergedList));
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

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        //return mergeKListsMergeSort(lists, 0, lists.length - 1);
        return mergeKListsBruteForce(lists);
    }

    // Implements mergesort to sort the ListNodes
    public static ListNode mergeKListsMergeSort(ListNode[] lists, int start, int end) {
        if (start == end)
            return lists[start];

        if (start + 1 == end)
            return mergeHelper(lists[start], lists[end]);

        int mid = (start + end) / 2;

        ListNode mergedLeftNode = mergeKListsMergeSort(lists, start, mid);
        ListNode mergedRightNode = mergeKListsMergeSort(lists, mid + 1, end);

        return mergeHelper(mergedLeftNode, mergedRightNode);
    }

    // This solution is really slow, and was my first-try brute force attempt.
    // It merges and sorts the first node with the second,
    // then merges and sorts that with the third, and so on.
    public static ListNode mergeKListsBruteForce(ListNode[] lists) {
        ListNode head = new ListNode();

        if (lists != null && lists.length != 0) {
            head = lists[0];
        }

        for (int i = 1; i < lists.length; i++) {
            head = mergeHelper(head, lists[i]);
        }

        return head;
    }

    public static ListNode mergeHelper(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null)
            return null;

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                tail.next = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
            }
            tail = tail.next;
        }


        while (node1 != null) {
            tail.next = node1;
            node1 = node1.next;
            tail = tail.next;
        }

        while (node2 != null) {
            tail.next = node2;
            node2 = node2.next;
            tail = tail.next;
        }
        
        return dummy.next;
    }
}
