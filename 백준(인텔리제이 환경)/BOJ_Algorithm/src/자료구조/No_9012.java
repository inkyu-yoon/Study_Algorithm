package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_9012 {
    public static void main(String[] args) throws IOException {
        //괄호의 갯수가 짝이 맞는 가? && ) 가 먼저 들어오지 않는가?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (isVPS(br.readLine())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean isVPS(String input) {
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                result++;
            } else if (input.charAt(i) == ')') {
                result--;
            }
            if (result == -1) {
                return false;
            }
        }
        return result == 0;
    }
}
