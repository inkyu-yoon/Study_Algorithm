package LV3.이중우선순위큐;

import java.util.*;

class Solution2 {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> pqDesc = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pqAsc = new PriorityQueue<>();

        for (String op : operations) {
            String[] input = op.split(" ");
            String cmd = input[0];
            int num = Integer.parseInt(input[1]);
            if (cmd.equals("I")) {
                pqDesc.offer(num);
                pqAsc.offer(num);
            } else {
                if (!pqDesc.isEmpty()) {
                    if (num == 1) {
                        pqAsc.remove(pqDesc.poll());
                    } else {
                        pqDesc.remove(pqAsc.poll());
                    }
                }
            }
        }


        return pqDesc.isEmpty() ? new int[]{0, 0} : new int[]{pqDesc.poll(), pqAsc.poll()};
    }
}
