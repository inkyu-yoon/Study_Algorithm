package 해시.위장;

import java.util.*;
class Solution2 {
    // 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때, 서로 다른 옷의 조합의 수를 return
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for(String[] cloth : clothes){
            map.put(cloth[1],map.getOrDefault(cloth[1],0)+1);
        }

        //아예 하나라도 안입는 경우의 수만 제거하면 된다.
        Collection<Integer> list = map.values();

        // (종류별 옷 갯수 + 해당 종류를 입지 선택하지 않는 경우의수)를 다 곱한다.
        for(Integer element : list){
            answer*=element+1;
        }

        // 하나도 안입는 경우의 수 -1
        return answer-1;
    }
}