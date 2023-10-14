package LV2.짝지어제거하기;

import java.util.*;

class Solution2 {
    public int solution(String s) {
        return canRemoved(s) ? 1 : 0;
    }

    private boolean canRemoved(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                if (stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.isEmpty();
    }
}