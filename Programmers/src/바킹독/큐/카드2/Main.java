package 바킹독.큐.카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        int idx = 0;
        while (q.size() != 1) {
            if (idx == 0) {
                q.poll();
                idx++;
            } else {
                q.offer(q.poll());
                idx--;
            }
        }

        System.out.println(q.peek());
    }
}
