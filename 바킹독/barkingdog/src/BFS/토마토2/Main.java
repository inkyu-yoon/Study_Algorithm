package BFS.토마토2;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    //토마토 문제인데, 3 차원임
    // 가로칸의 수(column) 세로칸의 수(row) 높이 H 가 주어진다.
    static int row;
    static int column;
    static int floor;
    static int[] dr = {1, -1, 0, 0, 0, 0};
    static int[] dc = {0, 0, 1, -1, 0, 0};
    static int[] df = {0, 0, 0, 0, 1, -1};
    static int[][][] map;
    static int[][][] day;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] point = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.valueOf(s)).toArray();

        column = point[0];
        row = point[1];
        floor = point[2];

        map = new int[floor][row][column];
        day = new int[floor][row][column];


        for (int f = 0; f < floor; f++) {
            int[][] tomatoMap = new int[row][column];
            int[][] tomatoDay = new int[row][column];

            for (int r = 0; r < row; r++) {
                int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.valueOf(s)).toArray();
                for (int c = 0; c < column; c++) {
                    tomatoMap[r][c] = info[c];
                    if (info[c] == 1) {
                        q.offer(new int[]{r, c, f});
                    }
                }
            }
            map[f] = tomatoMap;
            day[f] = tomatoDay;
        }

        bfs();

        System.out.println(Arrays.deepToString(day[0]));
        System.out.println(Arrays.deepToString(day[1]));

    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();

            int r = point[0];
            int c = point[1];
            int f = point[2];

            for (int i = 0; i <= 5; i++) {
                int nf = f + df[i];
                int nr = r + dr[i];
                int nc = c + dc[i];
                if ((0 <= nr && nr < row) && (0 <= nc && nc < column) && (0 <= nf && nf < floor)) {
                    if (map[nf][nr][nc] == 0) {
                        map[nf][nr][nc] = 1;
                        day[nf][nr][nc] = day[f][r][c] + 1;
                        q.offer(new int[]{nr, nc,nf});
                    }

                }
            }
        }

    }
}
/*
5 3 1
0 -1 0 0 0
-1 -1 0 1 1
0 0 0 1 1

-1
 */
