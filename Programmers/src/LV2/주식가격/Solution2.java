package LV2.주식가격;

import java.util.*;

class Solution2 {
    Stack<Integer> s = new Stack<>();

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (s.isEmpty()) {
                s.push(i);
            } else {
                if (prices[s.peek()] <= price) {
                    s.push(i);
                } else {
                    while (!s.isEmpty() && prices[s.peek()] > price) {
                        int idx = s.pop();
                        answer[idx] = i - idx;
                    }
                    s.push(i);
                }
            }
        }

        for (int idx : s) {
            answer[idx] = prices.length - 1 - idx;
        }

        return answer;
    }
}
