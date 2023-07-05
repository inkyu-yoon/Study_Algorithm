package 바킹독.시뮬레이션.감시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    int R;
    int C;
    int total;
    int[][] map;
    int[][] temp;
    List<Info> list;
    int ans = Integer.MAX_VALUE;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    class Info {
        int r, c, camera, dir;

        public Info(int r, int c, int camera, int dir) {
            this.r = r;
            this.c = c;
            this.camera = camera;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }


    private void solution() throws IOException {
        setUp();
        dfs(0);
        System.out.println(ans);
    }

    private void dfs(int depth) {
        if (depth == total) {
            mark();
            getSafeArea();
            return;
        }
        Info info = list.get(depth);
        int camera = info.camera;
        if (camera == 1 || camera == 3 || camera == 4) {
            info.dir = 0;
            dfs(depth + 1);

            info.dir = 1;
            dfs(depth + 1);

            info.dir = 2;
            dfs(depth + 1);

            info.dir = 3;
            dfs(depth + 1);

        } else if (camera == 2) {
            info.dir = 0;
            dfs(depth + 1);

            info.dir = 1;
            dfs(depth + 1);
        } else if (camera == 5) {
            info.dir = 0;
            dfs(depth + 1);

        }
    }

    private void getSafeArea() {
        int result = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (temp[r][c] == 0) {
                    result++;
                }
            }
        }
        ans = Math.min(ans, result);
    }

    private void mark() {
        deepCopy();
        for (Info info : list) {
            int r = info.r, c = info.c;
            int camera = info.camera, dir = info.dir;
            if (camera == 1) {
                marking(r, c, dir);
            } else if (camera == 2) {
                marking(r, c, dir);
                marking(r, c, (dir + 2) % 4);
            } else if (camera == 3) {
                for (int i = 0; i < 2; i++) {
                    dir = (dir + i) % 4;
                    marking(r, c, dir);
                }
            } else if (camera == 4) {
                for (int i = 0; i < 3; i++) {
                    dir = (dir + i) % 4;
                    marking(r, c, dir);
                }
            } else if (camera == 5) {
                for (int i = 0; i < 4; i++) {
                    dir = (dir + i) % 4;
                    marking(r, c, dir);
                }
            }
        }
    }

    private void marking(int r, int c, int dir) {
        while (0 <= r && r < R && 0 <= c && c < C && map[r][c] != 6) {
            temp[r][c] = 7;
            r += dr[dir];
            c += dc[dir];
        }
    }

    private void deepCopy() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                temp[r][c] = map[r][c];
            }
        }
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        R = input[0];
        C = input[1];
        map = new int[R][C];
        temp = new int[R][C];
        list = new ArrayList<>();
        for (int r = 0; r < R; r++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for (int c = 0; c < C; c++) {
                map[r][c] = input[c];
                if (map[r][c] != 0 && map[r][c] != 6) {
                    list.add(new Info(r, c, map[r][c], 0));
                }
            }
        }
        total = list.size();
    }
}
