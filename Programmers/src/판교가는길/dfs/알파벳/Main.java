package 판교가는길.dfs.알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class Main {
    int R;
    int C;
    Set<String> set = new HashSet<>();

    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    String[][] map;
    int ans = 0;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        setUp();
        set.add(map[0][0]);
        bt(0, 0, 1);
        System.out.println(ans);

    }

    void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        R = info[0];
        C = info[1];
        map = new String[R][C];

        for (int r = 0; r < R; r++) {
            String[] input = br.readLine().split("");
            for (int c = 0; c < C; c++) {
                map[r][c] = input[c];
            }
        }
    }

    void bt(int startR, int startC, int d) {

        ans = Math.max(ans, d);

        for (int i = 0; i < 4; i++) {
            int nr = startR + dr[i], nc = startC + dc[i];
            if (0 <= nr && nr < R && 0 <= nc && nc < C && !set.contains(map[nr][nc])) {
                set.add(map[nr][nc]);
                bt(nr, nc, d + 1);
                set.remove(map[nr][nc]);
            }
        }
    }
}
