package LV2.가장큰수;

import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();

        for(int num : numbers){
            list.add(String.valueOf(num));
        }

        Collections.sort(list,(a,b)->(b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();

        if(list.get(0).equals("0")){
            return "0";
        }

        for(String str : list){
            sb.append(str);
        }

        return sb.toString();
    }
}
