package LV2.기능개발;

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<progresses.length;i++){
            double rate = (100-progresses[i])/(double)(speeds[i]);
            q.offer((int)(Math.ceil(rate)));
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int count = 0;
            int previous = q.peek();
            while(previous>=q.peek()){
                q.poll();
                count++;

                if(q.isEmpty()){
                    break;
                }
            }
            ans.add(count);
        }


        return ans.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}