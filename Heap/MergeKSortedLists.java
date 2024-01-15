package Heap;

public class MergeKSortedLists {
    public static void main(String[] args) {
        // make some test cases here since the code currently infinitely loops
    }

    // Definition for singly-linked list.
    public class ListNode {
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

    public ListNode mergeKLists(ListNode[] lists) {
        int minValue = 0;
        ListNode head = null;
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

    // reverses LinkedList
    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;

        while (head != null) {
            ListNode n = new ListNode(head.val);
            n.next = reverseHead;
            reverseHead = n;
            head = head.next;
        }

        return reverseHead;
    }
}
