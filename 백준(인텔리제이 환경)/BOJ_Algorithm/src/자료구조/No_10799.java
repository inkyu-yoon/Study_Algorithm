package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push('(');
            }

            if (input.charAt(i) == ')') {
                if (input.charAt(i - 1) == '(') {
                    stack.pop();
                    result += stack.size();
                } else {
                    stack.pop();
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}
