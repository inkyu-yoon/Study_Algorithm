package LV3.단속카메라;

import java.util.*;

class Solution2 {
    public int solution(int[][] routes) {
        int answer = 1;
        List<int[]> list = new ArrayList<>();
        for (int[] route : routes) {
            list.add(route);
        }
        Collections.sort(list, (a, b) -> a[0] - b[0]);


        int camera = list.get(0)[1];
        for (int i = 1; i < list.size(); i++) {
            int[] route = list.get(i);
            if (camera < route[0]) {
                answer++;
                camera = route[1];
                continue;
            }

            if (route[1] < camera) {
                camera = route[1];
            }
        }

        return answer;
    }
}