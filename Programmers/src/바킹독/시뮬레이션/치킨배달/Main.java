package 바킹독.시뮬레이션.치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    int[][] map;
    int N; int M;
    List<int[]> chickens;
    List<int[]> houses;
    Stack<Integer> s;
    int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    //치킨 집 중 m개만 살림
    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        s = new Stack<>();
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        N = info[0];
        M = info[1];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for (int j = 0; j < N; j++) {
                if (input[j] == 1) {
                    houses.add(new int[]{i, j});
                } else if(input[j]==2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        bt();

        System.out.println(ans);

    }

    void bt() {
        if (s.size() == M) {
            getChickenDistance();
            return;
        }
        for (int i = 0; i < chickens.size(); i++) {
            if (s.contains(i) || (!s.isEmpty() && s.peek() > i)) {
                continue;
            }
            s.push(i);
            bt();
            s.pop();
        }
    }

    void getChickenDistance() {
        int total = 0;
        for (int[] house : houses) {
            int r = house[0], c = house[1];
            int minDistance = Integer.MAX_VALUE;
            for (int idx : s) {
                int[] chicken = chickens.get(idx);
                int cr = chicken[0], cc = chicken[1];
                minDistance = Math.min(Math.abs(r - cr) + Math.abs(c - cc), minDistance);
            }
            total += minDistance;
        }
        ans = Math.min(ans, total);

    }


}