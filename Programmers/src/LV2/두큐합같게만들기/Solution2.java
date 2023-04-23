package LV2.두큐합같게만들기;

import java.util.*;
class Solution2 {
    Queue<Integer> left = new LinkedList<>();
    Queue<Integer> right = new LinkedList<>();
    long leftSum = 0;
    long rightSum = 0;
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        setUp(queue1,queue2);


        while(leftSum!=rightSum){
            if(answer>4*(queue1.length)){
                return -1;
            }
            if(leftSum>rightSum){
                int move = left.poll();
                right.offer(move);
                leftSum-=move;
                rightSum+=move;
            }else if(leftSum<rightSum){
                int move = right.poll();
                left.offer(move);
                leftSum+=move;
                rightSum-=move;
            }
            answer++;
        }
        return answer;
    }
    void setUp(int[] queue1, int[] queue2){
        for(int i=0;i<queue1.length;i++){
            left.offer(queue1[i]);
            leftSum+=queue1[i];

            right.offer(queue2[i]);
            rightSum+=queue2[i];
        }
    }
}