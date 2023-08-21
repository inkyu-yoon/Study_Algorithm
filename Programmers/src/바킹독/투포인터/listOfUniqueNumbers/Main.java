package 바킹독.투포인터.listOfUniqueNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    int N;
    int[] arr;

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        boolean[] checked = new boolean[100001];
        int left = 0, right = 0;
        long cnt = 0;

        while (right <= N - 1) {
            int target = arr[right];
            if (!checked[target]) {
                checked[target] = true;
                cnt += right - left + 1;
                right++;
            } else {
                while (arr[left] != target) {
                    checked[arr[left]] = false;
                    left++;
                }
                left++;
                cnt += right - left + 1;
                right++;
            }


        }
        System.out.println(cnt);

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
}
