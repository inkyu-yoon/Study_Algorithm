package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_11576 {
    public static void main(String[] args) throws IOException {
        //A진법을 B진법으로 변환하는 알고리즘
        //A와 B는 2이상 30이하 자연수
        //주어지는 수는 0이상 A미만
        //개수 m개
        // m개의 A진법 수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        int A = Integer.valueOf(input[0]);
        int B = Integer.valueOf(input[1]);
        int m = Integer.valueOf(br.readLine());
        String[] input2 = br.readLine().split(" ");
        int num = 0;
        for (int i = m - 1; i >= 0; i--) {
            num += Integer.valueOf(input2[m - 1 - i]) * Math.pow(A, i);

        }
        if (num == 0) {
            stack.push(0);
        }
        while (num != 0) {
            stack.push(num % B);
            num /= B;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }

    }
}
