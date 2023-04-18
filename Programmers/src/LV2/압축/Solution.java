package LV2.압축;

import java.util.*;
class Solution {
    HashMap<String,Integer> map;
    List<Integer> ans;
    public int[] solution(String msg) {
        setUp();

        int idx = 0;
        while(idx<msg.length()){
            String target = String.valueOf(msg.charAt(idx));
            int location = 0;
            while(map.containsKey(target)){
                location = map.get(target);
                if(idx==msg.length()-1){
                    idx++;
                    break;
                }
                target+=String.valueOf(msg.charAt(++idx));
            }
            ans.add(location);
            map.put(target,map.size()+1);
        }

        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    void setUp(){
        ans = new ArrayList<>();
        map = new HashMap<>();
        for(int i=1;i<=26;i++){
            map.put(String.valueOf((char)('A'+i-1)),i);
        }
    }
}
