package 바킹독.스택.오큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Stack<Integer> s = new Stack<>();

        int[] answer = new int[N];
        Arrays.fill(answer, -1);

        //오른쪽의 가장 가까운 큰 수 구하기
        for (int idx = 0; idx < N; idx++) {
            int target = input[idx];
            while (!s.isEmpty() && input[s.peek()] < target) {
                answer[s.pop()] = target;
            }

            s.push(idx);

        }


        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num + " ");
        }
        System.out.println(sb);
    }
}
