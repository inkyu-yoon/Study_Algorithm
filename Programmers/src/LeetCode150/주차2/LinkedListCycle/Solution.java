package LeetCode150.주차2.LinkedListCycle;
/**
 * Definition for singly-linked list.
 */

import java.util.*;

public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode now = head;
        set.add(now);

        while (now != null) {
            ListNode nextNode = now.next;

            if (set.contains(nextNode)) {
                return true;
            }

            set.add(nextNode);
            now = nextNode;
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while (pointer2.next != null && pointer2.next.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;

            if (pointer1 == pointer2) {
                return true;
            }

        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
