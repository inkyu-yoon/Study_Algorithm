package LV2.캐시;

import java.util.*;
class Solution {

    Queue<String> cache;

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        cache = new LinkedList<>();

        if(cacheSize==0){
            return cities.length*5;
        }

        for(String city : cities){
            city = city.toLowerCase();
            if(cache.contains(city)){
                cache.remove(city);
                cache.offer(city);
                answer++;
            }else{
                answer+=5;
                if(cache.size()>=cacheSize){
                    cache.poll();
                    cache.offer(city);
                }else{
                    cache.offer(city);
                }
            }
        }

        return answer;
    }
}