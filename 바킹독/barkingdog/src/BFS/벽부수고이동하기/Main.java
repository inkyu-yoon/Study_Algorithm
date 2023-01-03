package BFS.벽부수고이동하기;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // N*M 행렬로 표현되는 맵이 있다. 0은 이동할 수 있는 곳을 나타내고 1은 이동할 수 없는 벽이 있다.
    // (1,1) 에서 (N,M)의 위치까지 이동하려고 하는데, 최단 경로로 이동해야한다.
    // 시작하는 칸과 끝나는 칸의 갯수도 세서, 가장 적은 개수의 칸을 지나도록 해야한다.
    // 벽 1개는 부수는 것이 허용된다.
    static int row;
    static int column;
    static int[][] map;
    static int[][] checked;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int answer = Integer.MAX_VALUE;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        row = Integer.valueOf(input[0]);
        column = Integer.valueOf(input[1]);
        map = new int[row][column];
        checked = new int[row][column];

        for (int i = 0; i < row; i++) {
            String[] info = br.readLine().split("");
            for (int j = 0; j < column; j++) {
                map[i][j] = Integer.valueOf(info[j]);
                checked[i][j] = Integer.MAX_VALUE;
            }
        }
        q.offer(new int[]{0, 0, 1, 0});

        bfs();

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        }


    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0];
            int c = point[1];
            int distance = point[2];
            int isBreak = point[3];

            if (r == row - 1 && c == column - 1) {
                answer = distance;
                System.out.println(answer);
                return;
            }

            for (int i = 0; i <= 3; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if ((0 <= nr && nr < row) && (0 <= nc && nc < column)) {
                    // 공사 한것이 무조건 작을 것
                    if (checked[nr][nc] <= isBreak) {
                        continue;
                    }

                    if (map[nr][nc] == 0) {
                        checked[nr][nc] = isBreak;
                        q.offer(new int[]{nr, nc, distance + 1, isBreak});
                    } else if (map[nr][nc] == 1) {
                        if (isBreak == 0) {
                            checked[nr][nc] = 1;
                            q.offer(new int[]{nr, nc, distance + 1, 1});
                        }
                    }
                }
            }
        }
    }

}
/*
6 4
0100
1110
1000
0000
0111
0000

15

2 6
010001
000110

9
 */
