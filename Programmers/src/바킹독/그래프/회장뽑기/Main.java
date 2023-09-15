package 바킹독.그래프.회장뽑기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 어느 회원이 다른 모든 회원과 친구이면 점수 1점
// 다른 모든 회원이 친구이거나 친구의 친구인 경우 2점
//
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] g = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], 100000);
        }

        for (int i = 0; i < N; i++) {
            g[i][i] = 0;
        }


        while (true) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1;
            int v = Integer.parseInt(input[1]) - 1;
            if (u == -2) {
                break;
            }
            g[u][v] = 1;
            g[v][u] = 1;

        }

        for (int m = 0; m < N; m++) {
            for (int u = 0; u < N; u++) {
                for (int v = 0; v < N; v++) {
                    g[u][v] = Math.min(g[u][v], g[u][m] + g[m][v]);
                }
            }
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int minScore = Integer.MAX_VALUE;
        for (int r = 0; r < N; r++) {
            int max = Arrays.stream(g[r]).max().getAsInt();
            minScore = Math.min(minScore, max);
            if (!map.containsKey(max)) {
                List<Integer> list = new ArrayList<>();
                list.add(r + 1);
                map.put(max, list);
            } else {
                map.get(max).add(r + 1);
            }
        }
        List<Integer> ans = map.get(minScore);
        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();
        sb.append(minScore + " " + ans.size() + "\n");
        for (Integer an : ans) {
            sb.append(an + " ");
        }

        System.out.println(sb);


    }
}
