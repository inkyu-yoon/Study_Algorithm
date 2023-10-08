package 바킹독.최소신장트리.상근이의여행;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);

            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                input = br.readLine().split(" ");
                int u = Integer.parseInt(input[0]) - 1, v = Integer.parseInt(input[1]) - 1;
                int a = find(u), b = find(v);

                if (a != b) {
                    parent[b] = a;
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }

    private static int find(int u) {
        if (parent[u] == u) {
            return u;
        }
        return find(parent[u]);
    }


}
