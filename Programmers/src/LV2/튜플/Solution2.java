package LV2.튜플;

import java.util.*;
import java.util.regex.*;

class Solution2 {
    public int[] solution(String s) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(s);
        HashMap<Integer,Integer> map = new HashMap<>();
        while(matcher.find()){
            int result = Integer.parseInt(matcher.group());
            map.put(result,map.getOrDefault(result,0)+1);
        }

        List<int []> list = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(new int[]{entry.getKey(),entry.getValue()});
        }

        Collections.sort(list,(a,b)-> b[1]-a[1]);
        int[] answer = new int[list.size()];

        for(int i = 0; i<list.size();i++){
            answer[i] = list.get(i)[0];
        }

        return answer;
    }
}