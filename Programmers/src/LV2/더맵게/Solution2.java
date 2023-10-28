package LV2.더맵게;

// 섞은 후 = 가장 맵지 않은 것 + 두번쨰로 맵지 않은 것 *2

import java.util.*;

// 섞은 후 = 가장 맵지 않은 것 + 두번쨰로 맵지 않은 것 *2
import java.util.*;

class Solution2 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int value : scoville) {
            pq.offer(value);
        }

        while (pq.size() >= 2 && pq.peek() < K) {
            pq.offer(pq.poll() + pq.poll() * 2);
            answer++;
        }

        return pq.peek() >= K ? answer : -1;
    }
}