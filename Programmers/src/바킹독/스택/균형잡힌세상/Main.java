package 바킹독.스택.균형잡힌세상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<>();
        while (true) {
            s.clear();
            boolean isBalance = true;
            char[] arr = br.readLine().toCharArray();

            if (arr[0] == '.') {
                break;
            }

            for (char c : arr) {
                if (c == '(' || c == '[') {
                    s.push(c);
                } else if (c == ')') {
                    if (s.isEmpty() || (!s.isEmpty() && s.peek() == '[')) {
                        isBalance = false;
                        break;
                    } else {
                        s.pop();
                    }
                } else if (c == ']') {
                    if (s.isEmpty() || (!s.isEmpty() && s.peek() == '(')) {
                        isBalance = false;
                        break;
                    } else {
                        s.pop();
                    }
                }

            }

            if (isBalance && s.size() == 0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
