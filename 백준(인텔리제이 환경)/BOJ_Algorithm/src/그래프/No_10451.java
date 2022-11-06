package 그래프;

import java.io.*;
import java.util.ArrayList;

public class No_10451 {
    /* 예제 입력
2
8
3 2 7 8 1 4 5 6
10
2 1 3 4 5 6 7 9 10 8
     */
    static ArrayList<ArrayList<Integer>> relation;
    static boolean[] marked;

    public static void main(String[] args) throws IOException {
        //순열로 존재하는 사이클 갯수 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());

        while (T-- > 0) {
            int N = Integer.valueOf(br.readLine());
            String[] input = br.readLine().split(" ");
            relation = new ArrayList<>();
            marked = new boolean[N+1];

            for (int i = 0; i <= N; i++) {
                relation.add(new ArrayList<>());
            }

            for (int i = 1; i <= N; i++) {
                relation.get(i).add(Integer.valueOf(input[i - 1]));
                relation.get(Integer.valueOf(input[i - 1])).add(i);
            }
//            for (ArrayList<Integer> neighbors : relation) {
//                for (Integer neighbor : neighbors) {
//                    System.out.print(neighbor+ " ");
//                    System.out.println();
//                }
//                System.out.println("================");
//            }
            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (marked[i] == false) {
                    dfs(i);
                    count++;
                } else {
                    continue;
                }
            }
            System.out.println(count);
        }

    }

    static void dfs(int start) {
        if (marked[start] == true) {
            return;
        } else {
            marked[start] = true;
            for (Integer neighbor : relation.get(start)) {
                if (marked[neighbor] == false) {
                    dfs(neighbor);
                }
            }
        }
    }
}

