package LV3.야근지수;

import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        int sum = Arrays.stream(works).sum();
        if(sum<=n){
            return 0;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works){
            q.offer(work);
        }

        while(n-->0){
            int work = q.poll()-1;
            q.offer(work);
        }


        return q.stream()
                .mapToLong(i->i*i)
                .sum();
    }
}
