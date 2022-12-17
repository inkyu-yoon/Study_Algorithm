package 스택.스택수열;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
    // 스택에 push하는 순서는 반드시 오름차순
    // 임의의 수열이 주어졌을 때,
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int min = 0;
        //
        while (N-- > 0) {
            int input = Integer.valueOf(br.readLine());
            if (input > min) {
                for (int i = min + 1; i <= input; i++) {
                    stack.push(i);
                    sb.append("+\n");
                }
                min = input;
            } else if (input != stack.peek()) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-\n");
        }
        System.out.println(sb);

        /*
        1
        1 2
        1 2 3
        1 2 3 4
        4 출력
        3 출력
        1 2 5 6
        6 출력
        1 2 5 7
        1 2 5 7 8
        8 출력
        7 출력
        5 출력
        2 출력
        1 출력
         */

    }
}
