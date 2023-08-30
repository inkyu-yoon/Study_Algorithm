package LeetCode150.주차2_1.ReversePolishNotation;

import java.util.*;

class Solution {
    Stack<Integer> stack = new Stack<>();
    Set<String> set = new HashSet<>(List.of("+", "-", "/", "*"));

    public int evalRPN(String[] tokens) {
        for (String token : tokens) {
            if (set.contains(token)) {
                int[] info = getInfo();
                if (token.equals("+")) {
                    stack.push(info[0] + info[1]);
                } else if (token.equals("-")) {
                    stack.push(info[0] - info[1]);
                } else if (token.equals("*")) {
                    stack.push(info[0] * info[1]);
                } else if (token.equals("/")) {
                    stack.push(info[0] / info[1]);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int[] getInfo() {
        int back = stack.pop();
        int front = stack.pop();
        return new int[]{front, back};
    }
}