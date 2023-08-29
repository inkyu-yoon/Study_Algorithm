package 바킹독.해시.패션왕신해빈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            map.clear();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                map.put(input[1], map.getOrDefault(input[1], 0) + 1);
            }

            int total = 1;
            for (String key : map.keySet()) {
                total *= (map.get(key) + 1);
            }
            sb.append((total-1)+"\n");
        }
        System.out.println(sb);
    }
}
