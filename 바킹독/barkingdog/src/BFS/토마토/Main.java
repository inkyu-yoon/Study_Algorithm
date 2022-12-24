package BFS.토마토;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 익지않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
    // 며칠이 지나면 모든 토마토들이 익게 되는지 최소 일수를 구하여라
    // 0은 익지 않은 토마토, 1은 익은 토마토, -1은 토마토가 들어있지 않다.
    // 토마토가 모두 익지 못하는 상황이면 -1, 처음부터 모두 익어 있다면 0
    static int row;
    static int column;
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        row = Integer.valueOf(input[1]);
        column = Integer.valueOf(input[0]);

        map = new int[row][column];

        for (int i = 0; i < row; i++) {
            String[] info = br.readLine().split(" ");
            for (int j = 0; j < column; j++) {
                map[i][j] = Integer.valueOf(info[j]);
                if (map[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {

        while (!q.isEmpty()) {
            int[] point = q.poll();

            int r = point[0];
            int c = point[1];

            for (int i = 0; i <= 3; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if ((0 <= nr && nr < row) && (0 <= nc && nc < column) && map[nr][nc] == 0 ) {
                    map[nr][nc] = map[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, map[i][j]);
            }
        }
        if (max == 1) {
            return 0;
        }else{
            return max - 1;
        }

    }

    /*
6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1

8
     */
}
