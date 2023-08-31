package 바킹독.해시.무한수열;

import java.io.*;
import java.util.*;

public class Main {
    static long N;
    static long P;
    static long Q;
    static HashMap<Long, Long> map = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::valueOf).toArray();
        N = input[0];
        P = input[1];
        Q = input[2];

        map.put(0L, 1L);

        System.out.println(sol(N));
    }

    private static long sol(long N) {
        if (map.containsKey(N)) {
            return map.get(N);
        } else {
            long result = sol(N / P) + sol(N / Q);
            map.put(N, result);
            return result;
        }

    }


}
