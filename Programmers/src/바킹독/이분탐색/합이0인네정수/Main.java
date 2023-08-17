package 바킹독.이분탐색.합이0인네정수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    int n;
    long[] A;
    long[] B;
    long[] C;
    long[] D;
    long[] sums1;
    long[] sums2;
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();

        int left = 0;
        int right = sums2.length-1;

        long cnt = 0;

        while (left < sums1.length && right >= 0) {
            long sum = sums1[left] + sums2[right];
            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                long cntOfL = 1;
                long cntOfR = 1;

                while (left +1 <= sums1.length-1 && sums1[left] == sums1[left + 1]) {
                    left++;
                    cntOfL++;
                }

                while (right - 1 >= 0 && sums2[right] == sums2[right - 1]) {
                    right--;
                    cntOfR++;
                }

                cnt += cntOfL * cntOfR;
                left++;
                right--;
            }
        }
        System.out.println(cnt);

    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new long[n];
        B = new long[n];
        C = new long[n];
        D = new long[n];

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            A[i] = input[0];
            B[i] = input[1];
            C[i] = input[2];
            D[i] = input[3];
        }

        sums1 = new long[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sums1[i * n + j] = A[i] + B[j];
            }
        }

        sums2 = new long[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sums2[i * n + j] = C[i] + D[j];
            }
        }

        Arrays.sort(sums1);
        Arrays.sort(sums2);


    }
}
