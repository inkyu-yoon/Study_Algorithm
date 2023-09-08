package 바킹독.그래프.결혼식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static List<List<Integer>> person = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            person.add(new ArrayList<>());
        }

        int m = Integer.parseInt(br.readLine());


        // 자신의 친구와 친구의 친구 초대
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]) - 1, b = Integer.parseInt(input[1]) - 1;
            person.get(a).add(b);
            person.get(b).add(a);
        }

        bfs();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[] checked = new boolean[person.size()];

        q.offer(new int[]{0, 0});
        checked[0] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            int[] info = q.poll();
            int num = info[0];
            int depth = info[1];

            if (depth >= 2) {
                continue;
            }

            List<Integer> friends = person.get(num);
            for (int i = 0; i < friends.size(); i++) {
                Integer friend = friends.get(i);
                if (!checked[friend]) {
                    checked[friend] = true;
                    q.offer(new int[]{friend, depth + 1});
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}
