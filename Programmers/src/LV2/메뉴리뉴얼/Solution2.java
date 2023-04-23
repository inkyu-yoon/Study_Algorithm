package LV2.메뉴리뉴얼;

import java.util.*;
class Solution2 {
    HashMap<String,Integer> map;
    HashMap<Integer,Integer> max;
    List<String> ans;
    StringBuilder sb;
    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        max = new HashMap<>();
        ans = new ArrayList<>();
        sb = new StringBuilder();

        for(String order : orders){
            for(int num : course){
                bt(order,num,0);
            }
        }

        getMaxMenu();

        getAns();

        return ans.toArray(new String[ans.size()]);
    }

    void getAns(){
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            int len  = entry.getKey().length();
            if(max.get(len)==entry.getValue() && entry.getValue()>=2){
                ans.add(entry.getKey());
            }
        }
        Collections.sort(ans);

    }

    void getMaxMenu(){
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            int len  = entry.getKey().length();
            max.put(len,Math.max(max.getOrDefault(len,0),entry.getValue()));
        }
    }

    void bt(String order, int size, int start){
        if(sb.length()==size){
            char[] arr = sb.toString().toCharArray();
            Arrays.sort(arr);
            String menu = new String(arr);
            map.put(menu,map.getOrDefault(menu,0)+1);
            return;
        }
        for(int i=start;i<order.length();i++){
            String menu = String.valueOf(order.charAt(i));
            if(sb.indexOf(menu)>=0){
                continue;
            }
            sb.append(menu);
            bt(order,size,i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
