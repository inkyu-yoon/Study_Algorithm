package 바킹독.해시.회사에있는사람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        while (n-- > 0) {
            String[] info = br.readLine().split(" ");
            String name = info[0];
            if (set.contains(name)) {
                set.remove(name);
            } else {
                set.add(name);
            }
        }
        String[] arr = set.toArray(new String[set.size()]);
        Arrays.sort(arr, (a, b) -> b.compareTo(a));
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s + "\n");
        }
        System.out.println(sb);

    }
}
