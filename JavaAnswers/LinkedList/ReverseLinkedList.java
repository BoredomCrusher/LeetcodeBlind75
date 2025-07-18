package LinkedList;

// LeetCode Problem 206
public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList linkedList = new ReverseLinkedList();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(toString(node1));
        System.out.println(toString(reverseList(node1)));
    }

    // Definition for singly-linked list.
    static class ListNode {
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

    public static ListNode recursiveReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head; 

        ListNode n = recursiveReverseList(head.next);
        head.next.next = head;
        head.next = null;

        return n;
    }
}
