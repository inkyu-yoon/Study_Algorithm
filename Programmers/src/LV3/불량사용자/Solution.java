package LV3.불량사용자;

import java.util.*;
import java.util.regex.*;

class Solution {
    HashSet<String> set;
    Stack<String> stack;
    HashSet<String> ans;
    public int solution(String[] user_id, String[] banned_id) {
        findSet(user_id,banned_id);

        String [] arr = set.toArray(new String[set.size()]);
        stack = new Stack<>();
        ans = new HashSet<>();
        bt(arr,banned_id);

        return ans.size();
    }
    boolean check(String[] banned_id){
        for(int i=0;i<stack.size();i++){
            String regex = banned_id[i].replaceAll("\\*",".");
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(stack.get(i));
            if(m.find()){
                if(m.group().length()!=stack.get(i).length()){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
    void bt(String [] arr,String[] banned_id){
        if(stack.size()==banned_id.length){
            if(check(banned_id)){
                String [] comb = stack.toArray(new String[stack.size()]);
                Arrays.sort(comb);
                StringBuilder sb = new StringBuilder();
                for(String s : comb){
                    sb.append(s);
                }
                ans.add(sb.toString());
            }
            return;
        }
        for(int i=0;i<arr.length;i++){
            String id = arr[i];
            if(stack.contains(id)){
                continue;
            }
            stack.push(id);
            bt(arr,banned_id);
            stack.pop();
        }

    }

    // 정규식에 일치하는 아이디 일단 다 구하기
    void findSet(String[] user_id, String[] banned_id){
        set = new HashSet<>();
        for(String id : banned_id){
            String regex = id.replaceAll("\\*",".");
            for(String user : user_id){
                Pattern p = Pattern.compile(regex);
                Matcher matcher = p.matcher(user);
                if(matcher.find() &&  matcher.group().length()==user.length()){
                    set.add(matcher.group());
                }
            }
        }
    }

}
