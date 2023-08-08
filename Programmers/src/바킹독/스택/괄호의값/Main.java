package 바킹독.스택.괄호의값;

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
        int small = 0;
        int large = 0;
        for (int i = 0; i < input.length; i++) {
            String target = input[i];
            if (s.isEmpty()) {
                if (target.equals(")") || target.equals("]")) {
                    System.out.println(0);
                    return;
                } else if (target.equals("(")) {
                    small++;
                } else if (target.equals("[")) {
                    large++;
                }
                s.push(target);
            } else {
                if (target.equals("(")) {
                    small++;
                    s.push(target);
                } else if (target.equals("[")) {
                    large++;
                    s.push(target);
                } else if (target.equals(")")) {
                    if (input[i - 1].equals("(")) {
                        ans += Math.pow(2, small) * Math.pow(3, large);
                        small--;
                    } else if (input[i - 1].equals("[")) {
                        System.out.println(0);
                        return;
                    } else {
                        small--;
                    }
                } else if (target.equals("]")) {
                    if (input[i - 1].equals("[")) {
                        ans += Math.pow(2, small) * Math.pow(3, large);
                        large--;
                    } else if (input[i - 1].equals("(")) {
                        System.out.println(0);
                        return;
                    } else {
                        large--;
                    }
                }
            }
        }

        System.out.println(ans);

    }
}
