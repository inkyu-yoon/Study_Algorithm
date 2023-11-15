package LV2.연속된부분수열의합;

import java.util.*;

class Solution2 {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[]{0, 1000000};
        int left = 0;
        int sum = 0;
        List<int[]> answers = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                answers.add(new int[]{left, i});
            } else if (sum > k) {
                while (sum > k) {
                    sum -= arr[left++];
                }
                if (sum == k) {
                    answers.add(new int[]{left, i});
                }
            }
        }

        Collections.sort(answers, (a, b) -> {
            int result = (a[1] - a[0]) - (b[1] - b[0]);
            return result == 0 ? a[1] - b[1] : result;
        });


        return answers.get(0);
    }
}
