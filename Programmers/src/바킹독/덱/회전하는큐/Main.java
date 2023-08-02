package 바킹독.덱.회전하는큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int N = input[0], M = input[1];

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }

        int cnt = 0;
        for (int target : input) {
            int dir = getDir(target,dq);
            // 왼쪽
            if (dir == 0) {
                while (true) {
                    Integer poll = dq.poll();
                    if (poll == target) {
                        break;
                    } else {
                        dq.offer(poll);
                        cnt++;
                    }
                }
            } else {
                while (true) {
                    Integer peek = dq.peek();
                    if (peek == target) {
                        dq.poll();
                        break;
                    } else {
                        dq.offerFirst(dq.pollLast());
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);

    }

    private static int getDir(int target, Deque<Integer> dq) {
        int idx = 0;
        for (int element : dq) {
            if (element == target) {
                break;
            }
            idx++;
        }

        return idx <= dq.size() / 2 ? 0 : 1;
    }
}
