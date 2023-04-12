package LV2.HIndex;

// n편 중 h번 이상 인용된 논문이 h편 이상이고 나머지가 h번 이하 인용되었을 때, h의 최댓값
import java.util.*;
class Solution {
    public int solution(int[] citations) {

        int answer = 0;

        for(int h = 1; h<=citations.length; h++){
            int num = h;
            int result = (int) Arrays.stream(citations)
                    .filter(citation -> citation >= num)
                    .count();
            if(result>=h){
                answer = Math.max(h,answer);
            }
        }


        return answer;
    }
}