package 그래프;

import java.io.*;
import java.util.*;

public class No_1707 {
    /* 예제 입력
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2
     */
    //노드와 인접한 노드들을 기록할 예정
    static ArrayList<ArrayList<Integer>> relationList;
    //노드마다 색깔을 입력해 줄 것임
    static int[] color ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //테스트 케이스 횟수
        int K = Integer.valueOf(br.readLine());

        for (int i = 1; i <= K; i++) {
            String[] getCase = br.readLine().split(" ");
            //노드의 갯수
            int V = Integer.valueOf(getCase[0]);
            //간선의 갯수
            int E = Integer.valueOf(getCase[1]);

            color = new int[V + 1];
            relationList = new ArrayList<>();

            //노드 갯수만큼 어레이 리스트를 추가해줌
            for (int j = 0; j <= V; j++) {
                relationList.add(new ArrayList<>());
            }

            //이제 관계 맺어주어야 함
            for (int j = 1; j <= E; j++) {
                String[] input2 = br.readLine().split(" ");
                int num1 = Integer.valueOf(input2[0]);
                int num2 = Integer.valueOf(input2[1]);

                relationList.get(num1).add(num2);
                relationList.get(num2).add(num1);
            }

            for (int j = 1; j <= V; j++) {
                if (color[j] == 0) {
                    dfs(j);
                }
            }
//            System.out.println(Arrays.toString(color));

//            System.out.println(isBipartite());
            bw.write(isBipartite() ? "YES\n" : "NO\n");
        }
        bw.flush();

    }
        static void dfs( int start) {
            if (color[start] == 0) {
                color[start] = 1;
            }
            for (Integer neighbor : relationList.get(start)) {
                if (color[neighbor] == 0) {
                    color[neighbor] = color[start] * -1;
                    dfs(neighbor);
                }
            }
        }

    static boolean isBipartite() {
        for (int i = 1; i < relationList.size(); i++) {
            ArrayList<Integer> neighbors = relationList.get(i);
            for (Integer neighbor : neighbors) {
                if (color[i] == color[neighbor]) {
                    return false;
                }
            }
        }
        return true;
    }
}
