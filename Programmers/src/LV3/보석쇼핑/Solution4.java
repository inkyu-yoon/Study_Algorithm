package LV3.보석쇼핑;

import java.util.*;

class Solution4 {
    public int[] solution(String[] gems) {
        int[] answer = {};
        int count = getDistinctCount(gems);
        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int result = (a[1] - a[0]) - (b[1] - b[0]);
            if (result == 0) {
                return a[0] - b[0];
            }
            return result;
        });

        for (int i = 0; i < gems.length; i++) {
            String gem = gems[i];

            map.put(gem, map.getOrDefault(gem, 0) + 1);

            while (map.get(gems[left]) >= 2) {
                map.put(gems[left], map.get(gems[left]) - 1);
                left++;
            }

            if (map.size() == count) {
                pq.offer(new int[]{left + 1, i + 1});
            }
        }


        return pq.poll();
    }

    private int getDistinctCount(String[] gems) {
        return (int) Arrays.stream(gems).distinct().count();
    }
}