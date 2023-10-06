package 바킹독.위상정렬.작업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Work[] works = new Work[N + 1];
        int[] indegree = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            works[i] = new Work(i);
        }


        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");

            int numOfWork = i;
            Work work = works[numOfWork];

            int time = Integer.parseInt(input[0]);
            work.cost = time;
            work.endTime = time;

            int numOfPreWork = Integer.parseInt(input[1]);
            indegree[numOfWork] += numOfPreWork;

            for (int j = 2; j < numOfPreWork + 2; j++) {
                int preWork = Integer.parseInt(input[j]);
                works[preWork].next.add(numOfWork);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int numOfWork = q.poll();
            Work work = works[numOfWork];
            ans = Math.max(work.endTime, ans);

            for (int numOfNextWork : work.next) {
                indegree[numOfNextWork]--;
                Work nextWork = works[numOfNextWork];
                nextWork.startTime = Math.max(nextWork.startTime, work.endTime);
                nextWork.endTime = nextWork.startTime + nextWork.cost;

                if (indegree[numOfNextWork] == 0) {
                    q.offer(numOfNextWork);
                }

            }
        }
        System.out.println(ans);
    }

    static class Work {
        int idx;
        List<Integer> next = new ArrayList<>();
        int cost;
        int startTime;
        int endTime;

        public Work(int idx) {
            this.idx = idx;
        }

    }
}
