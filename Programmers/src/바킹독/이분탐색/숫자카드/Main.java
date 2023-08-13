package 바킹독.이분탐색.숫자카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    int N;
    int M;
    int [] cards;
    int [] targets;
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        Arrays.sort(cards);
        StringBuilder sb = new StringBuilder();
        for (int target : targets) {
            if (bs(target)) {
                sb.append(1 + " ");
            } else {
                sb.append(0 + " ");
            }
        }

        System.out.println(sb);
    }

    private boolean bs(int target) {
        int left = 0, right = cards.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= cards[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (0 <= left && left < cards.length) {
            if (cards[left] == target) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }


    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cards = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(input[i]);
        }

        M = Integer.parseInt(br.readLine());
        targets = new int[M];
        input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(input[i]);
        }
    }
}
