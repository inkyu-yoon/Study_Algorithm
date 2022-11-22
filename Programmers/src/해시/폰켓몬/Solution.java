package 해시.폰켓몬;

import java.util.*;

class Solution {
    // 총 N마리의 폰켓몬 중 N/2 마리를 가져갈 수 있다.
    // N/2 마리를 고르는 과정에서 가장 다양한 종류로 가져갈 수 있는 최댓값을 구한다.
    // 중복 제거가 필요하다.
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> monsters = new HashMap<>();

        // 가져갈 수 있는 폰켓몬 수
        int getable = nums.length / 2;

        //맵에 저장하면서 중복 제거
        for (int num : nums) {
            monsters.put(num, 1);
        }

        // 폰켓몬 종류의 개수
        int species = monsters.size();

        // 가져갈 수 있는 폰켓몬 수 >= 폰켓몬 종류 인 경우, 폰켓몬 종류 갯수가 최댓값
        if (getable >= species) {
            answer = species;
            // 가져갈 수 있는 폰켓몬 수 < 폰켓몬 종류 인 경우, 종류가 아무리 다양해도 가져갈 수 있는 갯수의 한계가 있음
        } else {
            answer = getable;
        }

        return answer;
    }
}