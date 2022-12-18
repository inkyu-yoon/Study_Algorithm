package 스택.탑;

import java.io.*;
import java.util.*;

public class Main {
    // 일직선 위에 N개의 높이가 서로 다른 탑을 왼쪽부터 오른쪽 방향으로 세운다.
    // 모든 탑의 레이저 송신기는 레이저 신호를 지표면과 평행하게 왼쪽방향으로 발사한다.
    // 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능하다.
    // 예를 들어 6 9 5 7 4 일 때,
    // 4가 보낸 신호는 7이 받음
    // 7이 보낸 신호는 5는 못받고 9가 받음
    // 5가 보낸 신호는 9가 받음
    // 9가 보낸 신호는 아무도 못받음
    // 6이 보낸 신호는 탑이 없으므로 못받음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int[] tops = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.valueOf(s)).toArray();
        Stack<int []> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int top = tops[i]; // 현재 탑의 높이
            while(!stack.empty()) {
                if(stack.peek()[1] < top) { //탑 높이 비교
                    stack.pop();
                }
                else {
                    sb.append(stack.peek()[0] + " "); //탑 위치 추가
                    break;
                }
            }
            if(stack.isEmpty()) {
                sb.append(0+" ");
            }
            stack.push(new int[] {i+1, top}); // (탑의 위치, 탑의 높이)
        }
        System.out.println(sb);
    }
}
/*
5
6 9 5 7 4

0 0 2 2 4
 */
