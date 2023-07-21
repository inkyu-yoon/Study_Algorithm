package 바킹독.스택.옥상정원꾸미기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Building> stack = new Stack<>();
        long cnt = 0;
        for (int i = 0; i <= N; i++) {
            int h;
            if (i == N) {
                h =  1000000001;
            } else {
                h = Integer.parseInt(br.readLine());
            }
            Building b = new Building(i, h);
            if (stack.isEmpty()) {
                stack.push(b);
            } else {
                while (!stack.isEmpty() && stack.peek().h <= h) {
                    Building removed = stack.pop();
                    cnt += i - removed.idx - 1;
                }
                stack.push(b);
            }
        }

        System.out.println(cnt);

    }

    static class Building {
        int idx;
        int h;

        public Building(int idx, int h) {
            this.idx = idx;
            this.h = h;
        }
    }
}
