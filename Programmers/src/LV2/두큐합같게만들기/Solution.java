package LV2.두큐합같게만들기;

import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long result = Arrays.stream(queue1).sum();
        long target = (result+Arrays.stream(queue2).sum());

        if(target%2!=0){
            return -1;
        }

        target/=2;

        int limit = (queue1.length+queue2.length)*2;

        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        for(int i=0;i<queue1.length;i++){
            q1.offer(Long.valueOf(queue1[i]));
            q2.offer(Long.valueOf(queue2[i]));
        }

        while(result != target){
            if(result>target){
                result-= q1.peek();
                q2.offer(q1.poll());

            }else if(result<target){
                result+=q2.peek();
                q1.offer(q2.poll());
            }
            if(q1.isEmpty() || answer > limit){
                return -1;
            }
            answer++;
        }

        return answer;
    }
}