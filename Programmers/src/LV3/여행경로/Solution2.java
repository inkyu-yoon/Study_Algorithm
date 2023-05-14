package LV3.여행경로;

import java.util.PriorityQueue;
import java.util.Stack;

class Solution2 {
    Stack<String[]> s = new Stack<>();
    boolean[] checked;
    PriorityQueue<String> pq = new PriorityQueue<>();

    public String[] solution(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                checked = new boolean[tickets.length];
                s.push(tickets[i]);
                checked[i] = true;
                bt(tickets);
                s.clear();
            }
        }
        return pq.poll().split(" ");
    }

    void bt(String[][] tickets) {
        if (s.size() == tickets.length) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.get(0)[0] + " ");
            sb.append(s.get(0)[1] + " ");
            for (int i = 1; i < s.size(); i++) {
                sb.append(s.get(i)[1] + " ");
            }
            pq.offer(sb.toString());

            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (checked[i] || !s.peek()[1].equals(tickets[i][0])) {
                continue;
            }
            s.push(tickets[i]);
            checked[i] = true;
            bt(tickets);
            s.pop();
            checked[i] = false;
        }
    }
}