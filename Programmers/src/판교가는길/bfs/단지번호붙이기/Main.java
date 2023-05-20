package 판교가는길.bfs.단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    int[][] map;
    boolean[][] checked;
    Queue<int []> q;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    int N;
    List<Integer> ans = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        setUp();

        int cnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 1 && !checked[r][c]) {
                    q.offer(new int[]{r, c});
                    checked[r][c] = true;
                    bfs();
                    cnt++;
                }
            }
        }
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        sb.append(cnt + "\n");
        for (Integer an : ans) {
            sb.append(an + "\n");
        }
        System.out.println(sb);

    }


    void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        checked = new boolean[N][N];
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j];
            }
        }
    }


    void bfs() {
        int count = 1;
        while (!q.isEmpty()) {
            int[] point = q.poll();

            int r = point[0], c = point[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (0 <= nr && nr < N && 0 <= nc && nc < N && !checked[nr][nc] && map[nr][nc]==1) {
                    q.offer(new int[]{nr, nc});
                    checked[nr][nc] = true;
                    count++;
                }
            }
        }
        ans.add(count);
    }
}
