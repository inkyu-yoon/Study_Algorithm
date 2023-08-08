package 바킹독.스택.쇠막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        Stack<String> s = new Stack<>();
        int ans = 0;
        for (int i = 0; i < input.length; i++) {
            String target = input[i];
            if (s.isEmpty()) {
                s.push(target);
            } else {
                if (target.equals("(")) {
                    s.push(target);
                } else {
                    s.pop();
                    if (input[i - 1].equals("(")) {
                        ans += s.size();
                    } else {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
