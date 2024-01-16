package Heap;

// LeetCode problem 23
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

        // The code currently infinitely loops, find out where
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
        int minValue = 0;
        ListNode head = null;
        ListNode currentNode;
        int emptyNodes = 0;
        // Loop while the list still has nodes
        while (lists.length > 0) {
            // Compares all of the head nodes for the minimum value.
            for (ListNode minNode : lists) {
                if (minNode != null) {
                    minValue = Math.min(minValue, minNode.val);
                    // if a node in the list is empty, remake the list without the node
                } else if (lists.length > 0) {
                    ListNode[] newList = new ListNode[lists.length - 1];
                    for (int i = 0; i < lists.length - emptyNodes; i++) {
                        newList[i] = lists[i];
                    }
                    lists = newList;
                }
            }
            // Finds node with the minumum value and adds it to the LinkedList.
            for (ListNode findMin : lists) {
                if (findMin != null && minValue == findMin.val) {
                    head.next = findMin;
                    findMin = findMin.next;
                    head = head.next;
                }
            }
        }

        // there HAS to be a faster way than reversing the list
        return reverseList(head);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;

        // Loop while there is still another node to be copied.
        while (head != null) {
            // Deep clone the current node.
            ListNode n = new ListNode(head.val);
            // Initialize the next node to be copied.
            n.next = reverseHead;
            // Set the deep cloned node to be the next node.
            reverseHead = n;
            // Access the next node in the inputted list and loop.
            head = head.next;
        }

        return reverseHead;
    }
}
