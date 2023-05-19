package 바킹독.이분탐색.나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int N = info[0], M = info[1];
        long[] trees = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::valueOf).toArray();
        Arrays.sort(trees);
        long left = 0, right = trees[N - 1] + 1;

        while (left < right) {
            long mid = (left + right) / 2;
            long result = 0;
            for (long tree : trees) {
                if (tree > mid) {
                    result += tree - mid;
                }
            }
            if (result < M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right-1);
    }
}
