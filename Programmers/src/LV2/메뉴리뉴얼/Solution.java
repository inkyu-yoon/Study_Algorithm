package LV2.메뉴리뉴얼;

// 최소 2명 이상의 손님으로부터 주문된 단품 메뉴 조합
import java.util.*;
class Solution {
    HashMap<String,Integer> map;
    HashMap<Integer,Integer> check;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        map = new HashMap<>();
        check = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        for(String order : orders){
            order = sortString(order);
            for(int num : course){
                bt(order,sb,0,num);
            }
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            int value = entry.getValue();
            int size = entry.getKey().length();
            if(check.containsKey(size)){
                check.put(size,Math.max(value,check.get(size)));
            }else{
                check.put(size,value);
            }
        }

        for(Map.Entry<Integer,Integer> checkEntry : check.entrySet()){
            int courseSize = checkEntry.getKey();
            int num = checkEntry.getValue();
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(entry.getKey().length()==courseSize && entry.getValue()==num && entry.getValue()>1){
                    answer.add(entry.getKey());
                }
            }
        }
        String [] ans = answer.toArray(new String[answer.size()]);
        Arrays.sort(ans);

        return ans;
    }

    public void bt(String order,StringBuilder sb,int start,int num){
        if(sb.length()==num){
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
            return;
        }
        for(int i=start;i<order.length();i++){
            sb.append(order.charAt(i));
            bt(order,sb,++start,num);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public String sortString(String str){
        char [] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}