package 바킹독.bfs.나이트의이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    int N;
    int[] now;
    int[] goal;
    boolean[][] checked;
    int[][] map;
    int[] dr = {1, 1, 2, 2, -1, -1, -2, -2};
    int[] dc = {2, -2, 1, -1, 2, -2, 1, -1};
    Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            goal = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            getAns();
            System.out.println(map[goal[0]][goal[1]]);
        }
    }

    private void getAns() {
        checked = new boolean[N][N];
        map = new int[N][N];

        q.offer(now);
        checked[now[0]][now[1]] = true;
        map[now[0]][now[1]] = 0;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0], c = point[1];
            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < N && 0 <= nc && nc < N && !checked[nr][nc]) {
                    q.offer(new int[]{nr, nc});
                    checked[nr][nc] = true;
                    map[nr][nc] = map[r][c] + 1;
                }
            }
        }


    }
}
