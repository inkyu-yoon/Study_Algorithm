package LeetCode150.주차2.MergeTwoSortedLists;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode ans = head;
        ListNode result;

        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val >= list2.val) {
                    result = list2;
                    list2 = list2.next;
                } else {
                    result = list1;
                    list1 = list1.next;
                }
            } else if (list1 == null) {
                result = list2;
                list2 = list2.next;
            } else {
                result = list1;
                list1 = list1.next;
            }

            ans.next = result;
            ans = ans.next;
        }
        return head.next;
    }
}

class ListNode {
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