package LV2.구명보트;

// 최대 2명 탑승 가능
import java.util.*;
class Solution2 {
    public int solution(int[] people, int limit) {
        int cnt = 0;

        int N = people.length;
        Arrays.sort(people);

        int left = 0;
        int right = N-1;

        while(left<=right){

            int light = people[left];
            int heavy = people[right];

            if(light+heavy>limit){
                right--;
            }else{
                left++;
                right--;
            }
            cnt++;

        }



        return cnt;
    }
}