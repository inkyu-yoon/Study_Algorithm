package LeetCode150.주차2.AddTwoNumbers;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int q = 0;
        int r = 0;
        ListNode start = new ListNode();
        ListNode node = start;
        while (l1 != null || l2 != null || q != 0) {
            int sum = q;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            q = sum / 10;
            r = sum % 10;

            node.next = new ListNode(r);

            node = node.next;
        }

        return start.next;
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