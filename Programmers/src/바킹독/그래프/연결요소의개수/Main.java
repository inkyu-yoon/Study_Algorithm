package 바킹독.그래프.연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean[] checked;
    static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }


        while (M-- > 0) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1, v = Integer.parseInt(input[1]) - 1;
            list.get(u).add(v);
            list.get(v).add(u);
        }

        checked = new boolean[N];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (!checked[i]) {
                checked[i] = true;
                search(i);
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    private static void search(int u) {
        List<Integer> connect = list.get(u);
        for (int i = 0; i < connect.size(); i++) {
            int v = connect.get(i);
            if (!checked[v]) {
                checked[v] = true;
                search(v);
            }
        }
    }
}

