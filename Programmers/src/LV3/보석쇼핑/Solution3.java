package LV3.보석쇼핑;

import java.util.*;
class Solution3 {
    public int[] solution(String[] gems) {
        int [] ans = new int[2];
        int count = new HashSet<>(List.of(gems)).size();

        HashMap<String,Integer> shop = new HashMap<>();

        int left = 0,length=Integer.MAX_VALUE;
        for(int i=0;i<gems.length;i++){
            String gem = gems[i];

            shop.put(gem,shop.getOrDefault(gem,0)+1);

            while(shop.get(gems[left])>=2){
                shop.put(gems[left],shop.get(gems[left])-1);
                left++;
            }

            if(shop.size()==count){
                if(length > (i-left)){
                    ans = new int[]{left+1,i+1};
                    length = i-left;
                }
            }
        }

        return ans;
    }
}