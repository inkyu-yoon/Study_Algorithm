package 바킹독.시뮬레이션.트럭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        // n : 트럭 수 , w : 다리 길이 , L : 다리 최대 하중
        int n = input[0], w = input[1], L = input[2];

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();

        while (bridge.size() != w) {
            bridge.offer(0);
        }

        for (int truck : input) {
            trucks.offer(truck);
        }

        int sum = 0;
        int time = 0;
        while (!trucks.isEmpty()) {
            sum -= bridge.poll();
            time++;

            if (sum + trucks.peek() <= L) {
                int truck = trucks.poll();
                bridge.offer(truck);
                sum += truck;
            } else {
                bridge.offer(0);
            }
        }
        System.out.println(time+w);

    }
}
