package 바킹독.스택.오큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] ans = new int[N];
        Arrays.fill(ans, -1);

        Stack<Integer> s = new Stack<>();

        s.push(0);

        for (int i = 1; i < N; i++) {
            int n = arr[i];
            while (!s.isEmpty() && arr[s.peek()] < n) {
                int idx = s.pop();
                ans[idx] = n;
            }

            s.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int num : ans) {
            sb.append(num + " ");
        }
        System.out.println(sb);
    }
}
