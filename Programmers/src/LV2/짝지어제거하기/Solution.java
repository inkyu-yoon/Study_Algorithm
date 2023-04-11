package LV2.짝지어제거하기;

import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(target);
            } else {
                if (stack.peek() == target) {
                    stack.pop();
                } else {
                    stack.push(target);
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}