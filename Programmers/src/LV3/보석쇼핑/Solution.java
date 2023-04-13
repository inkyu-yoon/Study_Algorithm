package LV3.보석쇼핑;

import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        int kind = (int)Arrays.stream(gems)
                .distinct()
                .count();

        int left = 0, length = Integer.MAX_VALUE;

        HashMap<String,Integer> map = new HashMap<>();

        int startIdx =0,endIdx=0;
        for(int i=0 ; i<gems.length;i++){
            String gem = gems[i];

            map.put(gem,map.getOrDefault(gem,0)+1);

            while(map.get(gems[left])>1){
                map.put(gems[left],map.get(gems[left])-1);
                left++;
            }

            if(kind==map.size() && length>i-left){
                length = i-left;
                startIdx = left;
                endIdx = i;

            }

        }

        return new int[]{startIdx+1,endIdx+1};
    }
}