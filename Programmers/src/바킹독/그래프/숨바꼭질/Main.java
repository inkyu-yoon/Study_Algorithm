package 바킹독.그래프.숨바꼭질;

import java.util.*;
import java.io.*;

public class Main {
    static boolean[] checked;
    static int[] cnts;
    static List<List<Integer>> places = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
        checked = new boolean[N];
        cnts = new int[N];

        for (int i = 0; i < N; i++) {
            places.add(new ArrayList<>());
        }


        while (M-- > 0) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1;
            int v = Integer.parseInt(input[1]) - 1;

            places.get(u).add(v);
            places.get(v).add(u);
        }

        cnts[0] = 0;
        bfs(0);

        int cnt = 0;
        int num = -1;
        int max = Arrays.stream(cnts).max().getAsInt();
        for (int i = 0; i < N; i++) {
            if (cnts[i] == max) {
                if (num == -1) {
                    num = i + 1;
                }
                cnt++;
            }
        }


        System.out.println(num + " " + max + " " + cnt);

    }

    private static void bfs(int i) {
        q.offer(i);
        checked[i] = true;
        while (!q.isEmpty()) {
            int numOfPlace = q.poll();
            List<Integer> connects = places.get(numOfPlace);
            for (int connect : connects) {
                if (!checked[connect]) {
                    q.offer(connect);
                    checked[connect] = true;
                    cnts[connect] = cnts[numOfPlace] + 1;
                }
            }
        }
    }

}
