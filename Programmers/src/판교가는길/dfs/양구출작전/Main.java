package 판교가는길.dfs.양구출작전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    List<List<Integer>> list;
    long[] sheeps;
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        sheeps = new long[N+1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 2; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            String type = input[0];
            int num = Integer.parseInt(input[1]);
            int v = Integer.parseInt(input[2]);
            sheeps[i] = type.equals("S") ? num : -num;
            list.get(v).add(i);
        }

        System.out.println(dfs(1, 0));
    }

    long dfs(int idx, long sheep) {
        boolean isLeafNode = true;
        long tmp = sheep;
        for (int next : list.get(idx)) {
            isLeafNode = false;
            sheep += dfs(next, tmp);
        }

        if (isLeafNode && sheeps[idx] < 0) {
            return sheep;
        } else if (sheep + sheeps[idx] < 0) {
            return 0;
        } else {
            return sheep + sheeps[idx];
        }

    }
}
