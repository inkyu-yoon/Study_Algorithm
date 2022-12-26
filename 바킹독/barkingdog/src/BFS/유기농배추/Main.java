package BFS.유기농배추;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 1끼리 인접한 부분을 찾는 문제
    // 각 테스트 케이스마다 필요한 지렁이 수 찾는 문제
    static int[][] map;
    static int row;
    static int column;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.valueOf(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            column = Integer.valueOf(input[0]);
            row = Integer.valueOf(input[1]);
            map = new int[row][column];
            int num = Integer.valueOf(input[2]);

            for (int i = 1; i <= num; i++) {
                String[] point = br.readLine().split(" ");
                map[Integer.valueOf(point[1])][Integer.valueOf(point[0])] = 1;
            }


            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (map[i][j] == 1) {
                        q.offer(new int[]{i, j});
                        map[i][j]=0;
                    bfs();
                    count++;
                    }
                }
            }

            sb.append(count + "\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0];
            int c = point[1];
            for (int i = 0; i <= 3; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if ((0 <= nr && nr < row) && (0 <= nc && nc < column) && map[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc});
                    map[nr][nc] = 0;
                }
            }
        }
    }
}
/*
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5

5
1
 */