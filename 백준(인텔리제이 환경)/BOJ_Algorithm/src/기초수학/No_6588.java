package 기초수학;

import java.io.*;
import java.util.Arrays;

public class No_6588 {
    static boolean[] primes = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        //8 = 3+ 5
        //20 은 3 + 17
        //4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
        //백만 이하의 모든 짝수에 대해서 검증하는 프로그램
        //b-a 가 가장 큰걸로 나타내기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        primes[0] = true;
        primes[1] = true;
        for (int i = 2; i * i < primes.length; i++) {
            for (int j = i * i; j < primes.length; j += i) {
                primes[j] = true;
            }
        }
        do {
            int a = Integer.valueOf(br.readLine());
            if (a == 0) {
                break;
            }
            for (int i = 3; i <= a / 2; i += 2) {
                if (!primes[i] && !primes[a - i]) {
                    sb.append((a + " = " + i + " + " + (a - i) + "\n"));
                    break;
                }
            }
        } while (true);
        System.out.println(sb);
    }
}
