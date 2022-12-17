package 연결리스트.요세푸스문제;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있다. 순서대로 K번째 사람을 제거한다.
        // 한 사람이 제거되면 남은 사람들로 이루어진 원으로 이 과정을 계속한다.
        // N명의 사람이 모두 제거될때 까지 한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int K = Integer.valueOf(input[1]);

        StringBuilder sb =new StringBuilder();
        Queue<Integer> round = new LinkedList<>();
        Queue<Integer> removed = new LinkedList<>();
        for(int i=1;i<=N;i++){
            round.offer(i);
        }

        // 큐가 빌때 까지 K번째 사람을 제거하기
        int count = 0;

        while(!round.isEmpty()){
            int person = round.poll();
            count ++;

            if(count==K){
                removed.offer(person);
                count = 0;
                continue;
            }
            round.offer(person);
        }
        sb.append("<");
        int size = removed.size();
        for(int i=1;i<=size-1;i++){
            sb.append(removed.poll()+", ");
        }
        sb.append(removed.poll() + ">");
        System.out.println(sb);
    }
}
/*
7 3

<3, 6, 2, 7, 5, 1, 4>
 */