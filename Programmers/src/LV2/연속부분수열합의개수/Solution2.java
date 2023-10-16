package LV2.연속부분수열합의개수;

import java.util.*;

class Solution2 {
    public int solution(int[] elements) {

        int N = elements.length;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < i + N; j++) {
                int idx = j % N;
                sum += elements[idx];
                set.add(sum);
            }
        }

        return set.size();
    }
}
