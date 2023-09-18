package 바킹독.그래프.구슬찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        List<Marble> marbles = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            marbles.add(new Marble(i));
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            Marble big = marbles.get(Integer.parseInt(input[0]) - 1);
            Marble small = marbles.get(Integer.parseInt(input[1]) - 1);

            big.smallMarbles.add(small);
            small.bigMarbles.add(big);
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            Marble marble = marbles.get(i);
            if (getCntOfBigger(marble) >= (N + 1) / 2) {
                ans++;
                continue;
            }

            if (getCntOfSmaller(marble) >= ((N + 1) / 2)) {
                ans++;
            }
        }

        System.out.println(ans);


    }

    private static int getCntOfBigger(Marble node) {
        int cnt = 0;
        Queue<Marble> q = new LinkedList<>();
        boolean[] checked = new boolean[N];
        q.offer(node);
        checked[node.idx] = true;
        while (!q.isEmpty()) {
            Marble poll = q.poll();
            for (Marble bigMarble : poll.bigMarbles) {
                if (!checked[bigMarble.idx]) {
                    q.offer(bigMarble);
                    checked[bigMarble.idx] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static int getCntOfSmaller(Marble node) {
        int cnt = 0;
        Queue<Marble> q = new LinkedList<>();
        boolean[] checked = new boolean[N];
        q.offer(node);
        checked[node.idx] = true;
        while (!q.isEmpty()) {
            Marble poll = q.poll();
            for (Marble smallMarble : poll.smallMarbles) {
                if (!checked[smallMarble.idx]) {
                    q.offer(smallMarble);
                    checked[smallMarble.idx] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static class Marble {
        int idx;

        List<Marble> bigMarbles = new ArrayList<>();
        List<Marble> smallMarbles = new ArrayList<>();

        public Marble(int idx) {
            this.idx = idx;
        }
    }
}
