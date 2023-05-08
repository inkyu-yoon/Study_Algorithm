package LV3.디스크컨트롤러;
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> disk = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int [] job : jobs){
            disk.offer(job);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

        int answer = 0, time = 0;

        while(!disk.isEmpty()){
            while(!disk.isEmpty() && disk.peek()[0]<=time){
                pq.offer(disk.poll());
            }

            if(!pq.isEmpty()){
                int [] info = pq.poll();
                answer+=time-info[0]+info[1];
                time += info[1];
            }else{
                int [] info = disk.peek();
                time = info[0];
            }
            while(!pq.isEmpty()){
                disk.offer(pq.poll());
            }
        }

        return (int)Math.floor(answer/jobs.length);
    }
}