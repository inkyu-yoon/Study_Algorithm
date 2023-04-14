package LV2.위장;

import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();

        for(String[] cloth : clothes){
            String item = cloth[0];
            String category = cloth[1];
            map.put(category,map.getOrDefault(category,0)+1);
        }

        for(int value : map.values()){
            answer*=++value;
        }

        return --answer;
    }
}