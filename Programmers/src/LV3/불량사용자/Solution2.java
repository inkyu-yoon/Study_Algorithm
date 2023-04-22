package LV3.불량사용자;

import java.util.*;
import java.util.regex.*;
class Solution2 {
    Stack<String> s;
    HashSet<String> set;
    HashSet<String> ans;

    public int solution(String[] user_id, String[] banned_id) {
        s = new Stack<>();
        set = new HashSet<>();
        ans = new HashSet<>();

        getAllCases(user_id, banned_id);

        return ans.size();
    }

    void getAllCases(String[] user_id, String[] banned_id){
        if(s.size()==banned_id.length){
            String[] list = s.toArray(new String[s.size()]);
            if(checkRegex(list,banned_id)){
                addAns(list);
            }
            return;
        }

        for(int i=0;i<user_id.length;i++){
            String id = user_id[i];
            if(s.contains(id)){
                continue;
            }
            s.push(id);
            getAllCases(user_id,banned_id);
            s.pop();
        }
    }

    boolean checkRegex(String[] list, String[] banned_id){
        for(int i=0;i<banned_id.length;i++){
            String regex = banned_id[i].replaceAll("\\*",".");
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(list[i]);
            if(m.find()){
                if(m.group().length()!=list[i].length()){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    void addAns(String[] list){
        Arrays.sort(list);
        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append(str);
        }
        ans.add(sb.toString());
    }

}