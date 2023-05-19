package 판교가는길.이분탐색.숫자카드;

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
            if (bs(cards, num)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb);
    }

    boolean bs(int[] cards, int num) {
        int left = 0, right = cards.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (num < cards[mid]) {
                right = mid - 1;
            } else if (num > cards[mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
