package 해시.폰켓몬;

import java.util.*;
class Solution {
    // N 마리의 폰켓몬 중 N/2마리를 가져갈 수 있다.
    // 예시 [3 1 2 3] 일 때,
    // [3 1] [3 2] [1 2] 를 가져갈 때, 가장 다양한 종류의 폰켓몬을 가져갈 수 있다.

    public int solution(int[] nums) {
        int answer = 0;

        //중복을 제거해야한다.
        Map<Integer,Integer> mon = new HashMap<>();
        for(int num : nums){
            mon.put(num,1);
        }

        //고를 수 있는 폰켓몬 종류를 얻는다.
        int size = mon.keySet().size();

        //폰켓몬수/2 보다 폰켓몬 종류가 적다면, 폰켓몬 종류의 수가 곧 최댓값
        if(size<=nums.length/2){
            answer = size;
            // 폰켓몬 종류가 폰켓몬 수/2 보다 크다면, 폰켓몬 수/2 가 최댓값
        }else{
            answer = nums.length/2;
        }

        return answer;
    }
}