package 바킹독.시뮬레이션.치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static int N;
    static int M;
    static int[][] map;
    static List<int[]> chickens;
    static Stack<Integer> s;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        setUp();
        bt(0);
        System.out.println(ans);
    }

    private static void bt(int start) {
        if (s.size() == M) {
            getChickenDistance();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            if (s.contains(i)) {
                continue;
            }
            s.push(i);
            bt(i + 1);
            s.pop();
        }
    }

    private static void getChickenDistance() {
        int result = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 1) {
                    int dis = Integer.MAX_VALUE;
                    for (Integer idx : s) {
                        int[] chicken = chickens.get(idx);
                        dis = Math.min(dis, Math.abs(r - chicken[0]) + Math.abs(c - chicken[1]));
                    }
                    result += dis;
                }
            }
        }
        ans = Math.min(ans, result);

    }


    private static void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][N];
        chickens = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            input = br.readLine().split(" ");
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(input[c]);
                if (map[r][c] == 2) {
                    chickens.add(new int[]{r, c});
                }
            }
        }

        s = new Stack<>();

    }
}
