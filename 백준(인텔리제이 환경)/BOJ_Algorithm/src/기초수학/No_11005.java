package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_11005 {
    public static void main(String[] args) throws IOException {
        //10진수 입력받으면 B진수로 전환
        //B가 주어진다. (2 ≤ B ≤ 36)
        //A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
        //60466175 36 > ZZZZZ


        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int B = Integer.valueOf(input[1]);
        String result = "";
        do {
            stack.push(N % B);
            N/=B;
        } while (N / B != 0);
        if (N != 0) {
        stack.push(N);
        }

        while (!stack.isEmpty()) {
            if (stack.peek() > 9) {
                sb.append((char)(stack.pop()-10+'A'));
            } else {
            sb.append(stack.pop());
            }
        }
        System.out.println(sb);
    }
}
