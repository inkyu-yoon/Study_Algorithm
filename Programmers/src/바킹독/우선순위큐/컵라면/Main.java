package 바킹독.우선순위큐.컵라면;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Problem> pq = new PriorityQueue<>((a, b) -> a.deadLine - b.deadLine);

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int deadLine = Integer.parseInt(input[0]);
            long numOfRamen = Long.parseLong(input[1]);
            pq.offer(new Problem(deadLine, numOfRamen));
        }

        PriorityQueue<Long> solved = new PriorityQueue<>();


        while (!pq.isEmpty()) {

            Problem problem = pq.poll();
            int deadLine = problem.deadLine;
            long numOfRamen = problem.numOfRamen;
            if (solved.isEmpty()) {
                solved.offer(numOfRamen);
            } else {

                if (deadLine <= solved.size()) {
                    if (solved.peek() < numOfRamen) {
                        solved.poll();
                        solved.offer(numOfRamen);
                    }
                } else {
                    solved.offer(numOfRamen);
                }
            }
        }

        long result = 0;

        for (Long num : solved) {
            result += num;
        }
        System.out.println(result);

    }

    static class Problem {
        int deadLine;
        long numOfRamen;

        public Problem(int deadLine, long numOfRamen) {
            this.deadLine = deadLine;
            this.numOfRamen = numOfRamen;
        }
    }

}



/*
4
1 1
2 1
3 10
3 10
3 10
 */