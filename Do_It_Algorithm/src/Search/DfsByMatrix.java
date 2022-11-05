package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DfsByMatrix {
    static int[][] graph = new int[1001][1001];
    static boolean[] marked = new boolean[1001];
    static int N;
    static int E;

    static void dfs(int start) {
        if (marked[start] == true) {
            return;
        } else {
            marked[start] = true;
            for (int i = 1; i <= N; i++) {
                if (graph[start][i] == 1) {
                    dfs(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        E = Integer.valueOf(input[1]);
        for (int i = 1; i <= E; i++) {
            String[] input2 = br.readLine().split(" ");
            int n1 = Integer.valueOf(input2[0]);
            int n2 = Integer.valueOf(input2[1]);
            graph[n1][n2] = graph[n2][n1] = 1;
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (marked[i] == false) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

}
