package 스택의활용.괄호;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 괄호가 쌍으로 잘 닫혀있어야 한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.valueOf(br.readLine());
        while (N-- > 0) {
            Stack<String> stack = new Stack<>();
            String[] input = br.readLine().split("");
            boolean isError = false;
            for (int i = 0; i < input.length; i++) {
                if (stack.isEmpty()) {
                    if (input[i].equals(")")) {
                        sb.append("NO\n");
                        isError = true;
                        break;
                    } else {
                        stack.push(input[i]);
                    }
                } else {
                    if (input[i].equals("(")) {
                        stack.push(input[i]);

                    } else {
                        if (stack.peek().equals("(")) {
                            stack.pop();
                        } else {
                            stack.push(input[i]);
                        }
                    }

                }
            }
            if (!isError) {
                if (stack.size() == 0) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);

    }
}