package LV2.두큐합같게만들기;

import java.util.*;

class Solution3 {
    public int solution(int[] queue1, int[] queue2) {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            sum1 += queue1[i];
            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }
        int count = 0;
        while (count < queue1.length * 3 && sum1 != sum2) {
            if (sum1 > sum2) {
                int value = q1.poll();
                sum1 -= value;
                sum2 += value;
                q2.offer(value);
                count++;

            } else if (sum1 < sum2) {
                int value = q2.poll();
                sum2 -= value;
                sum1 += value;
                q1.offer(value);
                count++;
            }
        }


        return count == queue1.length * 3 ? -1 : count;
    }
}
