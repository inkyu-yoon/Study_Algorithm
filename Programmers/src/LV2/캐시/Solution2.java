package LV2.캐시;

import java.util.*;

class Solution2 {
    Queue<String> cache = new LinkedList<>();

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.contains(city)) {
                answer++;
                cache.remove(city);
                cache.offer(city);
            } else {
                answer += 5;

                if (cache.size() < cacheSize) {
                    cache.offer(city);
                } else if (cache.size() == cacheSize) {
                    if (!cache.isEmpty()) {
                        cache.poll();
                        cache.offer(city);
                    }
                }
            }


        }

        return answer;
    }
}
