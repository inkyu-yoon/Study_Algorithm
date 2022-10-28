package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1929 {
    public static void main(String[] args) throws IOException {
        //M이상 N이하의 소수를 모두 출력하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.valueOf(input[0]);
        int N = Integer.valueOf(input[1]);
        boolean[] pri = new boolean[N+1];
        StringBuilder sb = new StringBuilder();
        pri[1]=true;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if(pri[i]){
                continue;
            }
            for (int j = i*i; j <= N; j += i) {
                pri[j] = true;
            }
        }
        for (int i = M; i <= N; i++) {
            if (!pri[i]) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }
}
