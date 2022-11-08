package 그래프;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/* 예제 입력
2
7
3 1 3 7 3 4 6
8
1 2 3 4 5 6 7 8
 */
// 노드들을 연결지었을 떄, 어느 프로젝트 팀에도 속하지 않는 학생들의 수를 구하는 프로그램
// 노드들을 한바퀴 돌릴 수 있을때 팀이 완성됨..start와 end가 같아야함
public class No_9466 {
    static int[] graph;
    static boolean[] marked, finish;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.valueOf(br.readLine());
        while (T-- > 0) {
            int n = Integer.valueOf(br.readLine());
            graph = new int[n + 1];
            marked = new boolean[n + 1];
            finish = new boolean[n + 1];
            count = 0;
            String[] input = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                graph[i] = Integer.valueOf(input[i - 1]);
            }

            for (int i = 1; i <= n; i++) {
                if (!finish[i]) {
                    dfs(i);
                }
            }
            bw.write(n - count + "\n");
        }
        bw.flush();
        bw.close();

    }
/*
1 -> 3 -> 3
2 -> 1 -> 3 ->3
3 -> 3
4 -> 7 -> 6 -> 4
5 -> 3 -> 3
6 -> 4-> 7 -> 6
7 -> 6 -> 4 -> 7
 */

    static void dfs(int start) {
        if (marked[start] == false) {
            marked[start] = true;
        } else {
            //순한되는 구조가 아니면 이 곳에 애초에 들어올 수 없다.
            finish[start] = true;
            count++;
        }

        if (finish[graph[start]] == false) {
            dfs(graph[start]);
        }


        marked[start] = false;
        finish[start] = true;




    }
}