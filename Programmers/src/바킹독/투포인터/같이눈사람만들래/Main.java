package 바킹독.투포인터.같이눈사람만들래;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {
    int N;
    int [] arr;
    List<SnowMan> list = new ArrayList<>();
    int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        getCombinations();
        Collections.sort(list, (a, b) -> a.height - b.height);
        getAns();
        System.out.println(ans);

    }

    private void getAns() {
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                SnowMan snowMan1 = list.get(i);
                SnowMan snowMan2 = list.get(j);
                if (snowMan1.idx1 != snowMan2.idx1 && snowMan1.idx1 != snowMan2.idx2 && snowMan1.idx2 != snowMan2.idx1 && snowMan1.idx2 != snowMan2.idx2) {
                    ans = Math.min(Math.abs(snowMan1.height - snowMan2.height), ans);
                    break;
                }
            }
        }
    }

    private void getCombinations() {
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                list.add(new SnowMan(i, j, arr[i] + arr[j]));
            }
        }
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
    }

    static class SnowMan{
        int idx1;
        int idx2;
        int height;
        public SnowMan(int idx1, int idx2, int height) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.height = height;
        }
    }
}
