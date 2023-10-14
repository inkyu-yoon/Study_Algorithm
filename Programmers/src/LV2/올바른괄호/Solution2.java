package LV2.올바른괄호;

import java.util.*;

class Solution2 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        int N = s.length();

        for (int i = 0; i < N; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
