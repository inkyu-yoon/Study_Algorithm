package LV2.귤고르기;

import java.util.*;

class Solution2 {
    public int solution(int k, int[] tangerine) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            int type = tangerine[i];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int type : map.keySet()) {
            int num = map.get(type);
            pq.offer(num);
        }

        int cnt = 0;

        while (!pq.isEmpty()) {
            int num = pq.poll();
            k -= num;
            cnt++;
            if (k <= 0) {
                break;
            }
        }

        return cnt;
    }
}