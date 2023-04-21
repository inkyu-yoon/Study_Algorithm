package LV2.롤케이크자르기;

import java.util.*;
class Solution {
    HashMap<Integer,Integer> mapL;
    HashMap<Integer,Integer> mapR;
    public int solution(int[] topping) {
        int answer = 0;
        setUp(topping);
        System.out.println(mapR);
        for(int i=0;i<topping.length;i++){
            int t = topping[i];

            mapL.put(t,mapL.getOrDefault(t,0)+1);
            mapR.put(t,mapR.get(t)-1);

            if(mapR.get(t)==0){
                mapR.remove(t);
            }

            if(mapL.size()==mapR.size()){
                answer++;
            }
        }

        return answer;
    }

    void setUp(int[] topping){
        mapL = new HashMap<>();
        mapR = new HashMap<>();
        for(int i=0;i<topping.length;i++){
            mapR.put(topping[i],mapR.getOrDefault(topping[i],0)+1);
        }
    }
}