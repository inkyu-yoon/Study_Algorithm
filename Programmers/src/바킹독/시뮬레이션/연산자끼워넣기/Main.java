package 바킹독.시뮬레이션.연산자끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static int N;
    static int[] nums;
    static int[] ops;
    static Stack<Integer> cases;
    static int total;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        cases = new Stack<>();
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        for (int i = 0; i < N; i++) {
            nums[i] = input[i];
        }
        ops = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        total = Arrays.stream(ops).sum();
        bt();

        System.out.println(max);
        System.out.println(min);

    }

    private static void bt() {
        if (cases.size() == total) {
            calculate();
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] == 0) {
                continue;
            }
            cases.push(i);
            ops[i]--;
            bt();
            ops[i]++;
            cases.pop();
        }

    }

    private static void calculate() {
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            switch (cases.get(i - 1)) {
                case 0:
                    result += nums[i];
                    break;
                case 1:
                    result -= nums[i];
                    break;
                case 2:
                    result *= nums[i];
                    break;
                case 3:
                    result /= nums[i];
                    break;
            }
        }
        max = Math.max(max, result);
        min = Math.min(min, result);
    }
}
