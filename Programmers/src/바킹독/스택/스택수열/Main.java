package 바킹독.스택.스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        boolean flag = false;
        int num = 1;
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int input = Integer.parseInt(br.readLine());
            while (num <= input) {
                s.push(num++);
                sb.append("+\n");
            }
            if (s.peek() == input) {
                s.pop();
                sb.append("-\n");
            } else {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
