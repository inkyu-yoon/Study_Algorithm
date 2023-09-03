package LeetCode150.주차2_2.SortList;


import java.util.*;

class Solution {
    public ListNode sortList(ListNode head) {
        int cnt = getCount(head);
        System.out.println(cnt);
        int[] arr = new int[cnt];
        ListNode dummyHead = new ListNode(0, head);

        ListNode node = head;
        for (int i = 0; i < cnt; i++) {
            arr[i] = node.val;
            node = node.next;
        }

        mergeSort(arr, 0, cnt);
        for (int i = 0; i < cnt; i++) {
            head.val = arr[i];
            head = head.next;
        }
        return dummyHead.next;
    }

    private int getCount(ListNode head) {
        int cnt = 0;
        while (head != null) {
            head = head.next;
            cnt++;
        }
        return cnt;
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left];
        int idx = 0, l = left, r = mid;
        while (l < mid && r < right) {
            if (arr[l] > arr[r]) {
                temp[idx++] = arr[r++];
            } else {
                temp[idx++] = arr[l++];
            }
        }

        while (l < mid) {
            temp[idx++] = arr[l++];
        }

        while (r < right) {
            temp[idx++] = arr[r++];
        }

        for (int i = left; i < right; i++) {
            arr[i] = temp[i - left];
        }

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
