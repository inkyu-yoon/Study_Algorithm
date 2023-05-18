package 바킹독.이분탐색.숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int M = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Arrays.sort(cards);

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(bsMax(cards, num) - bsMin(cards, num) + " ");
        }
        System.out.println(sb);
    }

    int bsMin(int[] cards, int num) {
        int left = 0,right = cards.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (num <= cards[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    int bsMax(int[] cards, int num) {
        int left = 0,right = cards.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (num < cards[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
