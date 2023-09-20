package 바킹독.그래프.거짓말;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static final int MAX = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // 지민이 번호는 0 으로 가정
        int[][] graph = new int[N + 1][N + 1];

        for (int r = 0; r < N + 1; r++) {
            for (int c = 0; c < N + 1; c++) {
                if (r != c) {
                    graph[r][c] = MAX;
                }
            }
        }

        List<List<Integer>> parties = new ArrayList<>();

        input = br.readLine().split(" ");
        int numOfKnow = Integer.parseInt(input[0]);

        // 진실을 아는 사람은 지민이 번호 (0) 과 연결
        for (int i = 1; i <= numOfKnow; i++) {
            graph[0][Integer.parseInt(input[i])] = 1;
            graph[Integer.parseInt(input[i])][0] = 1;
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            List<Integer> party = new ArrayList<>();

            int numOfPeople = Integer.parseInt(input[0]);

            // 같은 파티에 참석하는 사람들끼리 연결
            for (int j = 1; j <= numOfPeople; j++) {
                party.add(Integer.parseInt(input[j]));
                for (int k = j + 1; k <= numOfPeople; k++) {
                    graph[Integer.parseInt(input[j])][Integer.parseInt(input[k])] = 1;
                    graph[Integer.parseInt(input[k])][Integer.parseInt(input[j])] = 1;
                }
            }
            parties.add(party);
        }

        // 플로이드 알고리즘 사용
        for (int m = 0; m < N + 1; m++) {
            for (int u = 0; u < N + 1; u++) {
                for (int v = 0; v < N + 1; v++) {
                    graph[u][v] = Math.min(graph[u][v], graph[u][m] + graph[m][v]);
                }
            }
        }


        int ans = 0;

        // 지민이 번호인 0번에서 특정 번호로 가는 경로가 존재하지 않아야 진실을 아는 사람이 없는 파티
        for (List<Integer> party : parties) {
            boolean flag = true;
            for (int num : party) {
                if (graph[0][num] != MAX) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
