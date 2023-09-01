package 바킹독.이진검색트리.문제추천시스템;

import java.util.*;
import java.io.*;

public class Main {
    static TreeMap<Integer, TreeSet<Integer>> mapKeyByLevel = new TreeMap<>();
    static HashMap<Integer, Integer> mapKeyByProblem = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int P = Integer.parseInt(input[0]);
            int L = Integer.parseInt(input[1]);
            addProblem(L, P);
            mapKeyByProblem.put(P, L);
        }


        StringBuilder ans = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {

            String[] input = br.readLine().split(" ");
            String cmd = input[0];

            if (cmd.equals("recommend")) {
                int num = Integer.parseInt(input[1]);
                if (num == 1) {
                    // 가장 어려운 레벨에서 문제번호가 가장 큰 것
                    int problem = mapKeyByLevel.get(mapKeyByLevel.lastKey()).last();
                    ans.append(problem + "\n");
                } else if (num == -1) {
                    // 가장 쉬운 레벨에서 가장 문제번호가 작은 것
                    Integer problem = mapKeyByLevel.get(mapKeyByLevel.firstKey()).first();
                    ans.append(problem + "\n");
                }
            } else if (cmd.equals("add")) {

                int P = Integer.parseInt(input[1]);
                int L = Integer.parseInt(input[2]);
                addProblem(L, P);

                mapKeyByProblem.put(P, L);

            } else if (cmd.equals("solved")) {
                int P = Integer.parseInt(input[1]);
                int L = mapKeyByProblem.get(P);

                TreeSet<Integer> problems = mapKeyByLevel.get(L);
                problems.remove(P);
                // 레벨에 해당하는 문제 set이 빈 경우 제거해주어야함, 안그러면 recomment 시 에러 발생
                if (problems.isEmpty()) {
                    mapKeyByLevel.remove(L);
                }
            }
        }

        System.out.println(ans);
    }

    private static void addProblem(int L, int P) {
        // L에 해당하는 문제 모음이 없는 경우 새로 추가
        if (!mapKeyByLevel.containsKey(L)) {
            TreeSet<Integer> problems = new TreeSet<>();
            problems.add(P);
            mapKeyByLevel.put(L, problems);
        // 이미 L에 해당하는 문제 모음집이 있으면 거기에 추가
        } else {
            mapKeyByLevel.get(L).add(P);
        }
    }
}
