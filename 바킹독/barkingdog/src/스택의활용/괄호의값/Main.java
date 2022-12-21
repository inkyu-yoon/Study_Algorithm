package 스택의활용.괄호의값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //() [] 올바른 괄호열
    // (     ) [    ]  괄호 안 쪽도 올바른 괄호열이여야 한다.
    // () 괄호의 값 2
    // [] 괄호의 값 3
    // (x) 는 x값 * 2 -> (()) 는 2*2 = 4점
    // [x] 는 x값 * 3
    // ( ( ) [ [ ] ] ) ( [ ] ) 의 괄호 값은?
    // 2*(2+3*3)+2*3 = 28 이 된다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        Stack<String> s = new Stack<>();
        int score = 0;
        int small = 0;
        int large = 0;
        for (int i = 0; i < input.length; i++) {
            if (s.isEmpty()) {
                if (input[i].equals(")") || input[i].equals("]")) {
                    System.out.println(0);
                    return;
                } else {
                    if (input[i].equals("(")) {
                        s.push(input[i]);
                        small++;
                    } else if (input[i].equals("[")) {
                        s.push(input[i]);
                        large++;
                    }
                }
            } else if (!s.isEmpty()) {
                if (input[i].equals("(")) {
                    s.push(input[i]);
                    small++;
                } else if (input[i].equals("[")) {
                    s.push(input[i]);
                    large++;
                } else if (input[i].equals(")")) {
                    if (input[i - 1].equals("(")) {
                        small--;
                        score += 2 * Math.pow(2, small) * Math.pow(3, large);
                    } else if (input[i - 1].equals("[")) {
                        System.out.println(0);
                        return;
                    } else {
                        small--;
                    }

                } else if (input[i].equals("]")) {
                    if (input[i - 1].equals("[")) {
                        large--;
                        score += 3 * Math.pow(2, small) * Math.pow(3, large);
                    } else if (input[i - 1].equals("(")) {
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
            return;
        }
        System.out.println(score);
    }
/*
(()[[]])([])

28
 */
}
