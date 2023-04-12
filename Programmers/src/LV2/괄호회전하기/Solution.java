package LV2.괄호회전하기;

import java.util.*;

class Solution {
    Queue<Character> q;

    public int solution(String s) {
        int answer = 0;

        q = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            q.offer(ch);
        }

        int time = s.length();
        while (time-- > 0) {
            if (check()) {
                answer++;
            }
            q.offer(q.poll());
        }

        return answer;
    }

    boolean check() {
        Stack<Character> s = new Stack<>();
        for (Character ch : q) {
            if (s.isEmpty()) {
                if (ch == ']' || ch == '}' || ch == ')') {
                    return false;
                } else {
                    s.push(ch);
                }
            } else {
                if (ch == ']') {
                    if (s.peek() == '[') {
                        s.pop();
                    } else {
                        return false;
                    }
                } else if (ch == '}') {
                    if (s.peek() == '{') {
                        s.pop();
                    } else {
                        return false;
                    }
                } else if (ch == ')') {
                    if (s.peek() == '(') {
                        s.pop();
                    } else {
                        return false;
                    }
                } else {
                    s.push(ch);
                }
            }
        }

        return s.isEmpty();
    }
}