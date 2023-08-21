package 바킹독.투포인터.회전초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;


public class Main {
    int N;
    int d;
    int k;
    int c;
    int[] arr;
    int ans;
    HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    // k개 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공
    // 고객에게 초밥 종류가 쓰인 쿠폰을 발행하고, 1번 행사 참가할 경우 이 쿠폰의 초밥을 무료 제공 (벨트위에 없을경우 새로 만들어 제공)

    private void sol() throws IOException {
        setUp();

        getAns();

        int left = 0, right = k;
        while (right < arr.length) {
            int target = arr[right++];
            map.put(target, map.getOrDefault(target, 0) + 1);

            int removed = arr[left++];
            if (map.get(removed) != 1) {
                map.put(removed, map.get(removed) - 1);
            } else {
                map.remove(removed);
            }

            getAns();
        }

        System.out.println(ans);


    }

    private void getAns() {
        if (!map.containsKey(c)) {
            ans = Math.max(ans, map.size() + 1);
        } else {
            ans = Math.max(ans, map.size());
        }
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        d = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        c = Integer.parseInt(input[3]);

        arr = new int[N+(k-1)];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N; i < arr.length; i++) {
            arr[i] = arr[i - N];
        }

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
    }
}
