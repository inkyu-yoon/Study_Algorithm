package LV2.기능개발;

import java.util.*;

class Solution2 {
    public int[] solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        for (int i = 0; i < N; i++) {
            int progress = progresses[i];
            int left = 100 - progress;
            progresses[i] = (int) Math.ceil((double) left / speeds[i]);
        }

        List<Integer> list = new ArrayList<>();

        int target = progresses[0];
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (target >= progresses[i]) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
                target = progresses[i];
            }
        }
        list.add(cnt);
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}