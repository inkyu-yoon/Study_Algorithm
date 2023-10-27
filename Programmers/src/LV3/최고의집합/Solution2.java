package LV3.최고의집합;

import java.util.*;

class Solution2 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if (s / n == 0) {
            return new int[]{-1};
        }

        Arrays.fill(answer, s / n);
        s -= (s / n) * n;

        int idx = n;
        while (s-- > 0) {
            idx = (idx - 1) % n;
            answer[idx]++;
        }


        return answer;
    }
}