package BFS.숨바꼭질;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 수빈이는 현재 점 N에 있다. 0<= N <= 100000
    // 동생은 점 K에 있다. 0<= K <= 100000
    // 수빈이는 (-1 혹은 +1) 또는 ( 2 * X ) 위치로 이동한다. (1초 걸림)
    // 수빈이가 동생을 찾을 수 있는 가장 빠른 시간은 몇 초 후인가?
    static int N ;
    static int K;
    static int[] time = new int[100001];
    static int[] walk = {1, -1};
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        N = Integer.valueOf(input[0]);
        K = Integer.valueOf(input[1]);

        Arrays.fill(time, Integer.MAX_VALUE);

        q.offer(N);
        time[N] = 0;

        System.out.println(bfs());
    }

    static int bfs(){
        while(!q.isEmpty()){
            int point = q.poll();


            if (point == K) {
                return time[point];
            }
            for (int i = 0; i <= 1; i++) {
                int np = point + walk[i];
                if (0 <= np && np <= 100000) {
                    if (time[np] > time[point] + 1) {
                        time[np]=time[point]+1;
                        q.offer(np);
                    }
                }
            }
            int np2 = 2*point;
            if (0 <= np2 && np2 <= 100000) {
                if (time[np2] > time[point] + 1) {
                    time[np2]=time[point]+1;
                    q.offer(np2);
                }
            }
        }
        return 0;
    }
}
/*
5 0초
4 1초
8 2초
16 3초
17 4초

5 17

4
 */