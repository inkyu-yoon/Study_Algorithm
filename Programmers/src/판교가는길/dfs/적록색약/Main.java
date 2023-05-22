package 판교가는길.dfs.적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class Main {
    int N;
    String[][] map;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    Stack<int[]> s;


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    // 적록 색약은 R와 G를 구별하지 못함
    void solution() throws IOException {
        setUp();
        int cnt1 = 0;
        int cnt2 = 0;
        boolean[][] checked1 = new boolean[N][N];
        boolean[][] checked2 = new boolean[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!checked1[r][c]) {
                    dfs(false, map[r][c],checked1, r, c);
                    cnt1++;
                }
                if (!checked2[r][c]) {
                    dfs(true, map[r][c],checked2, r, c);
                    cnt2++;
                }
            }
        }

        System.out.println(cnt1+" "+cnt2);
    }

    void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j];
            }
        }

        s = new Stack<>();
    }

    void dfs(boolean isColorWeakness, String target, boolean[][] checked, int startR, int startC) {
        s.push(new int[]{startR, startC});
        checked[startR][startC] = true;

        while (!s.isEmpty()) {
            int[] p = s.pop();
            int r = p[0], c = p[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < N && 0 <= nc && nc < N && !checked[nr][nc]) {
                    if (isColorWeakness) {
                        if (target.equals("R") || target.equals("G")) {
                            if (map[nr][nc].equals("R") || map[nr][nc].equals("G")) {
                                s.push(new int[]{nr, nc});
                                checked[nr][nc] = true;
                            }
                        } else {
                            if (map[nr][nc].equals("B")) {
                                s.push(new int[]{nr, nc});
                                checked[nr][nc] = true;
                            }
                        }
                    } else {
                        if (map[nr][nc].equals(target)) {
                            s.push(new int[]{nr, nc});
                            checked[nr][nc] = true;
                        }
                    }
                }
            }
        }
    }
}
