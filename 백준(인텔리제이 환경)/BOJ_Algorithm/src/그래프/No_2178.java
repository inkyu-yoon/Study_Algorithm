package 그래프;

import java.util.*;
import java.io.*;


public class No_2178 {
    static int row, column;
    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        row = Integer.valueOf(input[0]);
        column = Integer.valueOf(input[1]);
        map = new int[row + 2][column + 2];
        for (int i = 1; i <= row; i++) {
            char[] input2 = br.readLine().toCharArray();
            for (int j = 1; j <= column; j++) {
                map[i][j] = input2[j - 1] - '0';
            }
        }
        //(1,1) 에서 (n,m) 으로 가야함
        q.add(new int[]{1, 1});
        //bfs 사용하면 될 듯
        bfs();

            System.out.println(map[row][column]);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = point[0] + dx[k];
                int ny = point[1] + dy[k];
                if (map[nx][ny] == 1) {
                    map[nx][ny] = map[point[0]][point[1]] + 1;

                    q.add(new int[]{nx, ny});
                }
            }
        }

    }

}
/* 예제 입력
4 6
101111
101010
101011
111011
 */
// 15