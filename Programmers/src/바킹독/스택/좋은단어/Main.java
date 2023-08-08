package 바킹독.스택.좋은단어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<String> s = new Stack<>();
        int cnt = 0;
        while (N-- > 0) {
            s.clear();
            String[] input = br.readLine().split("");
            for (int i = 0; i < input.length; i++) {
                String target = input[i];
                if (s.isEmpty()) {
                    s.push(target);
                } else {
                    if (s.peek().equals(target)) {
                        s.pop();
                    } else {
                        s.push(target);
                    }
                }
            }

            if (s.isEmpty()) {
                cnt++;
            }

        }
        System.out.println(cnt);
    }
}
