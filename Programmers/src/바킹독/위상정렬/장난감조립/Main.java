package 바킹독.위상정렬.장난감조립;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] indegree = new int[N + 1];

        Part[] parts = new Part[N + 1];
        for (int i = 0; i <= N; i++) {
            parts[i] = new Part(i);
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int next = Integer.parseInt(input[0]);
            int pre = Integer.parseInt(input[1]);
            int numOfPre = Integer.parseInt(input[2]);
            indegree[next]++;
            parts[pre].nextParts.put(next, numOfPre);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                // 기본 부품을 이루는 기본 부품은 자기 자신 1개
                parts[i].defaultParts.put(i, 1);
            }
        }

        // 위상정렬
        while (!q.isEmpty()) {
            int idx = q.poll();
            Part part = parts[idx];

            for (int nextIdx : part.nextParts.keySet()) {
                Part next = parts[nextIdx];
                int numOfPrePart = part.nextParts.get(nextIdx);

                // 이전 부품의 기본 부품들을 다음 부품에 기록
                for (int idxOfDefaultPart : part.defaultParts.keySet()) {
                    int numOfDefaultPart = part.defaultParts.get(idxOfDefaultPart);
                    next.defaultParts.put(idxOfDefaultPart, next.defaultParts.getOrDefault(idxOfDefaultPart, 0) + numOfPrePart * numOfDefaultPart);
                }

                // 만약 이전 부품이 다 체크되었다면 큐에 추가
                indegree[nextIdx]--;
                if (indegree[nextIdx] == 0) {
                    q.offer(nextIdx);
                }

            }
        }

        Part toy = parts[N];

        List<int[]> ans = new ArrayList<>();
        for (Integer defaultPart : toy.defaultParts.keySet()) {
            ans.add(new int[]{defaultPart, toy.defaultParts.get(defaultPart)});
        }

        Collections.sort(ans, (a, b) -> a[0] - b[0]);

        StringBuilder sb = new StringBuilder();
        for (int[] info : ans) {
            sb.append(info[0] + " " + info[1] + "\n");
        }
        System.out.println(sb);

    }

    static class Part {
        int idx;
        Map<Integer, Integer> nextParts = new HashMap<>();

        Map<Integer, Integer> defaultParts = new HashMap<>();

        public Part(int idx) {
            this.idx = idx;
        }

    }
}
