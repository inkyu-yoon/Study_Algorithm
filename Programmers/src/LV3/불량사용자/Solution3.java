package LV3.불량사용자;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution3 {
    Stack<String> users = new Stack<>();
    boolean[] checked;
    Set<String> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        checked = new boolean[user_id.length];
        bt(user_id, banned_id);

        return set.size();
    }

    public void bt(String[] user_id, String[] banned_id) {
        if (users.size() == banned_id.length) {
            compare(banned_id);
            return;
        }
        for (int i = 0; i < user_id.length; i++) {
            if (!checked[i]) {
                users.push(user_id[i]);
                checked[i] = true;
                bt(user_id, banned_id);
                users.pop();
                checked[i] = false;
            }
        }
    }

    public void compare(String[] banned_id) {
        for (int i = 0; i < banned_id.length; i++) {
            String id = users.get(i);
            String banned = banned_id[i];

            if (id.length() != banned.length()) {
                return;
            }

            for (int j = 0; j < id.length(); j++) {
                if (banned.charAt(j) != '*') {
                    if (id.charAt(j) != banned.charAt(j)) {
                        return;
                    }
                }
            }
        }
        String[] ids = users.stream().toArray(String[]::new);
        Arrays.sort(ids);
        StringBuilder sb = new StringBuilder();
        for (String id : ids) {
            sb.append(id);
        }
        set.add(sb.toString());
    }
}
