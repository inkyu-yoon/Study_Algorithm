package LV2.튜플;

import java.util.*;
class Solution {
    public int[] solution(String s) {

        String [] result = s.replace("{","").replace("}","").split(",");

        HashMap<String,Integer> map = new HashMap<>();

        for(String num : result){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int[] answer = new int[map.size()];

        List<String[]> list = new ArrayList<>();

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            list.add(new String[]{entry.getKey(),String.valueOf(entry.getValue())});
        }

        Collections.sort(list,(a,b)-> Integer.valueOf(b[1])-Integer.valueOf(a[1]));

        for(int i=0;i<answer.length;i++){
            answer[i]=Integer.valueOf(list.get(i)[0]);
        }

        return answer;
    }
}