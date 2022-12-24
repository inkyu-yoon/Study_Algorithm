package BFS.미로탐색;
import java.io.*;
import java.util.*;

public class Main {
    // 미로 탐색
    // (1,1) 에서 출발하여 (N,M) 위치로 이동할때 지나야 하는 최소의 칸 수를 구하시오
    static int N;
    static int M;
    static int[][] map;
    static int[][] distance;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);

        map = new int[N][M];
        distance = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.valueOf(info[j]);
            }
        }

        distance[0][0]=1;
        q.offer(new int[]{0, 0});
        bfs();
        System.out.println(distance[N - 1][M - 1]);
    }
    static void bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();

            int row = point[0];
            int col = point[1];
            for (int i = 0; i <= 3; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if ((0 <= nr && nr < N) && (0 <= nc && nc < M) && map[nr][nc] == 1 && distance[nr][nc]==0) {
                    distance[nr][nc] = distance[row][col]+1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
    /*
4 6
101111
101010
101011
111011

15
     */
}
