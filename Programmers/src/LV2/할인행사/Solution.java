package LV2.할인행사;

import java.util.*;
class Solution {
    HashMap<String,Integer> map;
    HashMap<String,Integer> cart;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        map = new HashMap<>();
        cart = new HashMap<>();
        setUp(want,number);

        for(int i=0;i<discount.length;i++){
            String item = discount[i];
            if(i<=9){
                cart.put(item,cart.getOrDefault(item,0)+1);
            }else{
                String removed = discount[i-10];
                cart.put(removed,cart.get(removed)-1);
                cart.put(item,cart.getOrDefault(item,0)+1);
            }

            if(checkValue()){
                answer++;
            }

        }
        return answer;
    }

    boolean checkValue(){
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(cart.get(entry.getKey()) != entry.getValue()){
                return false;
            }
        }
        return true;
    }

    void setUp(String[] want,int[] number){
        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);
        }
    }
}
