package LV3.야근지수;

import java.util.*;

class Solution2 {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

    public long solution(int n, int[] works) {
        long ans = 0;
        for (int work : works) {
            pq.offer(work);
        }

        while (n-- > 0) {
            int work = pq.poll();
            if (work == 0) {
                break;
            }
            pq.offer(work - 1);
        }

        while (!pq.isEmpty()) {
            ans += Math.pow(pq.poll(), 2);
        }


        return ans;
    }
}
