package 바킹독.스택.제로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                s.pop();
            } else {
                s.push(n);
            }
        }
        int ans = 0;
        for (Integer n : s) {
            ans += n;
        }
        System.out.println(ans);
    }
}
