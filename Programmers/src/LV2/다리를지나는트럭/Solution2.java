package LV2.다리를지나는트럭;

import java.util.*;

class Solution2 {
    Queue<Integer> bridge = new LinkedList<>();
    Queue<Integer> trucks = new LinkedList<>();

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        for (int i = 0; i < truck_weights.length; i++) {
            trucks.offer(truck_weights[i]);
        }

        int totalWeight = 0;

        while (!trucks.isEmpty()) {
            totalWeight -= bridge.poll();
            if (totalWeight + trucks.peek() <= weight) {
                totalWeight += trucks.peek();
                bridge.offer(trucks.poll());
            } else {
                bridge.offer(0);
            }
            answer++;
        }

        answer += bridge.size();

        return answer;
    }
}