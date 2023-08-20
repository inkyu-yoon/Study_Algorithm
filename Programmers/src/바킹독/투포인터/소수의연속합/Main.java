package 바킹독.투포인터.소수의연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    int N;
    int[] primes;

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        getPrimes();
        if (N == 1) {
            System.out.println(0);
        } else {
            System.out.println(getAns());
        }
    }

    private int getAns() {
        int cnt = 0;
        int left = 0, right = 0;
        int sum = primes[right];
        while (right < primes.length) {
            if (sum < N) {
                if (right == primes.length - 1) {
                    break;
                }
                sum += primes[++right];
            } else if (sum >= N) {
                if (sum == N) {
                    cnt++;
                }
                sum -= primes[left++];
            }
        }
        return cnt;
    }

    private void getPrimes() {
        boolean[] check = new boolean[N + 1];
        check[0] = true;
        check[1] = true;
        for (int i = 2; i * i <= N; i++) {
            for (int j = i + i; j <= N; j += i) {
                check[j] = true;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            if (!check[i]) {
                list.add(i);
            }
        }

        primes = list.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

    }
}
