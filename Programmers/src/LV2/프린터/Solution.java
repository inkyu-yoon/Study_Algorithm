package LV2.프린터;

import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> printer = new LinkedList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<priorities.length;i++){
            int priority = priorities[i];
            printer.offer(new int[]{priority,i});
            q.offer(priority);
        }
        int answer = 0;

        while(true){
            int[] info = printer.poll();
            int priority = info[0];
            int idx = info[1];

            if(priority==q.peek()){
                q.poll();
                answer++;
                if(idx==location){
                    break;
                }
            }else{
                printer.offer(new int[]{priority,idx});
            }
        }

        return answer;
    }
}