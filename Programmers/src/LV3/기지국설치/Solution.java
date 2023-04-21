package LV3.기지국설치;

// 범위는 +- w
import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;

        for(int st : stations){
            if(st-w<=1){
                start = st+w+1;
                continue;
            }
            answer+=Math.ceil((double)(st-w-start)/(2*w+1));
            start = st+w+1;
        }

        if(start<=n){
            answer+=Math.ceil((double)(n+1-start)/(2*w+1));
        }

        return answer;
    }
}