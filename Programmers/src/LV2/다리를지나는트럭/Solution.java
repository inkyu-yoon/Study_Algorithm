package LV2.다리를지나는트럭;

import java.util.*;
class Solution {
    Queue<Integer> q;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        setUp(bridge_length);

        int idx = 0;
        while(true){
            weight+=q.poll();
            if(weight-truck_weights[idx]>=0){
                int truck = truck_weights[idx++];
                weight-=truck;
                q.offer(truck);
            }else{
                q.offer(0);
            }
            answer++;

            if(idx==truck_weights.length){
                break;
            }
        }
        return answer+bridge_length;
    }

    void setUp(int len){
        q = new LinkedList<>();
        while(len-->0){
            q.offer(0);
        }
    }
}