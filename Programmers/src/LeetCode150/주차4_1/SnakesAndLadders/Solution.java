package LeetCode150.주차4_1.SnakesAndLadders;

import java.util.*;

class Solution {
    int N;
    int[] map;

    public int snakesAndLadders(int[][] board) {
        N = board.length;
        int end = N * N, result = 0;
        map = new int[end];
        getMap(board);
        boolean[] checked = new boolean[end];

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});
        checked[0] = true;

        while (!q.isEmpty()) {
            int[] info = q.poll();
            int idx = info[0], cnt = info[1];

            for (int i = 1; i <= 6; i++) {
                int next = idx + i;
                if (next >= end - 1) {
                    return cnt + 1;
                } else {
                    if (map[next] != -1) {

                        if (map[next] == end - 1) {
                            return cnt + 1;
                        }
                        if (!checked[map[next]]) {
                            q.offer(new int[]{map[next], cnt + 1});
                            checked[map[next]] = true;
                        }

                    } else {
                        if (!checked[next]) {
                            q.offer(new int[]{next, cnt + 1});
                            checked[next] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private void getMap(int[][] board) {
        boolean flag = true;

        int idx = 0;

        for (int r = N - 1; r >= 0; r--) {
            if (flag) {
                for (int c = 0; c <= N - 1; c++) {
                    map[idx++] = board[r][c] == -1 ? -1 : board[r][c] - 1;
                    flag = false;
                }
            } else {
                for (int c = N - 1; c >= 0; c--) {
                    map[idx++] = board[r][c] == -1 ? -1 : board[r][c] - 1;
                    flag = true;
                }
            }
        }

    }

}