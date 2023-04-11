package LV2.구명보트;

import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
        int left = 0;
        int right = people.length-1;

        while(left<=right){
            if(people[right]+people[left] <=limit){
                left++;
                right--;
            }else{
                right--;
            }
            answer++;
        }
        return answer;
    }
}