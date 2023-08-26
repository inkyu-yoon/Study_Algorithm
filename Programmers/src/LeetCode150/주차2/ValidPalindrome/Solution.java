package LeetCode150.주차2.ValidPalindrome;

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toLowerCase().toCharArray();

        for (char ch : arr) {
            if (isAlpha(ch) || isNum(ch)) {
                sb.append(ch);
            }
        }

        return sb.toString().equals(sb.reverse().toString());
    }

    public boolean isPalindrome2(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toLowerCase().toCharArray();

        for (char ch : arr) {
            if (isAlpha(ch) || isNum(ch)) {
                sb.append(ch);
            }
        }

        String[] strs = sb.toString().split("");

        int left = 0, right = strs.length - 1;

        while (left < right) {
            if (!strs[left++].equals(strs[right--])) {
                return false;
            }
        }

        return true;

    }

    private boolean isAlpha(char ch) {
        if ('a' <= ch && ch <= 'z') {
            return true;
        } else {
            return false;
        }
    }

    private boolean isNum(char ch) {
        if ('0' <= ch && ch <= '9') {
            return true;
        } else {
            return false;
        }
    }
}