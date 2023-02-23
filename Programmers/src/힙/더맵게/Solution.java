package 힙.더맵게;

import java.util.*;
// 모든 음식의 스코빌 지수를 K이상으로 만든다.
// 가장 맵지 않은 스코빌 지수 + (두번째로 맵지 않은 음식 스코빌 지수*2)
// 모든 음식의 스코빌 지수가 K이상이 될때까지 반복
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int scov : scoville){
            q.offer(scov);
        }

        while(q.peek()<K){

            if(q.size()==1){
                return -1;
            }

            int first = q.poll();
            int second = q.poll();

            int result = first + second*2;
            q.offer(result);
            answer++;
        }

        return answer;
    }
}