package LV3.보석쇼핑;

import java.util.*;
class Solution2 {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int cnt = new HashSet<>(Arrays.asList(gems)).size();

        int L = 0,length = Integer.MAX_VALUE;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0 ; i<gems.length ; i++){
            String gem = gems[i];

            map.put(gem,map.getOrDefault(gem,0)+1);

            while(map.get(gems[L])>1){
                map.put(gems[L],map.get(gems[L])-1);
                L++;
            }

            if(map.size()==cnt && length>i-L){
                length = i-L;
                answer[0]=L+1;
                answer[1]=i+1;
            }


        }
        return answer;
    }
}