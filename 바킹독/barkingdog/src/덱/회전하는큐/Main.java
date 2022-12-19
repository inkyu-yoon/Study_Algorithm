package 덱.회전하는큐;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 첫번째 원소를 뽑아낸다. a1 a2 a3 -> a2 a3 이 된다.
        // 2. 왼쪽으로 이동시킨다. a1 a2 a3 -> a2 a3 a1
        // 3. 오른쪽으로 이동시킨다. a1 a2 a3 -> a3 a1 a2
        // 2번 , 3번 연산의 횟수 최솟값 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = br.readLine().split(" ");

        int N = Integer.valueOf(condition[0]); // 전체 수의 갯수
        int M = Integer.valueOf(condition[1]); // 뽑아낼 수의 개수

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.valueOf(s)).toArray();

        int count = 0;

        for (int i = 0; i < M; i++) {
            int find = input[i];
            while (true) {
            int findIndex = 0;
                Iterator it = dq.iterator();

                // 뽑아내야할 숫자 위치 찾는 과정
                while (it.hasNext()) {
                    if ((int) it.next() == find) {
                        break;
                    } else {
                        findIndex++;

                    }
                }

                if (findIndex == 0) {
                    dq.poll();
                    break;
                } else if (findIndex <= dq.size() / 2) {
                    count++;
                    dq.offer(dq.poll());
                } else {
                    count++;
                    dq.addFirst(dq.removeLast());
                }
            }

        }
        System.out.println(count);


    }
}