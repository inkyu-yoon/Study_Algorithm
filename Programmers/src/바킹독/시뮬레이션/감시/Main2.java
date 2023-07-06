package 바킹독.시뮬레이션.감시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main2 {
    static int R;
    static int C;
    static int[][] map;
    static int[][] copiedMap;
    static int total;
    static List<Cctv> list;
    static Stack<Integer> cases;
    static boolean[] checked;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new int[R][C];
        copiedMap = new int[R][C];
        list = new ArrayList<>();
        cases = new Stack<>();
        for (int r = 0; r < R; r++) {
            input = br.readLine().split(" ");
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(input[c]);
                if (map[r][c] != 0 && map[r][c] != 6) {
                    list.add(new Cctv(r, c, map[r][c]));
                }
            }
        }

        total = list.size();
        bt();
        System.out.println(ans);
    }

    private static void bt() {
        if (cases.size() == total) {
            marking();
            ans = Math.min(ans,getNum());
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            cases.add(dir);
            bt();
            cases.pop();
        }

    }

    private static int getNum() {
        int result = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (copiedMap[r][c] == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    private static void marking() {
        deepCopy();
        for (int idx = 0; idx < list.size(); idx++) {
            Cctv cctv = list.get(idx);
            int dir = cases.get(idx);

            switch (cctv.type) {
                case 1:
                    mark(cctv, dir);
                    break;
                case 2:
                    mark(cctv, dir);
                    mark(cctv, (dir+2)%4);
                    break;
                case 3:
                    mark(cctv, dir);
                    mark(cctv, (dir+1)%4);
                    break;
                case 4:
                    mark(cctv, dir);
                    mark(cctv, (dir+1)%4);
                    mark(cctv, (dir+2)%4);
                    break;
                case 5:
                    mark(cctv, dir);
                    mark(cctv, (dir+1)%4);
                    mark(cctv, (dir+2)%4);
                    mark(cctv, (dir+3)%4);
                    break;
            }
        }
    }

    private static void deepCopy() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                copiedMap[r][c] = map[r][c];
            }
        }
    }

    private static void mark(Cctv cctv, int dir) {
        int r = cctv.r;
        int c = cctv.c;
        while (0 <= r && r < R && 0 <= c && c < C && map[r][c] != 6) {
            copiedMap[r][c] = 7;
            r += dr[dir];
            c += dc[dir];
        }
    }


    static class Cctv {
        int r, c, type;

        public Cctv(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }
}
