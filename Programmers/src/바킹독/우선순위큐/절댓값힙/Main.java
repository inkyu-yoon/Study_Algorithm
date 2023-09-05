package 바킹독.우선순위큐.절댓값힙;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int result = Math.abs(a) - Math.abs(b);
            if (result == 0) {
                return a - b;
            } else {
                return result;
            }
        });

        StringBuilder ans = new StringBuilder();

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.add(x);
            } else {
                if (pq.isEmpty()) {
                    ans.append(0 + "\n");
                } else {
                    ans.append(pq.poll() + "\n");
                }
            }
        }

        System.out.println(ans);
    }
}
