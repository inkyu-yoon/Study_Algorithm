package BFS.그림;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 그림의 갯수와 그 그림들 중 최대 넓이 추출

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] check;
    static Queue<int[]> q = new LinkedList<>();

    static int num;
    static int size;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int row = Integer.valueOf(input[0]);
        int column = Integer.valueOf(input[1]);

        map = new int[row][column];
        check = new boolean[row][column];
        for (int r = 0; r < row; r++) {
            String[] data = br.readLine().split(" ");
            for (int c = 0; c < column; c++) {
                map[r][c] = Integer.valueOf(data[c]);
                }
            }

        int max = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (!check[r][c] && map[r][c] == 1) {
                    size = 0;
                    num++;
                    q.offer(new int[]{r, c});
                    check[r][c] = true;
                    bfs();
                    max = Math.max(max, size);
                }
            }
        }

        System.out.println(num);
        System.out.println(max);

    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            size++;

            for (int i = 0; i <= 3; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if ((0 <= nr && nr < map.length) && (0 <= nc && nc < map[0].length) && !check[nr][nc] && map[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc});
                    check[nr][nc] = true;
                }
            }
        }
    }
/*
6 5
1 1 0 1 1
0 1 1 0 0
0 0 0 0 0
1 0 1 1 1
0 0 1 1 1
0 0 1 1 1

4
9
 */

}
