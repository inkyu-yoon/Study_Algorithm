package 바킹독.이분탐색.나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main2 {
    int M;
    int N;
    int[] trees;
    int max = 0;
    public static void main(String[] args) throws IOException {
        new Main2().sol();
    }

    private void sol() throws IOException {
        setUp();
        System.out.println(getAns());

    }

    private int getAns() {
        int left = 0, right = max;
        while (left < right) {
            int mid = (left + right) / 2;
            if (getTree(mid) < M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left-1;
    }

    private long getTree(int height) {
        long sum = 0;
        for (int tree : trees) {
            long result = tree - height;
            if (result > 0) {
                sum += result;
            }
        }
        return sum;
    }


    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        trees = new int[N];

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(input[i]);
            max = Math.max(max, trees[i]);
        }

        max++;
    }
}
