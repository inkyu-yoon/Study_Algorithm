package LV2.뒤에있는큰수찾기;

import java.util.*;

class Solution2 {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (s.isEmpty()) {
                s.push(i);
            } else {
                while (!s.isEmpty() && numbers[s.peek()] < num) {
                    int idx = s.pop();
                    answer[idx] = num;
                }
                s.push(i);
            }
        }
        return answer;
    }
}