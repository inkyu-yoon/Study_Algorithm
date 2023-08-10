package 바킹독.스택.괄호의값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        Stack<String> s = new Stack<>();
        int score = 0;
        int small = 0;
        int large = 0;
        for (int i = 0; i < split.length; i++) {
            String target = split[i];
            if (s.isEmpty()) {
                if (target.equals("(")) {
                    s.push(target);
                    small++;
                } else if (target.equals("[")) {
                    s.push(target);
                    large++;
                } else {
                    System.out.println(0);
                    return;
                }
            } else {
                if (target.equals("(")) {
                    s.push(target);
                    small++;
                } else if (target.equals("[")) {
                    s.push(target);
                    large++;
                } else if (target.equals(")")) {
                    if (split[i - 1].equals("(")) {
                        score += Math.pow(2, small) * Math.pow(3, large);
                        small--;
                    } else if (split[i - 1].equals("[")) {
                        System.out.println(0);
                        return;
                    } else {
                        small--;
                    }
                } else if (target.equals("]")) {
                    if (split[i - 1].equals("[")) {
                        score += Math.pow(2, small) * Math.pow(3, large);
                        large--;
                    } else if (split[i - 1].equals("(")) {
                        System.out.println(0);
                        return;
                    } else {
                        large--;
                    }
                }
            }
        }
        if (small != 0 || large != 0) {
            System.out.println(0);
        } else {
            System.out.println(score);
        }
    }
}
