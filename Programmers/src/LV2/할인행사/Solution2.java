package LV2.할인행사;

import java.util.*;
class Solution2 {
    Map<String,Integer> map = new HashMap<>();
    Map<String,Integer> dis = new HashMap<>();

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);
        }

        for(int i=0;i<discount.length-9;i++){
            dis.clear();

            for(int j=i;j<=i+9;j++){
                dis.put(discount[j],dis.getOrDefault(discount[j],0)+1);
            }

            if(check()){
                answer++;
            }

        }
        return answer;
    }

    private boolean check(){
        for(String item : map.keySet()){
            int val = map.get(item);
            if(!dis.containsKey(item) || val!=dis.get(item)){
                return false;
            }
        }
        return true;
    }
}
