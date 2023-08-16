package 바킹독.이분탐색.두배열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {
    int T;
    int n;
    int m;
    long[] A;
    long[] B;
    List<Long> sumsA = new ArrayList<>();
    List<Long> sumsB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        Arrays.sort(A);
        Arrays.sort(B);

        long cnt = 0;
        int left = 0, right = sumsB.size() - 1;
        while (left <= A.length-1 && right >= 0) {
            long sum = A[left] + B[right];

            if (sum < T) {
                left++;
            } else if (sum > T) {
                right--;
            } else {
                long cntOfL = 1;
                long cntOfR = 1;

                while (left + 1 <= A.length - 1 && A[left] == A[left+1]) {
                    cntOfL++;
                    left++;
                }

                while (right - 1 >= 0 && B[right] == B[right-1]) {
                    cntOfR++;
                    right--;
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
        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::valueOf).toArray();
        m = Integer.parseInt(br.readLine());
        B = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::valueOf).toArray();

        for (int i = 0; i < n; i++) {
            long res = 0;
            for (int j = i; j < n; j++) {
                res += A[j];
                sumsA.add(res);
            }
        }

        A = sumsA.stream().mapToLong(Long::valueOf).toArray();


        for (int i = 0; i < m; i++) {
            long res = 0;
            for (int j = i; j < m; j++) {
                res += B[j];
                sumsB.add(res);
            }
        }

        B = sumsB.stream().mapToLong(Long::valueOf).toArray();

    }
}
