package 바킹독.투포인터.같이눈사람만들래;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main2 {
    int N;
    int[] arr;
    int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        new Main2().sol();
    }

    private void sol() throws IOException {
        setUp();
        Arrays.sort(arr);
        getAns();
        System.out.println(ans);
    }

    private void getAns() {
        for (int i = 0; i <= N - 4; i++) {
            for (int j = N - 1; j >= i + 3; j--) {
                int snowman1 = arr[i] + arr[j];
                int left = i + 1, right = j - 1;
                while (left < right) {
                    int snowman2 = arr[left] + arr[right];
                    if (snowman2 < snowman1) {
                        left++;
                    } else if (snowman2 > snowman1) {
                        right--;
                    } else {
                        System.out.println(0);
                        System.exit(0);
                    }
                    ans = Math.min(ans, Math.abs(snowman1 - snowman2));
                }
            }
        }
    }
// 2 3 5 6

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
