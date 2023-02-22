package 스택큐.다리를지나는트럭;

import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> truck = new LinkedList<>();

        for(int i=0;i<truck_weights.length;i++){
            truck.offer(truck_weights[i]);
        }

        for(int i=0;i<bridge_length;i++){
            bridge.offer(0);
        }

        // 첫번째 차 출발
        int totalWeight = 0;
        int totalTruckNum = 0;
        int time = 0;

        while(!bridge.isEmpty()){

            if(truck.isEmpty()){
                break;
            }
            //트럭이 내릴 차례인 경우
            if(bridge.peek()!=0){
                totalWeight-=bridge.poll();
                totalTruckNum--;
            }else{
                bridge.poll();
            }

            int waitingTruck = truck.peek();
            //차가 더 올라올 수 있는 경우 (다리에 공간이 있으면서 무게가 초과되지 않을 때)
            if((bridge_length>=totalTruckNum)&&(weight>=totalWeight+waitingTruck)){
                bridge.offer(truck.poll());
                totalWeight+=waitingTruck;
                totalTruckNum++;
                //차가 더 못올라오는 경우
            }else{
                bridge.offer(0);
            }
            time++;
        }

        time+=bridge_length;

        return time;
    }
}