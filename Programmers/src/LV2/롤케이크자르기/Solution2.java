package LV2.롤케이크자르기;

import java.util.*;
class Solution2 {
    Map<Integer,Integer> left = new HashMap<>();
    Map<Integer,Integer> right = new HashMap<>();

    public int solution(int[] topping) {
        int answer = 0;

        for(int type : topping){
            right.put(type,right.getOrDefault(type,0)+1);
        }

        for(int i=0;i<topping.length;i++){
            int type = topping[i];
            if(right.containsKey(type)){
                if(right.get(type)==1){
                    right.remove(type);
                }else{
                    right.put(type,right.get(type)-1);
                }
            }

            left.put(type,left.getOrDefault(type,0)+1);
            if(left.size()==right.size()){
                answer++;
            }
        }


        return answer;
    }
}
