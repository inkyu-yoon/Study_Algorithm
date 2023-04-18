package LV2.더맵게;

// 모든 음식의 스코빌 지수를 K 이상으로 만든다.
import java.util.*;
class Solution {
    PriorityQueue<Integer> q;
    public int solution(int[] scoville, int K) {
        setUp(scoville);
        int ans = 0;

        while(q.peek()<K && q.size()>=2){
            int reMake = q.poll() + q.poll()*2;
            q.offer(reMake);
            ans++;
        }
        if(q.size()==1 && q.peek()<K){
            return -1;
        }else{
            return ans;
        }

    }
    void setUp(int[] scoville){
        q = new PriorityQueue<>();
        for(int sc : scoville){
            q.offer(sc);
        }
    }
}