package LV2.프린터;

import java.util.*;

class Solution2 {
    Queue<Process> q = new LinkedList<>();

    public int solution(int[] priorities, int location) {
        int answer = 0;
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Process(i, priorities[i]));
        }

        int turn = 0;

        while (!q.isEmpty()) {
            int max = getMax();
            Process process = q.poll();
            if (max == process.pri) {
                turn++;
                if (process.idx == location) {
                    break;
                }
            } else {
                q.offer(process);
            }
        }

        return turn;
    }

    private int getMax() {
        int max = 0;

        for (Process pro : q) {
            max = Math.max(max, pro.pri);
        }
        return max;
    }


    static class Process {
        int idx;
        int pri;

        public Process(int idx, int pri) {
            this.idx = idx;
            this.pri = pri;
        }
    }
}