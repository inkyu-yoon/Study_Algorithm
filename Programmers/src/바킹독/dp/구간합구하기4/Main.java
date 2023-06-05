package 바킹독.dp.구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
        int[] sums = getArray(N,br.readLine());

        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0]), j = Integer.parseInt(input[1]);
            sb.append(sums[j] - sums[i - 1]+"\n");
        }

        System.out.println(sb);


    }

    private static int[] getArray(int N,String readLine) {
        int[] result = new int[N+1];

        String[] input = readLine.split(" ");
        for (int i = 1; i <= N; i++) {
            result[i] = Integer.parseInt(input[i - 1]) + result[i - 1];
        }


        return result;
    }
}
