package LV2.오픈채팅방;

import java.util.*;

class Solution2 {

    Map<String, String> user = new HashMap<>();

    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        for (String info : record) {
            String[] split = info.split(" ");
            String cmd = split[0], id = split[1];

            if (cmd.equals("Enter")) {
                String name = split[2];
                user.put(id, name);
            } else if (cmd.equals("Change")) {
                String name = split[2];
                user.put(id, name);
            }
        }

        for (String info : record) {
            String[] split = info.split(" ");
            String cmd = split[0], id = split[1];

            if (cmd.equals("Enter")) {
                list.add(String.format("%s님이 들어왔습니다.", user.get(id)));
            } else if (cmd.equals("Leave")) {
                list.add(String.format("%s님이 나갔습니다.", user.get(id)));
            }
        }


        return list.stream().toArray(String[]::new);
    }


}
