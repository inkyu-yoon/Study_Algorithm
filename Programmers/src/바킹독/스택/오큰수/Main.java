package 바킹독.스택.오큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

// Aj의 오큰수 = Aj의 오른쪽에 있으면서 Aj 보다 큰 수 중에서 가장 왼쪽에 있는 수
// 없는 경우 -1
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Stack<Integer> stack = new Stack<>();

        int[] answer = new int[N];
        Arrays.fill(answer, -1);

        for (int i = 0; i < N; i++) {
            int num = input[i];
            while (!stack.isEmpty() && input[stack.peek()] < num) {
                answer[stack.pop()] = num;
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);

    }
}
