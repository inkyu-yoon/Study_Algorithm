package 바킹독.투포인터.대표선수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    int N;
    int M;
    int[][] arr;


    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        int ans = Integer.MAX_VALUE;
        int[] idx = new int[N];
        while (true) {
            int[] info = new int[N];


            for (int i = 0; i < N; i++) {
                int st = arr[i][idx[i]];
                info[i] = st;
            }


            int min = Integer.MAX_VALUE;
            int max = 0;
            int minIdx = 0;
            for (int i = 0; i < N; i++) {
                if (info[i] < min) {
                    min = info[i];
                    minIdx = i;
                }
                if (info[i] > max) {
                    max = info[i];
                }

            }
            ans = Math.min(ans, max - min);
            idx[minIdx]++;

            if (idx[minIdx] == M) {
                break;
            }
        }
        System.out.println(ans);

    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
            Arrays.sort(arr[i]);
        }

    }
}
