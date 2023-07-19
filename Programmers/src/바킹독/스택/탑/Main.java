package 바킹독.스택.탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Stack<Tower> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(input[i]);
            if (stack.isEmpty()) {
                stack.push(new Tower(i + 1, h));
                sb.append(0 + " ");
            } else {
                while(!stack.isEmpty() && stack.peek().height < h){
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    sb.append(stack.peek().idx + " ");
                } else {
                    sb.append(0 + " ");
                }

                stack.push(new Tower(i + 1, h));
            }
        }
        System.out.println(sb);
    }
    static class Tower{
        int idx;
        int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}
