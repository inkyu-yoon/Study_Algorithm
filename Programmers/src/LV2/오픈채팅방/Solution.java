package LV2.오픈채팅방;
// 채팅방에 입장하면 oo님이 들어왔습니다.
// 채팅방에서 나가면 oo님이 나갔습니다.
// 중복 닉네임 허용
// 채팅방을 나간 뒤, 아이디를 변경하고 다시 들어오면, 이전에 있던 기록도 닉네임이 같이 변경
// 채팅방에서 닉네임을 바꾸면, 안에 있던 기록도 다 같이 바뀜
import java.util.*;
class Solution {
    HashMap<String,String> map;
    public String[] solution(String[] record) {
        String[] answer = {};
        map = new HashMap<>();

        for(String rec : record){
            String [] info = rec.split(" ");
            if(info[0].equals("Enter")){
                map.put(info[1],info[2]);
            }else if(info[0].equals("Change")){
                map.put(info[1],info[2]);
            }
        }

        List<String> ans = new ArrayList<>();

        for(String rec : record){
            String [] info = rec.split(" ");
            if(info[0].equals("Enter")){
                ans.add(String.format("%s님이 들어왔습니다.",map.get(info[1])));
            }else if(info[0].equals("Leave")){
                ans.add(String.format("%s님이 나갔습니다.",map.get(info[1])));
            }
        }

        return ans.toArray(new String[ans.size()]);
    }
}