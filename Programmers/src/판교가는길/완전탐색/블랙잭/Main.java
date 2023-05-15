package 판교가는길.완전탐색.블랙잭;
// M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합

import java.util.*;
import java.io.*;

public class Main {
    int M;
    int N;
    int[] cards;
    Stack<Integer> s;
    int ans = 0;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(cards);

        s = new Stack<>();
        bt();
        System.out.println(ans);
    }

    void bt() {
        if (s.size() == 3) {
            int result = 0;

            for (int num : s) {
                result += num;
            }
            if(result<=M){
                ans=Math.max(ans,result);
            }
            return;
        }
        for (int i = 0; i < cards.length; i++) {
            int card = cards[i];
            if (s.contains(card) || card > M) {
                continue;
            }
            s.push(card);
            bt();
            s.pop();
        }
    }
}
