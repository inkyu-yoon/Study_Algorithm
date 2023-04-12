package LV2.귤고르기;

// 귤 종류를 최소화
import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int type : tangerine){
            map.put(type,map.getOrDefault(type,0)+1);
        }

        List<Integer> list = new ArrayList<>();

        for(int key : map.keySet()){
            list.add(map.get(key));
        }
        Collections.sort(list,Comparator.reverseOrder());
        int idx = 0;
        while(k>0){
            k-=list.get(idx++);
        }
        return idx;
        

    }
}