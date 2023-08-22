package 바킹독.투포인터.겹치는건싫어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Main {
    int N;
    int K;
    int[] arr;
    HashMap<Integer, Integer> map = new HashMap<>();
    int ans;

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();

        ans = 0;


        int left = 0, right = 0;
        while (right < N) {
            int target = arr[right++];

            if (map.containsKey(target)) {
                while (map.get(target) >= K) {
                    int n = arr[left++];

                    map.put(n, map.get(n) - 1);

                }
                map.put(target, map.get(target) + 1);

            } else {
                map.put(target, 1);
            }
            ans = Math.max(ans, right - left);
        }
        System.out.println(ans);
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        arr = new int[N];

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
    }
}
